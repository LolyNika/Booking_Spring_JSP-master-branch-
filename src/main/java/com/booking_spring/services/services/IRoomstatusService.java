package com.booking_spring.services.services;

import com.booking_spring.services.dto.RoomstatusDTO;

import java.sql.SQLException;
import java.util.List;

public interface IRoomstatusService {
    RoomstatusDTO create(RoomstatusDTO roomstatusDTO) throws SQLException;

    List<RoomstatusDTO> readAll() throws SQLException;

    RoomstatusDTO read(int roomstatusId) throws SQLException;

    RoomstatusDTO update(RoomstatusDTO roomstatusDTO) throws SQLException;

    void delete(int roomstatusId) throws SQLException;

}
