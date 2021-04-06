package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.itheima.controller")
@EnableWebMvc //注解驱动
public class SpringMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        //释放静态资源
        configurer.enable();

        //super.configureDefaultServletHandling(configurer);
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        //设置视图解析器的前缀和后缀
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/jsp/");

        return viewResolver;
    }
}
