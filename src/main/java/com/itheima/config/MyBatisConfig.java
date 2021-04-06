package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@PropertySource("classpath:jdbc.properties") //引入外部配置
@MapperScan("com.itheima.dao") //注解扫描dao层的接口，创建对象。
public class MyBatisConfig {


    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverClass}")
    private String driverClass;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();

        //设置连接参数
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClass);

        return dataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置实体别名映射
        sqlSessionFactoryBean.setTypeAliasesPackage("com.itheima.pojo");
        //设置mapper映射文件的位置,此处不设，因为mybatis也采用纯注解开发
        //sqlSessionFactoryBean.se
        //此处的configuration用来存放<settings>标签相关配置
        Configuration configuration = new Configuration();
        //设置驼峰映射
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);


        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }
}
