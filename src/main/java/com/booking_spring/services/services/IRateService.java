package com.booking_spring.services.services;

import com.booking_spring.services.dto.RateDTO;

import java.sql.SQLException;
import java.util.List;

public interface IRateService {
    RateDTO create(RateDTO rateDTO) throws SQLException;

    List<RateDTO> readAll() throws SQLException;

    RateDTO read(int rateId) throws SQLException;

    RateDTO update(RateDTO rateDTO) throws SQLException;

    void delete(int rateId) throws SQLException;

}

