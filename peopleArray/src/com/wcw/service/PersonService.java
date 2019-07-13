package com.wcw.service;

public interface PersonService {
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
