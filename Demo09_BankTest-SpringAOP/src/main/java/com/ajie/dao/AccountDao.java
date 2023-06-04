package com.ajie.dao;

/**
 * @author ajie
 * @date 2023/6/2
 * @description:
 */
public interface AccountDao {

    public void out(String outUser, Double money);

    public void in(String inUser, Double money);
}
