package com.booking_spring.services.services;

import com.booking_spring.services.dto.RateDTO;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Rate
 *
 * @author LolyNika
 */
public interface IRateService {
    /**
     * A method that adds information about a new rateDTO
     *
     * @return object rateDTO
     */
    RateDTO create(RateDTO rateDTO) throws SQLException;
    /**
     * A method that outputs information about rateDTO
     *
     * @return List<RateDTO> filled in
     */
    List<RateDTO> readAll() throws SQLException;
    /**
     * A method that searching information about a specific rateDTO
     *
     * @return object rateDTO
     */
    RateDTO read(int rateId) throws SQLException;
    /**
     * A method that updates information about a specific rateDTO
     *
     * @return object rateDTO
     */
    RateDTO update(RateDTO rateDTO) throws SQLException;
    /**
     * A method that deletes information about a specific rateDTO
     *
     * @return object NULL
     */
    RateDTO delete(int rateId) throws SQLException;

}