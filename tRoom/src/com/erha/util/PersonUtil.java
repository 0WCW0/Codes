package com.erha.util;

import com.erha.model.Person;

import java.util.Scanner;

public class PersonUtil {

    Scanner in = new Scanner(System.in);

    // 1. 获取到新的人员对象
    public Person getPerson(String str) {
        System.out.println("请您输入需要" + str + "的人员编号:");
        int pid = in.nextInt();
        System.out.println("请您输入需要" + str + "的人员名称:");
        String name = in.next();
        System.out.println("请您输入需要" + str + "的人员性别:");
        String sex = in.next();

        Person person = new Person(pid, name, sex);
        return person;
    }

    //2. 获取id
    public int getId(String str){

        System.out.println("请你输入需要"+str+"的编号:");
        int pid=in.nextInt();

        return pid;
    }
}
