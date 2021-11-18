package com.booking_spring.dao;

import com.booking_spring.dao.model.Guest;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Guest
 *
 * @author LolyNika
 */
public interface IGuestDAO {
    /**
     * A method that outputs information about Guest
     *
     * @return List<Guest> filled in
     */
    List<Guest> getGuest() throws SQLException;
    /**
     * A method that adds information about a new guest to the Guest table
     *
     * @return object Guest
     */
    Guest createGuest(Guest guest) throws SQLException;
    /**
     * A method that deletes information about a specific guest in the Guest table
     */
    void deleteGuest(int idGuest) throws SQLException;
    /**
     * A method that updates information about a specific guest in the Guest table
     *
     * @return object Guest
     */
    Guest updateGuest(Guest guest) throws SQLException;
    /**
     * A method that searching information about a specific guest in the Guest table
     *
     * @return object Guest
     */
    Guest getById(int idGuest) throws SQLException;

}