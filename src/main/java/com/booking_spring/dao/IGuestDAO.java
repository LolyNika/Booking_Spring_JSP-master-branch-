package com.booking_spring.dao;

import com.booking_spring.dao.model.Guest;

import java.sql.SQLException;
import java.util.List;

public interface IGuestDAO {
    List<Guest> getGuest() throws SQLException;

    Guest createGuest(Guest guest) throws SQLException;

    void deleteGuest(int guestId) throws SQLException;

    Guest updateGuest(Guest guest) throws SQLException;

    Guest getById(int guestId) throws SQLException;

}
