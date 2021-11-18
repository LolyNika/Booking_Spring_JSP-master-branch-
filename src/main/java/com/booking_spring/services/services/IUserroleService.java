package com.booking_spring.services.services;

import com.booking_spring.services.dto.UserroleDTO;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Userrole
 *
 * @author LolyNika
 */
public interface IUserroleService {
    /**
     * A method that adds information about a new userroleDTO
     *
     * @return object userroleDTO
     */
    UserroleDTO create(UserroleDTO userroleDTO) throws SQLException;
    /**
     * A method that outputs information about userroleDTO
     *
     * @return List<UserroleDTO> filled in
     */
    List<UserroleDTO> readAll() throws SQLException;
    /**
     * A method that searching information about a specific userroleDTO
     *
     * @return object userroleDTO
     */
    UserroleDTO read(int roleId) throws SQLException;
    /**
     * A method that updates information about a specific userroleDTO
     *
     * @return object userroleDTO
     */
    UserroleDTO update(UserroleDTO UserroleDTO) throws SQLException;
    /**
     * A method that deletes information about a specific userroleDTO
     *
     * @return object NULL
     */
    UserroleDTO delete(int roleId) throws SQLException;
}
