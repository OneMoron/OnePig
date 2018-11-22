package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll(Integer pageNum,Integer pageSize);

    public void save(Product product);

    public Product findById(String id);

    public void update(Product product);

    public void delBatch(String[] ids);
}
