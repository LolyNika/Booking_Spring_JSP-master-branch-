package com.booking_spring.services.mapper;

import com.booking_spring.dao.model.Room;
import com.booking_spring.services.dto.RoomDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomDTOMapper {
    @Autowired
    private ModelMapper modelMapper;

    public RoomDTO convertToDto(Room room) {
        if (room == null) {
            return null;
        } else {
            return modelMapper.map(room, RoomDTO.class);
        }
    }

    public Room convertToEntity(RoomDTO roomDTO) {
        if (roomDTO == null) {
            return null;
        } else {
            return modelMapper.map(roomDTO, Room.class);
        }
    }
}
