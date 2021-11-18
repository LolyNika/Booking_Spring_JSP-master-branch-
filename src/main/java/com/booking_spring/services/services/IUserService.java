package com.booking_spring.services.services;

import com.booking_spring.services.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    UserDTO create(UserDTO userDTO) throws SQLException;

    List<UserDTO> readAll() throws SQLException;

    UserDTO read(int userId) throws SQLException;

    UserDTO update(UserDTO userDTO) throws SQLException;

    UserDTO delete(int userId) throws SQLException;

}
