package com.ajie.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author ajie
 * @date 2023/5/29
 * @description:
 */
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {
    @Value("${jdbc.DriverClassName}")
    private String driver;
    @Value("${jdbc.URL}")
    private String url;
    @Value("${jdbc.Username}")
    private String username;
    @Value("${jdbc.Password}")
    private String password;

    @Bean("dataSource")
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
