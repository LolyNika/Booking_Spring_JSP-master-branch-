package com.booking_spring.dao.impl;

import com.booking_spring.dao.IRoomDAO;
import com.booking_spring.dao.model.Room;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RoomDaoImpl implements IRoomDAO {
    private final String driver = "com.mysql.cj.jdbc.Driver";

    private final String url = "jdbc:mysql://localhost:3306/booking";

    private final String name = "admin";

    private final String pass = "admin";
    public JdbcTemplate jdbcTemplate() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(name);
        basicDataSource.setPassword(pass);
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(basicDataSource);
        return jdbcTemplate;
    }
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Room> getRoom() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String SQL = "SELECT * FROM room";
        return (List<Room>) jdbcTemplate().query(SQL, new RoomMapper());
    }

    @Override
    public Room createRoom(Room room) throws SQLException {
        String SQL = "INSERT INTO room (roomid, name) VALUES (?,?)";
        jdbcTemplate().update(SQL, room.getRoomId(), room.getName());
        return room;
    }

    @Override
    public void deleteRoom(int roomId) throws SQLException {
        String SQL = "DELETE FROM room WHERE roomId = ?";
        jdbcTemplate().update(SQL, roomId);
    }

    @Override
    public Room updateRoom(Room room) throws SQLException {
        String SQL = "UPDATE room SET name = ? WHERE roomId = ?";
        jdbcTemplate().update(SQL, room.getName(), room.getRoomId());
        return room;
    }

    @Override
    public Room getById(int roomId) throws SQLException {
        String SQL = "SELECT * FROM room WHERE roomid = ?";
        Room room = (Room) jdbcTemplate().queryForObject(SQL, new Object[]{roomId}, new RoomMapper());
        return room;
    }}
