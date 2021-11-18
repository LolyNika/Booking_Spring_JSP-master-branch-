package com.booking_spring.services.mapper;

import com.booking_spring.dao.model.Paymethod;
import com.booking_spring.services.dto.PaymethodDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * The class is a mapper for Paymethod
 * The class is used to match the DAO model and the DTO model
 * @author LolyNika
 */
@Component
public class PaymethodDTOMapper {
    @Autowired
    private ModelMapper modelMapper;

    public PaymethodDTO convertToDto(Paymethod paymethod) {
        if (paymethod == null) {
            return null;
        } else {
            return modelMapper.map(paymethod, PaymethodDTO.class);
        }
    }

    public Paymethod convertToEntity(PaymethodDTO paymethodDTO) {
        if (paymethodDTO == null) {
            return null;
        } else {
            return modelMapper.map(paymethodDTO, Paymethod.class);
        }
    }
}
