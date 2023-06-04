package com.ajie.dao.impl;

import com.ajie.dao.AccountDao;
import com.ajie.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.List;

/**
 * @author ajie
 * @date 2023/6/4
 * @description:
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));

        return list;
    }

    @Override
    public Account findById(Integer id) {
        String sql = "select * from account where id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), id);
        return account;
    }

    @Override
    public void update(Account account) {
        String sql = "update account set name = ? , money = ? where id = ?";
        jdbcTemplate.update(sql, account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void save(Account account) {
        String sql = "insert into account values (null,?,?)";
        jdbcTemplate.update(sql, account.getName(), account.getMoney());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from account where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
