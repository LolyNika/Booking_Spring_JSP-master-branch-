package com.booking_spring.dao.impl;

import com.booking_spring.dao.IRateDAO;
import com.booking_spring.dao.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
/**
 * A class that implements IRateDAO
 *
 * @author LolyNika
 */
@Repository
public class RateDaoImpl implements IRateDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public RateDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Rate> getRate() {
        String SQL = "SELECT * FROM rate";
        return (List<Rate>) jdbcTemplate.query(SQL, new RateMapper());
    }

    @Override
    public Rate createRate(Rate rate) {
        String SQL = "INSERT INTO rate (idrate, date, price) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, rate.getRateId(), rate.getDate(), rate.getPrice());
        return rate;
    }

    @Override
    public void deleteRate(int rateId) {
        String SQL = "DELETE FROM rate WHERE idrate = ?";
        jdbcTemplate.update(SQL, rateId);
    }

    @Override
    public Rate updateRate(Rate rate) {
        String SQL = "UPDATE rate SET date = ?, price = ?  WHERE idrate = ?";
        jdbcTemplate.update(SQL, rate.getRateId(), rate.getDate(), rate.getPrice());
        return rate;
    }

    @Override
    public Rate getById(int rateId) throws SQLException {
        String SQL = "SELECT * FROM rate WHERE idrate = ?";
        Rate rate = (Rate) jdbcTemplate.queryForObject(SQL, new Object[]{rateId}, new RateMapper());
        return rate;
    }}
