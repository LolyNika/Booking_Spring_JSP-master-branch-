package com.booking_spring.services.services;

import com.booking_spring.services.dto.RoomstatusDTO;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Roomstatus
 *
 * @author LolyNika
 */
public interface IRoomstatusService {
    /**
     * A method that adds information about a new roomstatusDTO
     *
     * @return object roomstatusDTO
     */
    RoomstatusDTO create(RoomstatusDTO roomstatusDTO) throws SQLException;
    /**
     * A method that outputs information about roomstatusDTO
     *
     * @return List<RoomstatusDTO> filled in
     */
    List<RoomstatusDTO> readAll() throws SQLException;
    /**
     * A method that searching information about a specific roomstatusDTO
     *
     * @return object roomstatusDTO
     */
    RoomstatusDTO read(int roomstatusId) throws SQLException;
    /**
     * A method that updates information about a specific roomstatusDTO
     *
     * @return object roomstatusDTO
     */
    RoomstatusDTO update(RoomstatusDTO roomstatusDTO) throws SQLException;
    /**
     * A method that deletes information about a specific roomstatusDTO
     *
     * @return object NULL
     */
    RoomstatusDTO delete(int roomstatusId) throws SQLException;

}