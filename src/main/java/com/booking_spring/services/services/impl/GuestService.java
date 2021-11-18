package com.booking_spring.services.services.impl;

import com.booking_spring.dao.impl.GuestDaoImpl;
import com.booking_spring.services.dto.GuestDTO;
import com.booking_spring.services.mapper.GuestDTOMapper;
import com.booking_spring.services.services.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
/**
 * A class that implements IGuestService
 * The class is used for transfer DTO to DAO and on the contrary
 * @author LolyNika
 */
@Service
public class GuestService implements IGuestService {
    private final GuestDaoImpl guestDao;
    private final GuestDTOMapper guestDTOMapper;

    @Autowired
    public GuestService(GuestDaoImpl guestDao, GuestDTOMapper guestDTOMapper) {
        this.guestDao = guestDao;
        this.guestDTOMapper = guestDTOMapper;
    }

    @Override
    public GuestDTO create(GuestDTO guestDTO) throws SQLException {
        return guestDTOMapper.convertToDto(guestDao.createGuest(guestDTOMapper.convertToEntity(guestDTO)));
    }

    @Override
    public List<GuestDTO> readAll() throws SQLException {
        return guestDao.getGuest().stream().map(guestDTOMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public GuestDTO read(int idGuest) throws SQLException {
        return guestDTOMapper.convertToDto(guestDao.getById(idGuest));
    }

    @Override
    public GuestDTO update(GuestDTO guestDTO) throws SQLException {
        return guestDTOMapper.convertToDto(guestDao.updateGuest(guestDTOMapper.convertToEntity(guestDTO)));
    }
    @Override
    public GuestDTO delete(int idGuest) throws SQLException {
        guestDao.deleteGuest(idGuest);
        return null;
    }
}

