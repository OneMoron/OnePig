package com.itheima.service;

import com.itheima.domain.SysRole;

import java.util.List;

public interface SysRoleService {
    public List<SysRole> findAll();

    public void save(SysRole sysRole);
}
