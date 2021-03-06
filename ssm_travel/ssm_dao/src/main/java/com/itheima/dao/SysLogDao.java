package com.itheima.dao;

import com.itheima.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

public interface SysLogDao {
    @Insert("insert into sys_log (visitTime, username, ip, url, executionTime, method)" +
            "values (#{visitTime}, #{username}, #{ip}, #{url}, #{executionTime}, #{method})")
    public void save(SysLog sysLog);
}
