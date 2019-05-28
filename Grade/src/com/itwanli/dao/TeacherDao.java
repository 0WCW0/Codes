package com.itwanli.dao;

import com.itwanli.bean.Teacher;

import java.util.List;

public interface TeacherDao {


    List<Teacher> findAll();    // 2.全查
    int doInsT(Teacher teacher);     // 3.增加
    int doDelT(int tid);      // 4.删除

    // 加载部门的基本信息用于修改
    Teacher doLoadT(int tid);
    int doUpdT(Teacher teacher);   // 5.更新
    List<Teacher> doSelByLikeT(String tname);

    List<Teacher> findByPageNum(int startIndex); // Page类是用来做分页
    int getRecordsNum();    // 6. 获取总记录数量：你需要先获取到总数量,每页分5条;总数量/5

}
