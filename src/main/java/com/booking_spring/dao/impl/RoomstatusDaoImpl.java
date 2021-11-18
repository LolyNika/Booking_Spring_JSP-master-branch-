package com.booking_spring.dao.impl;

import com.booking_spring.dao.IRoomstatusDAO;
import com.booking_spring.dao.model.Roomstatus;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RoomstatusDaoImpl implements IRoomstatusDAO {
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
    public List<Roomstatus> getRoomstatus() throws SQLException {
        List<Roomstatus> roomstatuses = new ArrayList<>();
        String SQL = "SELECT * FROM roomstatus";
        return (List<Roomstatus>) jdbcTemplate().query(SQL, new RoomstatusMapper());
    }

    @Override
    public Roomstatus createRoomstatus(Roomstatus roomstatus) throws SQLException {
        String SQL = "INSERT INTO roomstatus (roomstatusId, name) VALUES (?,?)";
        jdbcTemplate().update(SQL, roomstatus.getRoomstatusId(), roomstatus.getName());
        return roomstatus;
    }

    @Override
    public void deleteRoomstatus(int roomstatusId) throws SQLException {
        String SQL = "DELETE FROM roomstatus WHERE roomstatusId = ?";
        jdbcTemplate().update(SQL, roomstatusId);
    }

    @Override
    public Roomstatus updateRoomstatus(Roomstatus roomstatus) throws SQLException {
        String SQL = "UPDATE roomstatus SET name = ? WHERE roomstatusId = ?";
        jdbcTemplate().update(SQL, roomstatus.getName(), roomstatus.getRoomstatusId());
        return roomstatus;
    }

    @Override
    public Roomstatus getById(int roomstatusId) throws SQLException {
        String SQL = "SELECT * FROM roomstatus WHERE roomstatusId = ?";
        Roomstatus roomstatus = (Roomstatus) jdbcTemplate().queryForObject(SQL, new Object[]{roomstatusId}, new RoomstatusMapper());
        return roomstatus;
    }}
