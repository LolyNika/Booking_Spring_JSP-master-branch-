package com.booking_spring.services.services;

import com.booking_spring.services.dto.GuestDTO;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Guest
 *
 * @author LolyNika
 */
public interface IGuestService {
    /**
     * A method that adds information about a new guest
     *
     * @return object guestDTO
     */
    GuestDTO create(GuestDTO guestDTO) throws SQLException;
    /**
     * A method that outputs information about Guest
     *
     * @return List<Guest> filled in
     */
    List<GuestDTO> readAll() throws SQLException;
    /**
     * A method that searching information about a specific guest
     *
     * @return object guestDTO
     */
    GuestDTO read(int idGuest) throws SQLException;
    /**
     * A method that updates information about a specific guest
     *
     * @return object guestDTO
     */
    GuestDTO update(GuestDTO guestDTO) throws SQLException;
    /**
     * A method that deletes information about a specific guest
     *
     * @return object NULL
     */
    GuestDTO delete(int idGuest) throws SQLException;

}