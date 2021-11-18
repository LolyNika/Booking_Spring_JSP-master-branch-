package com.booking_spring.dao;

import com.booking_spring.dao.model.Booking;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Interface for CRUD Booking
 *
 * @author LolyNika
 */
public interface IBookingDAO {
    /**
     * A method that outputs information about Booking
     *
     * @return List<Booking> filled in
     */
    List<Booking> getBooking() throws SQLException;
    /**
     * A method that adds information about a new booking to the Booking table
     *
     * @return object Booking
     */
    Booking createBooking(Booking booking) throws SQLException;
    /**
     * A method that deletes information about a specific booking in the Booking table
     */
    void deleteBooking(int idbooking) throws SQLException;
    /**
     * A method that updates information about a specific booking in the Booking table
     *
     * @return object Booking
     */
    Booking updateBooking(Booking booking) throws SQLException;
    /**
     * A method that searching information about a specific booking in the Booking table
     *
     * @return object Booking
     */
    Booking getById(int idbooking) throws SQLException;

}