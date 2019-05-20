package com.xiong.config.dataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceConfig
 * @Description 数据源配置
 * @Author xiong
 * @Date 2019/3/1 10:48
 * @Version 1.0
 **/
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "fstbloodDataSource")
    @ConfigurationProperties("spring.datasource.druid.fstblood")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "doublekillDataSource")
    @ConfigurationProperties("spring.datasource.druid.doublekill")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

//    @Primary    //配置该数据源为主数据源
//    @Bean(name = "fstbloodDataSource")
//    @Qualifier("fstbloodDataSource")
//    @ConfigurationProperties(prefix = "datasource.fstblood")
//    public DataSource fstbloodDataSource() {
//        return DataSourceBuilder.create().build();
//    }


    @Bean(name = "fstbloodJdbcTemplate")
    public JdbcTemplate fstbloodJdbcTemplate(@Qualifier("fstbloodDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

//    @Bean(name = "doublekillDataSource")
//    @Qualifier("doublekillDataSource")
//    @ConfigurationProperties(prefix = "datasource.doublekill")
//    public DataSource doublekillDataSource() {
//        return DataSourceBuilder.create().build();
//    }


    @Bean(name = "doublekillJdbcTemplate")
    public JdbcTemplate doublekillJdbcTemplate(@Qualifier("doublekillDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
