package com.ajie.dao.impl;

import com.ajie.dao.AccountDao;
import com.ajie.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * @author ajie
 * @date 2023/5/29
 * @description:
 */
public class AccountDaoImpl implements AccountDao {

    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accountList = null;
        String sql = "select * from account";
        try {
            accountList = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public Account findById(Integer id) {
        Account account = null;
        String sql = "select * from account where id = ?";
        try {
            account = queryRunner.query(sql, new BeanHandler<Account>(Account.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void save(Account account) {
        String sql = "insert into account values (null,?,?)";
        try {
            queryRunner.update(sql, account.getName(), account.getMoney());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {
        String sql = "update account set name = ? , money = ? where id = ?";
        try {
            queryRunner.update(sql, account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from account where id = ?";
        try {
            queryRunner.update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
