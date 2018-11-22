package com.itheima.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private String id;
    private String productNum;
    private String productName;
    private String cityName;
    private Date departureTime;
    private Double productPrice;
    private String productDesc;
    private Integer productStatus;

    //修改状态的显示
    public String getProductStatusStr() {
        return productStatus == 1 ? "开启" : "关闭";
    }

    //字符串类型的日期
    public String getdepartureTimeStr() {
        return departureTime != null ?
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(departureTime) : "暂无出发日期";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }
}
