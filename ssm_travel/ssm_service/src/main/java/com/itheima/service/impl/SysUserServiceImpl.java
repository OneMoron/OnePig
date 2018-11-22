package com.itheima.service.impl;

import com.itheima.dao.SysUserDao;
import com.itheima.domain.SysRole;
import com.itheima.domain.SysUser;
import com.itheima.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

    @Override
    public void save(SysUser sysUser) {
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        sysUserDao.save(sysUser);
    }

    @Override
    public SysUser findDetail(String id) {
        return sysUserDao.findDetail(id);
    }

    @Override
    public List<SysRole> findAddRole(String id) {
        return sysUserDao.findAddRole(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String roleId : ids) {
            sysUserDao.addRoleToUser(userId, roleId);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户
        SysUser sysUser = sysUserDao.findByUsername(username);
        if (sysUser == null) {
            //表示登录失败
            return null;
        }

        //得到当前用户下的角色列表
        List<SysRole> sysRoles = sysUser.getRoles();
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        //new simpleGrantedAuthority("ROLE_USER")其实就是为了方便框架来拿角色
        for (SysRole sysRole : sysRoles) {
            roles.add(new SimpleGrantedAuthority(sysRole.getRolename()));
        }
        /**
         * 参数一:当前用户的角色名
         * 参数二:数据库查询出来的密码
         * 参数三:表示当前用户下角色的集合
         */
        User user = new User(sysUser.getUsername(), sysUser.getPassword(), roles);
        return user;
    }
}
