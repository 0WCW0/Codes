package com.itwanli.service.impl;

import com.itwanli.bean.User;
import com.itwanli.dao.impl.UserDaoImpl;
import com.itwanli.service.UserService;

public class UserServiceImpl implements UserService {

    // 使用框架 - 调用dao
    UserDaoImpl userDao = new UserDaoImpl();

    /**
     * 实现用户登录的业务功能
     */
    @Override
    public int login(User currentUser) {
        // 数据来源
        return userDao.doLogin(currentUser);
    }

    @Override
    public User getAdminInfo(String username, String password) {
        return userDao.getAdminInfo(username,password);
    }
}
