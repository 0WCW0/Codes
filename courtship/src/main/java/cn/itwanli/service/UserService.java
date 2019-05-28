package cn.itwanli.service;

import cn.itwanli.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
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
