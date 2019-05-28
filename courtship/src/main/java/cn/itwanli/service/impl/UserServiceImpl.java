package cn.itwanli.service.impl;

import cn.itwanli.dao.UserDao;
import cn.itwanli.pojo.User;
import cn.itwanli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User login(User user) {
        return this.userDao.login(user);
    }

    @Override
    public int register(User user) {
        return this.userDao.register(user);
    }

    @Override
    public int doAddU(User user) {
        return this.userDao.doAddU(user);
    }

    @Override
    public int doDelU(int id) {
        return this.userDao.doDelU(id);
    }

    @Override
    public int doUpdU(User user) {
        return this.userDao.doUpdU(user);
    }

    @Override
    public User selByIdU(int id) {
        return this.userDao.selByIdU(id);
    }

    @Override
    public List<User> selByAllU() {
        return this.userDao.selByAllU();
    }

    @Override
    public List<User> selByLikeU(String username) {
        return this.userDao.selByLikeU(username);
    }

    @Override
    public List<User> showlist(int startIndex) {
        return this.userDao.showlist(startIndex);
    }

    @Override
    public int pagecount() {
        return this.userDao.pagecount();
    }
}
