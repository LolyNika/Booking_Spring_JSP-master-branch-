package com.booking_spring.dao;

import com.booking_spring.dao.model.Booking;

import java.sql.SQLException;
import java.util.List;

public interface IBookingDAO {
    List<Booking> getBooking() throws SQLException;

    Booking createBooking(Booking booking) throws SQLException;

    void deleteBooking(int bookingId) throws SQLException;

    Booking updateBooking(Booking booking) throws SQLException;

    Booking getById(int bookingId) throws SQLException;

}
