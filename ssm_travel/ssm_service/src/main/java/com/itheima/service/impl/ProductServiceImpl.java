package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
//@RolesAllowed("ROLE_PRODUCT") //JAVA250规范注解
//@Secured("ROLE_PRODUCT") //spring security的注解
@PreAuthorize("hasAnyAuthority('ROLE_PRODUCT')") //spring el表达式
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll(Integer pageNum,Integer pageSize) {
        //调用pageHelper分页方法,调用此方法,她后面跟着的第一个mybatis查询会自动分页
        PageHelper.startPage(pageNum, pageSize);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findById(String id) {
        return productDao.findById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delBatch(String[] ids) {
        for (String id : ids) {
            productDao.deleteById(id);
        }
    }
}
