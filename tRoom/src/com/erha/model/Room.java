package com.erha.model;

public class Room {
    private int rid;        // 房间编号
    private Person[] people;// 住宿的人
    private String type;    // 房间类型

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Person[] getPeople() {
        return people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Room() {
    }

    public Room(Person[] people, String type) {
        this.people = people;
        this.type = type;
    }

    public Room(int rid, Person[] people, String type) {
        this.rid = rid;
        this.people = people;
        this.type = type;
    }

    public String toString(){
        return "房间编号:"+rid+",当前人数:"+people.length+",房间类型:"+type;
    }
}
