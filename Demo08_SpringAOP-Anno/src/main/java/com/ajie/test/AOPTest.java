package com.ajie.test;

import com.ajie.config.SpringConfig;
import com.ajie.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ajie
 * @date 2023/6/4
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class AOPTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void before() {
        accountService.transfer();
    }

}
