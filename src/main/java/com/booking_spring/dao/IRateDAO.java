package com.booking_spring.dao;

import com.booking_spring.dao.model.Rate;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Rate
 *
 * @author LolyNika
 */
public interface IRateDAO {
    /**
     * A method that outputs information about Rate
     *
     * @return List<Rate> filled in
     */
    List<Rate> getRate() throws SQLException;
    /**
     * A method that adds information about a new rate to the Rate table
     *
     * @return object Rate
     */
    Rate createRate(Rate rate) throws SQLException;
    /**
     * A method that deletes information about a specific rate in the Rate table
     */
    void deleteRate(int rateId) throws SQLException;
    /**
     * A method that updates information about a specific rate in the Rate table
     *
     * @return object Rate
     */
    Rate updateRate(Rate rate) throws SQLException;
    /**
     * A method that searching information about a specific rate in the Rate table
     *
     * @return object Rate
     */
    Rate getById(int rateId) throws SQLException;

}