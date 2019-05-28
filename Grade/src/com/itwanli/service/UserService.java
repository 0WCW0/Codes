package com.itwanli.service;

import com.itwanli.bean.User;

public interface UserService {
    int login(User currentUser);
    User getAdminInfo(String username, String password);

}
