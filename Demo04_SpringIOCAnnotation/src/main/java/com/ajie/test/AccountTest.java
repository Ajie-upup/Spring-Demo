package com.ajie.test;

import com.ajie.config.SpringConfig;
import com.ajie.domain.Account;
import com.ajie.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author ajie
 * @date 2023/5/29
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(value = {"classpath:applicationContext.xml"}) // 加载 spring 核心配置文件
@ContextConfiguration(classes = {SpringConfig.class}) // 加载 spring 核心配置文件
public class AccountTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("lucy");
        account.setMoney(100d);
        accountService.save(account);
    }

    //测试查询
    @Test
    public void testFindById() {
        Account account = accountService.findById(3);
        System.out.println(account);
    }

    @Test
    public void findAll() {
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    //测试修改
    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(3);
        account.setName("jack");
        account.setMoney(2000d);
        accountService.update(account);
    }

    //测试删除
    @Test
    public void testDelete() {
        accountService.delete(3);
    }

}
