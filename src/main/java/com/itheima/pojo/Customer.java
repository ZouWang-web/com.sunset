package com.itheima.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {

    //客户编号(主键)
    private Integer custId;

    //客户名称(公司名称)
    private String custName;

    //客户信息来源
    private String custSource;

    //客户所属行业
    private String custIndustry;

    //客户级别
    private String custLevel;

    //客户联系地址
    private String custAddress;

    //客户联系电话
    private String custPhone;

    //创建时间
    private Date custCreateTime;



}
