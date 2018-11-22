package com.itheima.service.impl;

import com.itheima.dao.OrdersDao;
import com.itheima.domain.Orders;
import com.itheima.domain.PageBean;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    @Override
    public PageBean pageQuery(Integer pageNum, Integer pageSize) {
        Long total = ordersDao.findCount();
        PageBean pageBean = new PageBean(pageNum,pageSize,total);
        int startIndex = (pageNum - 1) * pageSize + 1;
        int endIndex = pageNum * pageSize;
        List list = ordersDao.pageQuery(startIndex,endIndex);
        return pageBean;
    }
}


