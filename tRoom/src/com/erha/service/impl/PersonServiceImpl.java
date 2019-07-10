package com.erha.service.impl;

import com.erha.dao.impl.PersonDaoImpl;
import com.erha.model.Person;
import com.erha.service.PersonService;

public class PersonServiceImpl implements PersonService {

    PersonDaoImpl pdidao = new PersonDaoImpl();

    @Override
    public void doInitPerson() {
        pdidao.doInitPerson();
    }

    @Override
    public boolean doAddPersonToRoom(Person person) {
        boolean b =  pdidao.doAddPersonToRoom(person);
        if(b){
            System.out.println("新增成功!");
            return true;
        }else{
            System.out.println("新增失败!");
            return false;
        }
    }

    @Override
    public void doPrintAll() {
        pdidao.doPrintAll();
    }

    @Override
    public void doDelPersonToRoom() {
        pdidao.doDelPersonToRoom();
    }

    @Override
    public void doUpdPersonToRoom() {
        pdidao.doUpdPersonToRoom();
    }

    @Override
    public void doSelById() {
        pdidao.doSelById();
    }

}
