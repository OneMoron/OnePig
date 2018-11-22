package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductDao {
    @Select("select * from product")
    public List<Product> findAll();

    @Insert("insert into product (productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus)" +
            "values(#{productNum},#{ productName},#{ cityName},#{ departureTime},#{ productPrice},#{ productDesc}, #{productStatus})")
    public void save(Product product);

    @Select("select * from product where id = #{id}")
    public Product findById(String id);

    @Update("update product set " +
            "productNum = #{productNum}, productName= #{productName}, cityName=#{cityName}, departureTime=#{departureTime}, productPrice=#{productPrice}, productDesc=#{productDesc}, productStatus=#{productStatus}")
    public void update(Product product);

    @Delete("delete from product where id = #{id}")
    public void deleteById(String id);
}
