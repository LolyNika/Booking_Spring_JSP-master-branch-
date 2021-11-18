package com.booking_spring.services.services.impl;

import com.booking_spring.dao.impl.BookingDaoImpl;
import com.booking_spring.services.dto.BookingDTO;
import com.booking_spring.services.mapper.BookingDTOMapper;
import com.booking_spring.services.services.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
/**
 * A class that implements IBookingService
 * The class is used for transfer DTO to DAO and on the contrary
 * @author LolyNika
 */
@Service
public class BookingService implements IBookingService {
    private final BookingDaoImpl bookingDao;
    private final BookingDTOMapper bookingDTOMapper;

    @Autowired
    public BookingService(BookingDaoImpl bookingDao, BookingDTOMapper bookingDTOMapper) {
        this.bookingDao = bookingDao;
        this.bookingDTOMapper = bookingDTOMapper;
    }

    @Override
    public BookingDTO create(BookingDTO bookingDTO) throws SQLException {
        return bookingDTOMapper.convertToDto(bookingDao.createBooking(bookingDTOMapper.convertToEntity(bookingDTO)));
    }

    @Override
    public List<BookingDTO> readAll() throws SQLException {
        return bookingDao.getBooking().stream().map(bookingDTOMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public BookingDTO read(int idBooking) throws SQLException {
        return bookingDTOMapper.convertToDto(bookingDao.getById(idBooking));
    }

    @Override
    public BookingDTO update(BookingDTO bookingDTO) throws SQLException {
        return bookingDTOMapper.convertToDto(bookingDao.updateBooking(bookingDTOMapper.convertToEntity(bookingDTO)));
    }
    @Override
    public BookingDTO delete(int idBooking) throws SQLException {
        bookingDao.deleteBooking(idBooking);
        return null;
    }
}
