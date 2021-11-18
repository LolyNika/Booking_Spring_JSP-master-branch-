package com.booking_spring.services.services;

import com.booking_spring.services.dto.BookingDTO;
import com.booking_spring.services.dto.GuestDTO;

import java.sql.SQLException;
import java.util.List;

public interface IGuestService {
    GuestDTO create(GuestDTO guestDTO) throws SQLException;

    List<GuestDTO> readAll() throws SQLException;

    GuestDTO read(int guestId) throws SQLException;

    GuestDTO update(GuestDTO guestDTO) throws SQLException;

    void delete(int guestId) throws SQLException;

}
