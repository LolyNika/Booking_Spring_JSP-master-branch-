package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.Roomstatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomstatusMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Roomstatus roomstatus = new Roomstatus();
        roomstatus.setRoomstatusId(rs.getInt("roomstatusId"));
        roomstatus.setName(rs.getString("name"));
        return roomstatus;
    }
}
