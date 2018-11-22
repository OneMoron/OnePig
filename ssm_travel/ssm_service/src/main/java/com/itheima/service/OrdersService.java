package com.itheima.service;

import com.itheima.domain.Orders;
import com.itheima.domain.PageBean;

import java.util.List;

public interface OrdersService {
    public List<Orders> findAll();

    public PageBean pageQuery(Integer pageNum, Integer pageSize);
}
