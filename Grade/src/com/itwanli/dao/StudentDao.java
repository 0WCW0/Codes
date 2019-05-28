package com.itwanli.dao;

import com.itwanli.bean.Student;
import com.itwanli.bean.User;

import java.util.List;

public interface StudentDao {

    List<Student> findAll();    // 2.全查
    int doInsS(Student student);     // 3.增加
    int doDelS(int sid);      // 4.删除
    int selByName(Student student);

    // 加载部门的基本信息用于修改
    Student doLoadS(int sid);
    int doUpdS(Student student);   // 5.更新

    List<Student> findByPageNum(int startIndex); // Page类是用来做分页
    int getRecordsNum();    // 6. 获取总记录数量：你需要先获取到总数量,每页分5条;总数量/5

    List<Student> doSelByLikeS(String sname);

    User get_AidInfo2(String id);
    void doUpdSU(int id,String username, String password);
}
