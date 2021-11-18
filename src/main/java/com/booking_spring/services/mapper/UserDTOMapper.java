package com.booking_spring.services.mapper;

import com.booking_spring.dao.model.User;
import com.booking_spring.services.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto(User user) {
        if (user == null) {
            return null;
        } else {
            return modelMapper.map(user, UserDTO.class);
        }
    }

    public User convertToEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            return modelMapper.map(userDTO, User.class);
        }
    }
}
