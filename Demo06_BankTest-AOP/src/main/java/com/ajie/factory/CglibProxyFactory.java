package com.ajie.factory;

import com.ajie.service.AccountService;
import com.ajie.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author ajie
 * @date 2023/6/2
 * @description:
 */
@Component
public class CglibProxyFactory {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionManager transactionManager;

    public AccountService createAccountServiceCglibProxy() {
        AccountService accountServiceProxy = null;
        /*
         * 参数一：目标对象的字节码对象
         * 参数二：动作类，实现增强功能
         * */
        accountServiceProxy = (AccountService)
                Enhancer.create(accountService.getClass(), new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects,
                                            MethodProxy methodProxy) throws Throwable {
                        Object result = null;
                        try {
                            // 1.开启事务
                            transactionManager.beginTransaction();
                            // 2.业务操作
                            result = method.invoke(accountService, objects);
                            // 3.提交事务
                            transactionManager.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            // 4.回滚事务
                            transactionManager.rollback();
                        } finally {
                            // 5.释放资源
                            transactionManager.release();
                        }
                        return result;
                    }
                });
        return accountServiceProxy;
    }
}
