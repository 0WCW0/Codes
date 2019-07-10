package com.erha.dao.impl;

import com.erha.dao.PersonDao;
import com.erha.model.Person;
import com.erha.model.Room;

import java.util.Scanner;

public class PersonDaoImpl implements PersonDao {

    Scanner in = new Scanner(System.in);

    // 获取宿舍部分
    RoomDaoImpl rdi = new RoomDaoImpl();
    Room[] rooms = rdi.getRooms();

    /**
     * 1. 初始化人
     */
    @Override
    public void doInitPerson() {
        Person p1 = new Person(1001, "刘德华", "男");
        Person p2 = new Person(1002, "刘烨", "男");

        Person p3 = new Person(1003, "刘若英", "女");

        rooms[0].getPeople()[0] = p1;
        rooms[0].getPeople()[1] = p2;

        rooms[6].getPeople()[0] = p3;
    }


    /**
     * 2. 新增数据
     *
     * @param person ： 来源来自于PersonUtil
     * @return true 代表成功,false 代表失败
     */
    @Override
    public boolean doAddPersonToRoom(Person person) {

        // 首先应该找到空宿舍：对应到相应的男生宿舍还是女生宿舍
        // 代表男生宿舍
        if (person.getSex().equals("男")) {
            for (int i = 0; i < 6; i++) {// 宿舍
                for (int j = 0; j < rooms[i].getPeople().length; j++) {// 每个宿舍的人
                    if (rooms[i].getPeople()[j] == null) {
                        rooms[i].getPeople()[j] = person;
                        return true;
                    }
                }
            }
        }
        // 代表女生宿舍
        else if (person.getSex().equals("女")) {
            for (int i = 6; i < rooms.length; i++) {   // 宿舍
                for (int j = 0; j < rooms[i].getPeople().length; j++) { // 每个宿舍的人
                    if (rooms[i].getPeople()[j] == null) {
                        rooms[i].getPeople()[j] = person;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * 3. 打印住宿的所有信息
     */
    @Override
    public void doPrintAll() {
        // 首先需要找到宿舍
        for (int i = 0; i < rooms.length; i++) {

            // 刚开始每个宿舍都是没有人的
            int num = 0;
            // 打印住宿人员信息
            //判空
            if (rooms[i].getPeople() != null) {
                //遍历宿舍里每个人
                for (int j = 0; j < rooms[i].getPeople().length; j++) {
                    //判空
                    if (rooms[i].getPeople()[j] != null) {
                        num++;
                    }
                }
                // 打印宿舍的信息
                System.out.println("*当前宿舍为:" + rooms[i].getRid() + ",\t此宿舍当前人数为:" + num + ",\t宿舍类型为:" + rooms[i].getType() + "生宿舍*");

                //遍历宿舍中每个人
                for (int j = 0; j < rooms[i].getPeople().length; j++) {
                    //判空
                    if (rooms[i].getPeople()[j] != null) {
                        //打印输出
                        System.out.println("{"+rooms[i].getPeople()[j]+"}");
                        System.out.println("----------------------------------------");
                    }
                }
            }
            System.out.println();
        }
    }

    /**
    删除
     */
    @Override
    public void doDelPersonToRoom() {

        System.out.println("输入删除编号：");
        int did =in.nextInt();

        //遍历所有宿舍
        for (int i = 0; i < rooms.length; i++) {
            //遍历宿舍里所有人
            for (int j = 0; j < rooms[i].getPeople().length; j++) {
                //判空 id验证
                if (rooms[i].getPeople()[j]!=null && rooms[i].getPeople()[j].getPid()==did){
                    //数组附空值——删除
                    rooms[i].getPeople()[j]=null;
                    break;
                }
                //错误提示
                else if (rooms[i].getPeople()[j]==null){
                    System.out.println("*输入有误*");
                    break;
                }
            }
            System.out.println("----------------------------------------");
            break;
        }

    }

    /**
     *修改
     */
    @Override
    public void doUpdPersonToRoom() {

        System.out.println("输入需要修改的编号：");
        int uid=in.nextInt();

        //遍历每个宿舍
        for (int i = 0; i < rooms.length; i++) {
            //遍历宿舍里每个人
            for (int j = 0; j < rooms[i].getPeople().length; j++) {
                //判空 id验证
                if (rooms[i].getPeople()[j]!=null && rooms[i].getPeople()[j].getPid()==uid){
                    //修改信息
                    System.out.println("修改姓名：");
                    String pname=in.next();
                    rooms[i].getPeople()[j].setName(pname);

                    //输出修改后数组
                    System.out.println(rooms[i].getPeople()[j]);
                    break;
                }
                //错误提示
                else if (rooms[i].getPeople()[j]==null){
                    System.out.println("*输入有误*");
                    break;
                }
            }
            System.out.println("----------------------------------------");
            break;
        }

    }

    /**
     *单查
     */
    @Override
    public void doSelById() {

        System.out.println("输入查询编号：");
        int sid = in.nextInt();

        //遍历每个宿舍
        for (int i = 0; i < rooms.length; i++) {
            //遍历宿舍里的每个人
            for (int j = 0; j < rooms[i].getPeople().length; j++) {
                //判空、id验证
                if (rooms[i].getPeople()[j]!=null) {
                    if (rooms[i].getPeople()[j].getPid() == sid){
                        //输出查询结果
                        System.out.println(rooms[i].getPeople()[j]);
                        break;
                    }
                }
                //错误提示
                else if (rooms[i].getPeople()[j]==null){
                    System.out.println("*输入有误*");
                    break;
                }
            }
            break;
        }


    }

    /**
     *白盒测试
     */
    public static void main(String[] args) {
        PersonDaoImpl pdi = new PersonDaoImpl();

        //初始化
        pdi.doInitPerson();
        pdi.doPrintAll();

        //单查
        pdi.doSelById();

        //删除
//        pdi.doDelPersonToRoom();
//        pdi.doPrintAll();

        //修改
//        pdi.doUpdPersonToRoom();
//        pdi.doPrintAll();

    }

}
