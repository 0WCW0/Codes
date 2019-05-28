package com.itwanli.dao;

import com.itwanli.bean.User;

import java.util.List;

public interface UserDao {
    int doLogin(User currentUser);
    User getAdminInfo(String username, String password);

    List<User> findAll();    // 2.全查
    int doInsU(User user);     // 3.增加
    int doDelU(int id);      // 4.删除

    // 加载部门的基本信息用于修改
    User doLoadU(int id);
    int doUpdU(User user);   // 5.更新
    int doUpdM(User user);
    User doLoadSM(int id);
    List<User> doSelByLikeU(String username);

    List<User> findByPageNum(int startIndex); // Page类是用来做分页
    int getRecordsNum();    // 6. 获取总记录数量：你需要先获取到总数量,每页分5条;总数量/5

}
