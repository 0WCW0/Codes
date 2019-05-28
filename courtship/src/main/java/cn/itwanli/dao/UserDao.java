package cn.itwanli.dao;

import cn.itwanli.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User login(User user);

    int register(User user);

    int doAddU(User user);
    int doDelU(int id);
    int doUpdU(User user);

    User selByIdU(int id);
    List<User> selByAllU();
    List<User> selByLikeU(String username);

    List<User> showlist(int startIndex);
    int pagecount();
}
