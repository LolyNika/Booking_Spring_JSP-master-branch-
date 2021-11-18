package com.booking_spring.dao;

import com.booking_spring.dao.model.Room;

import java.sql.SQLException;
import java.util.List;

public interface IRoomDAO {
    List<Room> getRoom() throws SQLException;

    Room createRoom(Room room) throws SQLException;

    void deleteRoom(int roomId) throws SQLException;

    Room updateRoom(Room room) throws SQLException;

    Room getById(int roomId) throws SQLException;

}
