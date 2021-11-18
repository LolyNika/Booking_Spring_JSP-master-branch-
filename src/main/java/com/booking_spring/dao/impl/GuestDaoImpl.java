package com.booking_spring.dao.impl;

import com.booking_spring.dao.IGuestDAO;
import com.booking_spring.dao.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
/**
 * A class that implements IGuestDAO
 *
 * @author LolyNika
 */
@Repository
public class GuestDaoImpl implements IGuestDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public GuestDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Guest> getGuest() {
        String SQL = "select * from booking.guest inner join booking.user ON (booking.guest.`userId` = booking.user.`userId`)" +
                "inner join booking.userrole ON (booking.user.`roleId` = booking.userrole.`roleId`)\t";
        return (List<Guest>) jdbcTemplate.query(SQL, new GuestMapper());
    }

    @Override
    public Guest createGuest(Guest guest) {
        String SQL = "INSERT INTO guest (idguest, nameGuest, mobile, email, address, userId, roleId) VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(SQL, guest.getIdGuest(), guest.getNameGuest(), guest.getMobile(), guest.getEmail(), guest.getAddress(), guest.getUser().getUserId(), guest.getUserRole_guests().getRoleId());
        return guest;
    }

    @Override
    public void deleteGuest(int idGuest) {
        String SQL = "DELETE FROM guest WHERE idGuest = ?";
        jdbcTemplate.update(SQL, idGuest);
    }

    @Override
    public Guest updateGuest(Guest guest) {
        String SQL = "UPDATE guest inner join booking.user ON (booking.guest.`userId` = booking.user.`userId`) SET nameGuest = ?, mobile = ?, email = ?, address = ? WHERE idguest = ?";
        jdbcTemplate.update(SQL, guest.getNameGuest(), guest.getMobile(), guest.getEmail(), guest.getAddress(), guest.getIdGuest());
        return guest;
    }

    @Override
    public Guest getById(int idGuest) throws SQLException {
        String SQL = "SELECT * FROM booking.guest " +
                "inner join booking.user ON (booking.guest.`userId` = booking.user.`userId`) " +
                "inner join booking.userrole ON (booking.user.`roleId` = booking.userrole.`roleId`)" +
                "WHERE idGuest = ?";
        Guest guest = (Guest) jdbcTemplate.queryForObject(SQL, new Object[]{idGuest}, new GuestMapper());
        return guest;
    }}
