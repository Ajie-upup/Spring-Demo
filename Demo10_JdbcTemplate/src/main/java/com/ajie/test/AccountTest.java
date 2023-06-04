package com.ajie.test;


import com.ajie.domain.Account;
import com.ajie.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author ajie
 * @date 2023/6/4
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testFindAll() {
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }


}
