package com.booking_spring.dao;

import com.booking_spring.dao.model.Roomstatus;

import java.sql.SQLException;
import java.util.List;

public interface IRoomstatusDAO {
    List<Roomstatus> getRoomstatus() throws SQLException;

    Roomstatus createRoomstatus(Roomstatus roomstatus) throws SQLException;

    void deleteRoomstatus(int roomstatusId) throws SQLException;

    Roomstatus updateRoomstatus(Roomstatus roomstatus) throws SQLException;

    Roomstatus getById(int roomstatusId) throws SQLException;

}
