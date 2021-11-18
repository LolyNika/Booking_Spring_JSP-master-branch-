package com.booking_spring.services.mapper;

import com.booking_spring.dao.model.Guest;
import com.booking_spring.services.dto.GuestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * The class is a mapper for Guest
 * The class is used to match the DAO model and the DTO model
 * @author LolyNika
 */
@Component
public class GuestDTOMapper {

    @Autowired
    private ModelMapper modelMapper;

    public GuestDTO convertToDto(Guest guest) {
        if (guest == null) {
            return null;
        } else {
            return modelMapper.map(guest, GuestDTO.class);
        }
    }

    public Guest convertToEntity(GuestDTO guestDTO) {
        if (guestDTO == null) {
            return null;
        } else {
            return modelMapper.map(guestDTO, Guest.class);
        }
    }
}
