package com.booking_spring.services.services.impl;

import com.booking_spring.dao.impl.RoomDaoImpl;
import com.booking_spring.services.dto.RoomDTO;
import com.booking_spring.services.mapper.RoomDTOMapper;
import com.booking_spring.services.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RoomService implements IRoomService {
    private final RoomDaoImpl roomDao;
    private final RoomDTOMapper roomDTOMapper;

    @Autowired
    public RoomService(RoomDaoImpl roomDao, RoomDTOMapper roomDTOMapper) {
        this.roomDao = roomDao;
        this.roomDTOMapper = roomDTOMapper;
    }

    @Override
    public RoomDTO create(RoomDTO roomDTO) throws SQLException {
        return roomDTOMapper.convertToDto(roomDao.createRoom(roomDTOMapper.convertToEntity(roomDTO)));
    }

    @Override
    public List<RoomDTO> readAll() throws SQLException {
        return roomDao.getRoom().stream().map(roomDTOMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public RoomDTO read(int roomId) throws SQLException {
        return roomDTOMapper.convertToDto(roomDao.getById(roomId));
    }

    @Override
    public RoomDTO update(RoomDTO RoomDTO) throws SQLException {
        return roomDTOMapper.convertToDto(roomDao.updateRoom(roomDTOMapper.convertToEntity(RoomDTO)));
    }

    @Override
    public void delete(int roomId) throws SQLException {
        roomDao.deleteRoom(roomId);
    }}
