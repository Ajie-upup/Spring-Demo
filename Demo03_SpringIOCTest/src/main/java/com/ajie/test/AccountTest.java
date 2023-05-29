package com.ajie.test;

import com.ajie.domain.Account;
import com.ajie.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author ajie
 * @date 2023/5/29
 * @description:
 */
public class AccountTest {

    ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    AccountService accountService = classPathXmlApplicationContext.getBean(AccountService.class);

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
