package com.ajie.service.impl;

import com.ajie.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author ajie
 * @date 2023/6/2
 * @description:
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public void transfer() {
        System.out.println("执行转账业务....");
    }
}
