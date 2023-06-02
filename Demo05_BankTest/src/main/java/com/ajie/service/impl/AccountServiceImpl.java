package com.ajie.service.impl;

import com.ajie.dao.AccountDao;
import com.ajie.service.AccountService;
import com.ajie.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ajie
 * @date 2023/6/2
 * @description:
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionManager transactionManager;

    @Override
    public void transfer(String outUser, String inUser, Double money) {

        try {
            // 1. 开启事务
            transactionManager.beginTransaction();
            // 2. 业务操作
            accountDao.out(outUser, money);
            int i = 1 / 0;
            accountDao.in(inUser, money);
            // 3. 提交事务
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 出现异常，事务回滚
            transactionManager.rollback();
        } finally {
            // 最终释放资源
            transactionManager.release();
        }
    }
}
