package com.ajie.service;

import com.ajie.domain.Account;

import java.util.List;

/**
 * @author ajie
 * @date 2023/6/4
 * @description:
 */
public interface AccountService {
    public List<Account> findAll();
    public Account findById(Integer id);
    public void save(Account account);
    public void update(Account account);
    public void delete(Integer id);
}
