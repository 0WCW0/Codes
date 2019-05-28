package com.itwanli.bean;

public class Student {
    private int sid;
    private String sname;
    private String sage;
    private String cl;

    public Student() {
    }

    public Student(int sid, String sname, String sage, String cl) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.cl = cl;
    }

    public Student(String sname, String sage, String cl) {
        this.sname = sname;
        this.sage = sage;
        this.cl = cl;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }
}
