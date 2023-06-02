package com.ajie.factory;

import com.ajie.service.AccountService;
import com.ajie.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ajie
 * @date 2023/6/2
 * @description: jdk 代理工厂
 */
@Component
public class JdkProxyFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;

    public AccountService createAccountServiceJdkProxy() {
        AccountService accountServiceProxy = null;

        accountServiceProxy = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        try {
                            // 1. 开启事务
                            transactionManager.beginTransaction();
                            // 2. 执行原方法
                            result = method.invoke(accountService, args);
                            // 3. 提交事务
                            transactionManager.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            // 事务回滚
                            transactionManager.rollback();
                        } finally {
                            // 释放资源
                            transactionManager.release();
                        }

                        return result;
                    }
                });
        return accountServiceProxy;
    }


}
