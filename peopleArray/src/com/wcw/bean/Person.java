package com.wcw.bean;

public class Person {
    private int pid;        // 编号
    private String name;    // 姓名
    private String sex;     // 性别

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Person(int pid, String name, String sex) {
        this.pid = pid;
        this.name = name;
        this.sex = sex;
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Person() {
    }

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
}
