package com.itwanli.dao;

import com.itwanli.bean.Grade;

import java.util.List;

public interface GradeDao {
    int doInsG(Grade grade);     // 3.增加
    int doDelG(int gid);      // 4.删除

    Grade doLoadG(int gid);
    int doUpdG(Grade grade);   // 5.更新

    List<Grade> findByPageNum(int startIndex); // Page类是用来做分页
    int getRecordsNum();    // 6. 获取总记录数量：你需要先获取到总数量,每页分5条;总数量/5

    List<Grade> doSelByLikeG(String sname);
}
