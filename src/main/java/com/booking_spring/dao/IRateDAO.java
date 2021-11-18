package com.booking_spring.dao;

import com.booking_spring.dao.model.Rate;

import java.sql.SQLException;
import java.util.List;

public interface IRateDAO {
    List<Rate> getRate() throws SQLException;

    Rate createRate(Rate rate) throws SQLException;

    void deleteRate(int rateId) throws SQLException;

    Rate updateRate(Rate rate) throws SQLException;

    Rate getById(int rateId) throws SQLException;

}
