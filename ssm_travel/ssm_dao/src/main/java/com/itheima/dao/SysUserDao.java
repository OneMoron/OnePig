package com.itheima.dao;

import com.itheima.domain.SysRole;
import com.itheima.domain.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysUserDao {

    @Select("select * from sys_user")
    public List<SysUser> findAll();

    @Insert("insert into sys_user(username,email,password,phoneNum,status)" +
            "values(#{username},#{email},#{password},#{phoneNum},#{status})")
    public void save(SysUser sysUser);

    @Select("select * from sys_user where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "com.itheima.dao.SysUserDao.findByUid"))
    })
    public SysUser findByUsername(String username);

    @Select("select * from sys_role t,sys_user_role ur " +
            "where t.id = ur.roleid and ur.userid = #{uid}")
    public List<SysRole> findByUid(String uid);

    @Select("select * from sys_user where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "com.itheima.dao.SysUserDao.findByUid"))
    })
    public SysUser findDetail(String id);

    @Select("select * from sys_role where id not in " +
            "(select r.id from sys_role r,sys_user_role ur " +
            "where r.id = ur.roleid and ur.userid = #{id})")
    public List<SysRole> findAddRole(String id);

    @Insert("insert into sys_user_role(userid,roleid)values(#{userid},#{roleid})")
    public void addRoleToUser(@Param("userid") String userId,@Param("roleid")  String roleId);
}
