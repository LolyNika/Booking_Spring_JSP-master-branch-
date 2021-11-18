package com.booking_spring.services.mapper;

import com.booking_spring.dao.model.Booking;
import com.booking_spring.services.dto.BookingDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingDTOMapper {
    @Autowired
    private ModelMapper modelMapper;

    public BookingDTO convertToDto(Booking booking) {
        if (booking == null) {
            return null;
        } else {
            return modelMapper.map(booking, BookingDTO.class);
        }
    }

    public Booking convertToEntity(BookingDTO bookingDTO) {
        if (bookingDTO == null) {
            return null;
        } else {
            return modelMapper.map(bookingDTO, Booking.class);
        }
    }
}
