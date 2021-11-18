package com.booking_spring.services.services;

import com.booking_spring.services.dto.RoomDTO;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Room
 *
 * @author LolyNika
 */
public interface IRoomService {
    /**
     * A method that adds information about a new roomDTO
     *
     * @return object roomDTO
     */
    RoomDTO create(RoomDTO roomDTO) throws SQLException;
    /**
     * A method that outputs information about roomDTO
     *
     * @return List<RoomDTO> filled in
     */
    List<RoomDTO> readAll() throws SQLException;
    /**
     * A method that searching information about a specific roomDTO
     *
     * @return object roomDTO
     */
    RoomDTO read(int idRoom) throws SQLException;
    /**
     * A method that updates information about a specific roomDTO
     *
     * @return object roomDTO
     */
    RoomDTO update(RoomDTO RoomDTO) throws SQLException;
    /**
     * A method that deletes information about a specific roomDTO
     *
     * @return object NULL
     */
    RoomDTO delete(int idRoom) throws SQLException;

}