package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.Rate;
import com.booking_spring.dao.model.Room;
import com.booking_spring.dao.model.Roomstatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * The class is a mapper for RoomDaoImpl
 * Here tables mapped: room, rate, roomstatus
 * @author LolyNika
 */
public class RoomMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Room room = new Room();
        room.setIdRoom(rs.getInt("idroom"));
        room.setNameRoom(rs.getString("nameRoom"));

        Roomstatus roomstatus = new Roomstatus();
        roomstatus.setRoomstatusId(rs.getInt("idroomStatus"));
        roomstatus.setNameStatus(rs.getString("nameStatus"));

        Rate rate = new Rate();
        rate.setRateId(rs.getInt("idrate"));
        rate.setDate(rs.getInt("date"));
        rate.setPrice(rs.getInt("price"));

        room.setRoomstatus(roomstatus);
        room.setRate(rate);

        return room;
    }
}
