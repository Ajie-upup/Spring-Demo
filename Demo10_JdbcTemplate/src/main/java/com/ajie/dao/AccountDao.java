package com.ajie.dao;

import com.ajie.domain.Account;

import java.util.List;

/**
 * @author ajie
 * @date 2023/6/4
 * @description:
 */
public interface AccountDao {


    public List<Account> findAll();

    public Account findById(Integer id);

    public void update(Account account);

    public void save(Account account);

    public void deleteById(Integer id);

}
