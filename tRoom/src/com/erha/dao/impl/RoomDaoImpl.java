package com.erha.dao.impl;

import com.erha.dao.RoomDao;
import com.erha.model.Person;
import com.erha.model.Room;

public class RoomDaoImpl implements RoomDao {

    Room[] rooms = new Room[10];

    /**
     * 1. 获取宿舍提供有效住宿房间
     * @return 多个房间返回
     */
    @Override
    public Room[] getRooms() {

        // （1）定义前6个房间为男生宿舍
        for(int i =0;i<=5;i++){
            rooms[i] = new Room((i+100),new Person[6],"男");
        }

        // （2）定义后4个房间为女生宿舍
        for(int i=6;i<rooms.length;i++){
            rooms[i] = new Room((i+100),new Person[6],"女");
        }

        return rooms;
    }
}
