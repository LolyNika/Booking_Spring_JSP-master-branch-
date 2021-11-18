package com.booking_spring.services.services.impl;

import com.booking_spring.dao.impl.RoomstatusDaoImpl;
import com.booking_spring.services.dto.RoomstatusDTO;
import com.booking_spring.services.mapper.RoomstatusDTOMapper;
import com.booking_spring.services.services.IRoomstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RoomstatusService implements IRoomstatusService {
    private final RoomstatusDaoImpl roomstatusDao;
    private final RoomstatusDTOMapper roomstatusDTOMapper;

    @Autowired
    public RoomstatusService(RoomstatusDaoImpl roomstatusDao, RoomstatusDTOMapper roomstatusDTOMapper) {
        this.roomstatusDao = roomstatusDao;
        this.roomstatusDTOMapper = roomstatusDTOMapper;
    }


    @Override
    public RoomstatusDTO create(RoomstatusDTO roomstatusDTO) throws SQLException {
        return roomstatusDTOMapper.convertToDto(roomstatusDao.createRoomstatus(roomstatusDTOMapper.convertToEntity(roomstatusDTO)));
    }

    @Override
    public List<RoomstatusDTO> readAll() throws SQLException {
        return roomstatusDao.getRoomstatus().stream().map(roomstatusDTOMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public RoomstatusDTO read(int roomstatusId) throws SQLException {
        return roomstatusDTOMapper.convertToDto(roomstatusDao.getById(roomstatusId));
    }

    @Override
    public RoomstatusDTO update(RoomstatusDTO roomstatusDTO) throws SQLException {
        return roomstatusDTOMapper.convertToDto(roomstatusDao.updateRoomstatus(roomstatusDTOMapper.convertToEntity(roomstatusDTO)));
    }

    @Override
    public void delete(int roomstatusId) throws SQLException {
        roomstatusDao.deleteRoomstatus(roomstatusId);
    }
}
