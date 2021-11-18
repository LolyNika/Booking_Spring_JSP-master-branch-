package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.Roomstatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * The class is a mapper for RoomstatusDaoImpl
 * Here tables mapped: roomstatus
 * @author LolyNika
 */
public class RoomstatusMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Roomstatus roomstatus = new Roomstatus();
        roomstatus.setRoomstatusId(rs.getInt("roomstatusId"));
        roomstatus.setNameStatus(rs.getString("nameStatus"));
        return roomstatus;
    }
}
