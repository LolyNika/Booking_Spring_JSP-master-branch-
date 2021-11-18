package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.Rate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * The class is a mapper for RateDaoImpl
 * Here tables mapped: rate
 * @author LolyNika
 */
public class RateMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Rate rate = new Rate();
        rate.setRateId(rs.getInt("idrate"));
        rate.setDate(rs.getInt("date"));
        rate.setPrice(rs.getInt("price"));
        return rate;
    }
}
