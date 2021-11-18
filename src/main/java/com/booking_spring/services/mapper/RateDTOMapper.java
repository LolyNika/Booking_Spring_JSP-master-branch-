package com.booking_spring.services.mapper;

import com.booking_spring.dao.model.Rate;
import com.booking_spring.services.dto.RateDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RateDTOMapper {
    @Autowired
    private ModelMapper modelMapper;

    public RateDTO convertToDto(Rate rate) {
        if (rate == null) {
            return null;
        } else {
            return modelMapper.map(rate, RateDTO.class);
        }
    }

    public Rate convertToEntity(RateDTO rateDTO) {
        if (rateDTO == null) {
            return null;
        } else {
            return modelMapper.map(rateDTO, Rate.class);
        }
    }
}
