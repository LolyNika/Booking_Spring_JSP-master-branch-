package com.booking_spring.dao.impl;

import com.booking_spring.dao.IRoomstatusDAO;
import com.booking_spring.dao.model.Roomstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
/**
 * A class that implements IRoomstatusDAO
 *
 * @author LolyNika
 */
@Repository
public class RoomstatusDaoImpl implements IRoomstatusDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomstatusDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Roomstatus> getRoomstatus() {
        String SQL = "SELECT * FROM roomstatus";
        return (List<Roomstatus>) jdbcTemplate.query(SQL, new RoomstatusMapper());
    }

    @Override
    public Roomstatus createRoomstatus(Roomstatus roomstatus) {
        String SQL = "INSERT INTO roomstatus (roomstatusId, nameStatus) VALUES (?,?)";
        jdbcTemplate.update(SQL, roomstatus.getRoomstatusId(), roomstatus.getNameStatus());
        return roomstatus;
    }

    @Override
    public void deleteRoomstatus(int roomstatusId) {
        String SQL = "DELETE FROM roomstatus WHERE roomstatusId = ?";
        jdbcTemplate.update(SQL, roomstatusId);
    }

    @Override
    public Roomstatus updateRoomstatus(Roomstatus roomstatus) {
        String SQL = "UPDATE roomstatus SET nameStatus = ? WHERE roomstatusId = ?";
        jdbcTemplate.update(SQL, roomstatus.getNameStatus(), roomstatus.getRoomstatusId());
        return roomstatus;
    }

    @Override
    public Roomstatus getById(int roomstatusId) throws SQLException {
        String SQL = "SELECT * FROM roomstatus WHERE roomstatusId = ?";
        Roomstatus roomstatus = (Roomstatus) jdbcTemplate.queryForObject(SQL, new Object[]{roomstatusId}, new RoomstatusMapper());
        return roomstatus;
    }}
