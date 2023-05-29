package com.ajie.dao;

import com.ajie.domain.Account;

import java.util.List;

/**
 * @author ajie
 * @date 2023/5/29
 * @description:
 */
public interface AccountDao {

    public List<Account> findAll();

    public Account findById(Integer id);

    public void save(Account account);

    public void update(Account account);

    public void delete(Integer id);
}
