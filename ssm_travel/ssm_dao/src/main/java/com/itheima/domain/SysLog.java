package com.itheima.domain;

import java.util.Date;

public class SysLog {
    private String id;//主键
    private Date visitTime;//访问时间
    private String username;//当前登录的用户名 xiaoma70
    private String ip;// 192.168.1.1
    private String url;// http:..../user/findAll
    private Long executionTime;// 在方法中停留时间
    private String method;// 方法名，一般会带上类名

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
