package com.itheima.dao;

import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "productid", column = "productid"),
            @Result(property = "product", column = "productid",
                    javaType = Product.class,
                    one = @One(select = "com.itheima.dao.ProductDao.findById"))
    })
    public List<Orders> findAll();

    @Select("select count(1) from orders")
    public Long findCount();

    @Select("select * from(" +
            "  select rownum rn, tt.* from(" +
            "    select * from orders" +
            "  ) tt where rownum <= #{end, jdbcType=INTEGER}" +
            ") where rn >= #{begin, jdbcType=INTEGER}")
    public List<Orders> pageQuery(@Param("begin") int startIndex, @Param("end") int endIndex);
}
