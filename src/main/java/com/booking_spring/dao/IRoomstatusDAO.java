package com.booking_spring.dao;

import com.booking_spring.dao.model.Roomstatus;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Roomstatus
 *
 * @author LolyNika
 */
public interface IRoomstatusDAO {
    /**
     * A method that outputs information about Roomstatus
     *
     * @return List<Roomstatus> filled in
     */
    List<Roomstatus> getRoomstatus() throws SQLException;
    /**
     * A method that adds information about a new roomstatus to the Roomstatus table
     *
     * @return object Roomstatus
     */
    Roomstatus createRoomstatus(Roomstatus roomstatus) throws SQLException;
    /**
     * A method that deletes information about a specific roomstatus in the Roomstatus table
     */
    void deleteRoomstatus(int roomstatusId) throws SQLException;
    /**
     * A method that updates information about a specific roomstatus in the Roomstatus table
     *
     * @return object Roomstatus
     */
    Roomstatus updateRoomstatus(Roomstatus roomstatus) throws SQLException;
    /**
     * A method that searching information about a specific roomstatus in the Roomstatus table
     *
     * @return object Roomstatus
     */
    Roomstatus getById(int roomstatusId) throws SQLException;

}