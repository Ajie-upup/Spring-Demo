package com.ajie.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author ajie
 * @date 2023/6/2
 * @description: 事务管理器工具类：开启事务、提交事务、回滚事务、释放资源
 */
@Component
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Around("execution(* com.ajie.service..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) {
        Object object = null;
        System.out.println("环绕通知。。。");
        try {
            // 开启事务
            connectionUtils.getThreadConnection().setAutoCommit(false);
            // 业务逻辑
            pjp.proceed();
            // 提交事务
            connectionUtils.getThreadConnection().commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 回滚事务
            try {
                connectionUtils.getThreadConnection().rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                connectionUtils.getThreadConnection().setAutoCommit(true);
                connectionUtils.getThreadConnection().close();
                connectionUtils.removeThreadConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return object;
    }


    public void beginTransaction() {
        // 关闭自动提交事务 --> 开启事务
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void release() {
        try {
            // 设置自动提交事务
            connectionUtils.getThreadConnection().setAutoCommit(true);
            // 释放连接
            connectionUtils.getThreadConnection().close();
            // 移除当前线程中的连接
            connectionUtils.removeThreadConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
