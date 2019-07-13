package com.wcw.service.impl;

import com.wcw.dao.impl.PersonDaoImpl;
import com.wcw.service.PersonService;

public class PersonServiceImpl implements PersonService {
    PersonDaoImpl personDao=new PersonDaoImpl();

    @Override
    public void doInit() {
        personDao.doInit();
    }

    @Override
    public boolean doAdd() {
        boolean b=personDao.doAdd();
        if (b){
            System.out.println("**********新增成功**********");
            return true;
        }else {
            System.out.println("**********新增失败**********");
            return false;
        }
    }

    @Override
    public void doPrintAll() {
        personDao.doPrintAll();
    }

    @Override
    public boolean doDel() {
        boolean b=personDao.doDel();
        if (b){
            System.out.println("**********删除成功**********");
            return true;
        }else {
            System.out.println("**********删除失败**********");
            return false;
        }
    }

    @Override
    public boolean doUpd() {
        boolean b=personDao.doUpd();
        if (b){
            System.out.println("**********修改成功**********");
            return true;
        }else {
            System.out.println("**********修改失败**********");
            return false;
        }
    }

    @Override
    public void doSelById() {
        personDao.doSelById();
    }
}
