package com.booking_spring.services.services;

import com.booking_spring.services.dto.BookingDTO;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Booking
 *
 * @author LolyNika
 */
public interface IBookingService {
    /**
     * A method that adds information about a new booking
     *
     * @return object bookingDTO
     */
    BookingDTO create(BookingDTO bookingDTO) throws SQLException;
    /**
     * A method that outputs information about booking
     *
     * @return List<BookingDTO> filled in
     */
    List<BookingDTO> readAll() throws SQLException;
    /**
     * A method that searching information about a specific booking
     *
     * @return object bookingDTO
     */
    BookingDTO read(int idBooking) throws SQLException;
    /**
     * A method that updates information about a specific booking
     *
     * @return object bookingDTO
     */
    BookingDTO update(BookingDTO bookingDTO) throws SQLException;
    /**
     * A method that deletes information about a specific booking
     *
     * @return object NULL
     */
    BookingDTO delete(int idBooking) throws SQLException;

}