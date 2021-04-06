package com.itheima.dao;

import com.itheima.pojo.Customer;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CustomerMapper {

    @Select("select * from customer")
    public List<Customer> findAll();


    @Update("update *from set where id=?")
    public  List<Customer> findByid();
}
