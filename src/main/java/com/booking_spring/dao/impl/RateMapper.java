package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.Rate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RateMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Rate rate = new Rate();
        rate.setRateId(rs.getInt("rateId"));
        rate.setDate(rs.getInt("date"));
        rate.setName(rs.getString("name"));
        rate.setPrice(rs.getInt("price"));
        return rate;
    }
}
