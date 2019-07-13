package com.wcw.dao.impl;

import com.wcw.bean.Person;
import com.wcw.dao.PersonDao;

import java.util.Scanner;

public class PersonDaoImpl implements PersonDao {
    //定义数组
    Person[] p=new Person[77];
    //键盘
    Scanner in=new Scanner(System.in);

    /**
     * 初始化数组
     */
    @Override
    public void doInit() {
        //数据来源
        Person p1=new Person(1,"路飞","男");
        Person p2=new Person(2,"索隆","男");
        Person p3=new Person(3,"娜美","女");

        //数据存入数组
        p[0]=p1;
        p[1]=p2;
        p[2]=p3;

    }


    /**
     * 新增
     * @param: 键盘输入数据来源你
     * @return true 代表成功,false 代表失败
    */
    @Override
    public boolean doAdd() {
        //键盘提示+输入
        System.out.print("输入新增编号：");
        int aid=in.nextInt();
        System.out.print("输入新增姓名：");
        String aname=in.next();
        System.out.print("输入新增性别：");
        String asex=in.next();
        //放在一个新数组里
        Person person=new Person(aid,aname,asex);
        //遍历
        for (int i = 0; i < p.length; i++) {
            //判断是否已存在
            if (p[i]==null){
                //数组替换
                p[i]=person;
                return true;
            }
        }
        return false;
    }

//    /**
//     * 新增
//     */
//    @Override
//    public void doAdd() {
//        //键盘提示+输入
//        System.out.print("输入新增编号：");
//        int aid=in.nextInt();
//        System.out.print("输入新增姓名：");
//        String aname=in.next();
//        System.out.print("输入新增性别：");
//        String asex=in.next();
//        //放在一个新数组里
//        Person pp=new Person(aid,aname,asex);
//        //遍历
//        for (int i = 0; i < p.length; i++) {
//            //判断是否已存在
//            if (p[i]==null){
//                //数组替换
//                p[i]=pp;
//                System.out.println();
//                break;
//            }
//        }
//    }



    /**
     * 打印全部
     */
    @Override
    public void doPrintAll() {
        //输入提示
        System.out.println("全体信息：");
        //遍历
        for (int i = 0; i < p.length; i++) {
            //判空
            if (p[i]!=null){
                //打印输出
                System.out.println(p[i]);
            }
        }
    }

    /**
     * 删除
     * @return true 代表成功,false 代表失败
     */
    @Override
    public boolean doDel() {
        //输入提示
        System.out.print("输入删除编号：");
        int did=in.nextInt();
        //遍历
        for (int i = 0; i < p.length; i++) {
            //匹配判断
            if (p[i].getPid()==did){
                //赋空值删除
                p[i]=null;
                return true;
            }
        }
        return false;
    }

    /**
     * 修改
     * @return true 代表成功,false 代表失败
     */
    @Override
    public boolean doUpd() {
        //输入提示
        System.out.print("输入修改编号：");
        int uid=in.nextInt();
        //遍历
        for (int i = 0; i < p.length; i++) {
            //匹配判断
            if (p[i].getPid()==uid){
                System.out.print("修改姓名:");
                String uname=in.next();
                //将键盘输入的值set重置数组中的值
                p[i].setName(uname);

                System.out.print("修改性别：");
                String usex=in.next();
                p[i].setSex(usex);

                //提示输出修改后数组
                System.out.println("修改结果：");
                System.out.println(p[i]);
                return true;
            }
        }
        return false;
    }

    /**
     * id查
     */
    @Override
    public void doSelById() {
        //输入提示
        System.out.print("输入查询编号：");
        int sid=in.nextInt();
        //遍历
        for (int i = 0; i < p.length; i++) {
            //匹配判断
            if (p[i].getPid()==sid){
                System.out.println("查询结果：");
                //输出查询结果
                System.out.println(p[i]);
                break;
            }
        }

    }

    //白盒测试
    public static void main(String[] args) {
        PersonDaoImpl pdi=new PersonDaoImpl();
        //初始化
        pdi.doInit();
        //打印全部
        pdi.doPrintAll();
        //新增*
        pdi.doAdd();
        pdi.doPrintAll();

        //删除
//        pdi.doDel();
//        pdi.doPrintAll();
        //修改
//        pdi.doUpd();
//        pdi.doPrintAll();
        //查id
//        pdi.doSelById();


    }
}
