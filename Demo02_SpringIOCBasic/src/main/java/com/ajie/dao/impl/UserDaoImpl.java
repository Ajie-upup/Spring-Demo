package com.ajie.dao.impl;

import com.ajie.dao.UserDao;

/**
 * @author ajie
 * @date 2023/5/25
 * @description:
 */
public class UserDaoImpl implements UserDao {

    public void init() {
        System.out.println("初始化方法被调用了！");
    }

    public void destroy() {
        System.out.println("对象被销毁了！");
    }

    @Override
    public void save() {
        System.out.println("dao 方法被调用了....");
    }
}
