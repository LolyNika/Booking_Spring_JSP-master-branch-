package com.booking_spring.services.services;

import com.booking_spring.services.dto.RoomDTO;
import com.booking_spring.services.dto.RoomstatusDTO;

import java.sql.SQLException;
import java.util.List;

public interface IRoomService {
    RoomDTO create(RoomDTO roomDTO) throws SQLException;

    List<RoomDTO> readAll() throws SQLException;

    RoomDTO read(int roomId) throws SQLException;

    RoomDTO update(RoomDTO RoomDTO) throws SQLException;

    void delete(int roomId) throws SQLException;

}
