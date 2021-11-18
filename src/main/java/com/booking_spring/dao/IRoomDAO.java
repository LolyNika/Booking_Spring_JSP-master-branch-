package com.booking_spring.dao;

import com.booking_spring.dao.model.Room;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Room
 *
 * @author LolyNika
 */
public interface IRoomDAO {
    /**
     * A method that outputs information about Room
     *
     * @return List<Room> filled in
     */
    List<Room> getRoom() throws SQLException;
    /**
     * A method that adds information about a new room to the Room table
     *
     * @return object Room
     */
    Room createRoom(Room room) throws SQLException;
    /**
     * A method that deletes information about a specific room in the Room table
     */
    void deleteRoom(int idroom) throws SQLException;
    /**
     * A method that updates information about a specific room in the Room table
     *
     * @return object Room
     */
    Room updateRoom(Room room) throws SQLException;
    /**
     * A method that searching information about a specific room in the Room table
     *
     * @return object Room
     */
    Room getById(int idroom) throws SQLException;

}