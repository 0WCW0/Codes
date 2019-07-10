package com.erha.model;

public class Person {
    private int pid;        // 编号
    private String name;    // 姓名
    private String sex;     // 性别

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person() {
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Person(int pid, String name, String sex) {
        this.pid = pid;
        this.name = name;
        this.sex = sex;
    }

    public String toString(){
        return "人员编号:"+pid+",人员姓名:"+name+",人员性别:"+sex;
    }
}
