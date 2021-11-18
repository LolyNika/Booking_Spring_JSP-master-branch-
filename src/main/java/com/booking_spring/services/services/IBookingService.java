package com.booking_spring.services.services;

import com.booking_spring.services.dto.BookingDTO;

import java.sql.SQLException;
import java.util.List;

public interface IBookingService {
    BookingDTO create(BookingDTO bookingDTO) throws SQLException;

    List<BookingDTO> readAll() throws SQLException;

    BookingDTO read(int bookingId) throws SQLException;

    BookingDTO update(BookingDTO bookingDTO) throws SQLException;

    void delete(int bookingId) throws SQLException;

}
