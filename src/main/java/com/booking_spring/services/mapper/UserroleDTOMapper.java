package com.booking_spring.services.mapper;

import com.booking_spring.dao.model.Userrole;
import com.booking_spring.services.dto.UserroleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * The class is a mapper for Userrole
 * The class is used to match the DAO model and the DTO model
 * @author LolyNika
 */
@Component
public class UserroleDTOMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserroleDTO convertToDto(Userrole userrole) {
        if (userrole == null) {
            return null;
        } else {
            return modelMapper.map(userrole, UserroleDTO.class);
        }
    }

    public Userrole convertToEntity(UserroleDTO userroleDTO) {
        if (userroleDTO == null) {
            return null;
        } else {
            return modelMapper.map(userroleDTO, Userrole.class);
        }
    }
}
