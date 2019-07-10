package com.erha.service;

import com.erha.model.Person;

public interface PersonService {
    // 1. 先解决初始化人的问题
    void doInitPerson();

    // 2. 新增一个人员到宿舍中
    boolean doAddPersonToRoom(Person person);

    // 6. 全查住宿信息
    void doPrintAll();

    // 4. 删除住宿信息
    void doDelPersonToRoom();

    // 5. 修改住宿信息
    void doUpdPersonToRoom();

    // 6. 单查住宿信息
    void doSelById();
}
