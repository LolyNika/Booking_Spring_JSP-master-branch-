package com.booking_spring.services.services;

import com.booking_spring.services.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD User
 *
 * @author LolyNika
 */
public interface IUserService {
    /**
     * A method that adds information about a new userDTO
     *
     * @return object userDTO
     */
    UserDTO create(UserDTO userDTO) throws SQLException;
    /**
     * A method that outputs information about userDTO
     *
     * @return List<UserDTO> filled in
     */
    List<UserDTO> readAll() throws SQLException;
    /**
     * A method that searching information about a specific userDTO
     *
     * @return object userDTO
     */
    UserDTO read(String nameUser) throws SQLException;
    /**
     * A method that updates information about a specific userDTO
     *
     * @return object userDTO
     */
    UserDTO update(UserDTO userDTO) throws SQLException;
    /**
     * A method that deletes information about a specific userDTO
     *
     * @return object NULL
     */
    UserDTO delete(int userId) throws SQLException;

}