package com.itwanli.bean;

public class Teacher {
    private int tid;
    private String tname;
    private String tage;

    public Teacher() {
    }

    public Teacher(int tid, String tname, String tage) {
        this.tid = tid;
        this.tname = tname;
        this.tage = tage;
    }

    public Teacher(String tname, String tage) {
        this.tname = tname;
        this.tage = tage;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTage() {
        return tage;
    }

    public void setTage(String tage) {
        this.tage = tage;
    }
}
