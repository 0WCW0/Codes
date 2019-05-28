package com.itwanli.bean;

public class Grade {
    private int gid;
    private String sname;
    private String cname;
    private String grade;

    public Grade() {
    }

    public Grade(int gid, String sname, String cname, String grade) {
        this.gid = gid;
        this.sname = sname;
        this.cname = cname;
        this.grade = grade;
    }

    public Grade(String sname, String cname, String grade) {
        this.sname = sname;
        this.cname = cname;
        this.grade = grade;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
