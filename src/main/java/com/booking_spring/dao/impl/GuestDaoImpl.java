package com.booking_spring.dao.impl;

import com.booking_spring.dao.IGuestDAO;
import com.booking_spring.dao.model.Guest;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class GuestDaoImpl implements IGuestDAO {
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
    public List<Guest> getGuest() throws SQLException {
        List<Guest> guests = new ArrayList<>();
        String SQL = "SELECT * FROM guest";
        return (List<Guest>) jdbcTemplate().query(SQL, new GuestMapper());
    }
    @Override
    public Guest createGuest(Guest guest) throws SQLException {
        String SQL = "INSERT INTO guest (guestId, name, mobile, email, address) VALUES (?,?,?,?,?)";
        jdbcTemplate().update(SQL, guest.getGuestId(), guest.getName(), guest.getMobile(), guest.getEmail(), guest.getAddress());
        return guest;
    }

    @Override
    public void deleteGuest(int guestId) throws SQLException {
        String SQL = "DELETE FROM guest WHERE guestId = ?";
        jdbcTemplate().update(SQL, guestId);
    }

    @Override
    public Guest updateGuest(Guest guest) throws SQLException {
        String SQL = "UPDATE guest SET name = ?, mobile = ?, email = ?, address = ? WHERE guestId = ?";
        jdbcTemplate().update(SQL, guest.getName(), guest.getMobile(), guest.getEmail(), guest.getAddress(), guest.getGuestId());
        return guest;
    }

    @Override
    public Guest getById(int guestId) throws SQLException {
        String SQL = "SELECT * FROM guest WHERE roleId = ?";
        Guest guest = (Guest) jdbcTemplate().queryForObject(SQL, new Object[]{guestId}, new GuestMapper());
        return guest;
    }}
