package com.itheima.dao;

import com.itheima.domain.SysRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleDao {
    @Select("select * from sys_role")
    public List<SysRole> findAll();

    @Insert("insert into sys_role (rolename,roledesc) values(#{rolename},#{roledesc})")
    public void save(SysRole sysRole);
}
