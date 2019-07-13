package com.wcw.dao;

public interface PersonDao {

    //初始化
    void doInit();

    //新增
    boolean doAdd();
//    void doAdd();

    //打印全部
    void doPrintAll();

    //删除
    boolean doDel();

    //修改
    boolean doUpd();

    //查id
    void doSelById();

}
