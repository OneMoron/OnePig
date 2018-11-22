package com.itheima.service;
/**
 * 在UserServiceDetail编写的业务是固定的.我们必须先根据用户输入的
 * 用户名查询当前用户.如果没有查询到,就返回null.返回null就意味着告诉
 * springsecurity框架登录失败了.如果查询到了本地数据库用户.要拿着当前数据库
 * 用户给springsecurity封装一个UserDetail用户,并返回给springsecurity框架.然后
 * 框架会自己判断是否登录.
 */

import com.itheima.domain.SysRole;
import com.itheima.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface SysUserService extends UserDetailsService{
    public List<SysUser> findAll();

    public void save(SysUser sysUser);

    public SysUser findDetail(String id);

    public List<SysRole> findAddRole(String id);

    public void addRoleToUser(String userId, String[] ids);
}
