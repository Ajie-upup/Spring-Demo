package com.ajie.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ajie
 * @date 2023/6/2
 * @description: 连接工具类，从数据源中获取一个连接，并将实现和线程的绑定
 */
@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    @Autowired
    private DataSource dataSource;

    /**
     * 获取当前线程上的连接
     */
    public Connection getThreadConnection() {
        // 1. 先从当前线程上获取
        Connection connection = threadLocal.get();
        // 2. 判断当前线程上的连接是否存在
        if (connection == null) {
            // 3. 不存在则从数据源中获取连接，并存放到当前线程中
            try {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }

    /**
     * 解除当前线程的连接绑定
     */
    public void removeThreadConnection() {
        threadLocal.remove();
    }

}
