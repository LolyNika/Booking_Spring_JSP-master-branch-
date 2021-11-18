package com.booking_spring.services.services;

import com.booking_spring.services.dto.UserroleDTO;

import java.sql.SQLException;
import java.util.List;

public interface IUserroleService {
    void delete(int roleId) throws SQLException;

    UserroleDTO create(UserroleDTO userroleDTO) throws SQLException;

    List<UserroleDTO> readAll() throws SQLException;

    UserroleDTO read(int roleId) throws SQLException;

    UserroleDTO update(UserroleDTO UserroleDTO) throws SQLException;

}
