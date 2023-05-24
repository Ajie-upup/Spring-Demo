package com.ajie.service.impl;

import com.ajie.dao.IUserDao;
import com.ajie.dao.impl.UserDaoImpl;
import com.ajie.service.IUserService;
import com.ajie.util.BeanFactory;

/**
 * @author ajie
 * @date 2023/5/24
 * @description:
 */
public class UserServiceImpl implements IUserService {
    /**
     * 使用 new 关键字创建容器对象
     */
    @Override
    public void save1() {
        // 每次都需要创建一个新的对象
        IUserDao userDao = new UserDaoImpl();
        userDao.save();
    }

    /**
     * 使用 反射 创建对象
     */
    @Override
    public void save2() {
        // 存在硬编码问题
        try {
            IUserDao userDao = (IUserDao) Class.forName("com.ajie.dao.impl.UserDaoImpl").newInstance();
            userDao.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save3() {
        IUserDao userDao = (IUserDao) BeanFactory.getBean("userDao");
        userDao.save();
    }


}
