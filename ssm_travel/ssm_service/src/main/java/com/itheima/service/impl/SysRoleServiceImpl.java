package com.itheima.service.impl;

import com.itheima.dao.SysRoleDao;
import com.itheima.domain.SysRole;
import com.itheima.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> findAll() {
        return sysRoleDao.findAll();
    }

    @Override
    public void save(SysRole sysRole) {
        sysRoleDao.save(sysRole);
    }
}
