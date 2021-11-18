package com.booking_spring.services.services.impl;

import com.booking_spring.dao.impl.RateDaoImpl;
import com.booking_spring.services.dto.RateDTO;
import com.booking_spring.services.mapper.RateDTOMapper;
import com.booking_spring.services.services.IRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RateService implements IRateService {
    private final RateDaoImpl rateDao;
    private final RateDTOMapper rateDTOMapper;

    @Autowired
    public RateService(RateDaoImpl rateDao, RateDTOMapper rateDTOMapper) {
        this.rateDao = rateDao;
        this.rateDTOMapper = rateDTOMapper;
    }

    @Override
    public RateDTO create(RateDTO rateDTO) throws SQLException {
        return rateDTOMapper.convertToDto(rateDao.createRate(rateDTOMapper.convertToEntity(rateDTO)));
    }

    @Override
    public List<RateDTO> readAll() throws SQLException {
        return rateDao.getRate().stream().map(rateDTOMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public RateDTO read(int rateId) throws SQLException {
        return rateDTOMapper.convertToDto(rateDao.getById(rateId));
    }

    @Override
    public RateDTO update(RateDTO rateDTO) throws SQLException {
        return rateDTOMapper.convertToDto(rateDao.updateRate(rateDTOMapper.convertToEntity(rateDTO)));
    }

    @Override
    public void delete(int rateId) throws SQLException {
        rateDao.deleteRate(rateId);
    }}
