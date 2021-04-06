package com.itheima.service.impl;

import com.itheima.dao.CustomerMapper;
import com.itheima.pojo.Customer;
import com.itheima.service.CustomerService;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll() {
        return customerMapper.findAll();
    }
}
