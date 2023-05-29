package com.ajie.service.impl;

import com.ajie.dao.UserDao;
import com.ajie.dao.impl.UserDaoImpl;
import com.ajie.service.UserService;

/**
 * @author ajie
 * @date 2023/5/25
 * @description:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("进入 service 层,使用构造方法注入");
        userDao.save();
    }


}
