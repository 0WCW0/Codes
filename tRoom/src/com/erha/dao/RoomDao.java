package com.erha.dao;

import com.erha.model.Room;

public interface RoomDao {
    // 1. 准备好宿舍 , 为了给别人住的
    Room[] getRooms();
}
