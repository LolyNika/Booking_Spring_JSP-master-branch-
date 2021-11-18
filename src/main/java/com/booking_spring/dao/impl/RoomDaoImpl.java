package com.booking_spring.dao.impl;

import com.booking_spring.dao.IRoomDAO;
import com.booking_spring.dao.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
/**
 * A class that implements IRoomDAO
 *
 * @author LolyNika
 */
@Repository
public class RoomDaoImpl implements IRoomDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Room> getRoom()  {
        String SQL = "SELECT * FROM booking.room inner join booking.roomstatus ON (booking.room.`idroomStatus` = booking.roomstatus.`idroomStatus`)\n" +
                " inner join booking.rate ON (booking.room.`idrate` = booking.rate.`idrate`);";
        return (List<Room>) jdbcTemplate.query(SQL, new RoomMapper());
    }

    @Override
    public Room createRoom(Room room)  {
        String SQL = "INSERT INTO room (idroom, nameRoom, idroomStatus, idrate) VALUES (?,?,?,?)";
        jdbcTemplate.update(SQL, room.getIdRoom(), room.getNameRoom(), room.getRoomstatus().getRoomstatusId(), room.getRate().getRateId());
        return room;
    }

    @Override
    public void deleteRoom(int idroom) {
        String SQL = "DELETE FROM room WHERE idroom = ?";
        jdbcTemplate.update(SQL, idroom);
    }

    @Override
    public Room updateRoom(Room room)  {
        String SQL = "UPDATE booking.room SET nameRoom = ?, idroomStatus = ? WHERE idroom = ?";
        jdbcTemplate.update(SQL, room.getNameRoom(), room.getRoomstatus().getRoomstatusId(), room.getIdRoom());
        return room;
    }

    @Override
    public Room getById(int idroom) throws SQLException {
        String SQL = "SELECT * FROM booking.room inner join booking.roomstatus ON (booking.room.`idroomStatus` = booking.roomstatus.`idroomStatus`)\n" +
                " inner join booking.rate ON (booking.room.`idrate` = booking.rate.`idrate`) WHERE idroom = ?";
        Room room = (Room) jdbcTemplate.queryForObject(SQL, new Object[]{idroom}, new RoomMapper());
        return room;
    }
}
