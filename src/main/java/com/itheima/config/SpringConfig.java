package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //声明当前是一个配置类
@ComponentScan(value = "com.itheima",
                excludeFilters = @ComponentScan.Filter(value = Controller.class))
//@EnableAspectJAutoProxy //开启aop注解
//@EnableTransactionManagement //开启注解事务
@Import(MyBatisConfig.class) //导入其他配置类
public class SpringConfig {
}
