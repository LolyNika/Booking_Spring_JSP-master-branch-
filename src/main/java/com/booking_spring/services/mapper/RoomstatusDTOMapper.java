package com.booking_spring.services.mapper;

import com.booking_spring.dao.model.Roomstatus;
import com.booking_spring.services.dto.RoomstatusDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * The class is a mapper for Roomstatus
 * The class is used to match the DAO model and the DTO model
 * @author LolyNika
 */
@Component
public class RoomstatusDTOMapper {
    @Autowired
    private ModelMapper modelMapper;

    public RoomstatusDTO convertToDto(Roomstatus roomstatus) {
        if (roomstatus == null) {
            return null;
        } else {
            return modelMapper.map(roomstatus, RoomstatusDTO.class);
        }
    }

    public Roomstatus convertToEntity(RoomstatusDTO roomstatusDTO) {
        if (roomstatusDTO == null) {
            return null;
        } else {
            return modelMapper.map(roomstatusDTO, Roomstatus.class);
        }
    }
}
