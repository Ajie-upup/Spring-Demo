package com.ajie.test;

import com.ajie.factory.CglibProxyFactory;
import com.ajie.factory.JdkProxyFactory;
import com.ajie.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ajie
 * @date 2023/6/2
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountTest {

    @Autowired
    private JdkProxyFactory jdkProxyFactory;

    @Autowired
    private CglibProxyFactory cglibProxyFactory;

    /**
     * 测试 jdk 动态代理
     */
    @Test
    public void testTransfer() {
        AccountService accountServiceJdkProxy = jdkProxyFactory.createAccountServiceJdkProxy();
        accountServiceJdkProxy.transfer("tom", "jerry", 100d);
    }

    @Test
    public void testTransfer2() {
        AccountService accountServiceJdkProxy = cglibProxyFactory.createAccountServiceCglibProxy();
        accountServiceJdkProxy.transfer("tom", "jerry", 100d);
    }
}
