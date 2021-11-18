package com.booking_spring.dao.impl;

import com.booking_spring.dao.IRateDAO;
import com.booking_spring.dao.model.Rate;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RateDaoImpl implements IRateDAO {
    private final String driver = "com.mysql.cj.jdbc.Driver";

    private final String url = "jdbc:mysql://localhost:3306/booking";

    private final String name = "admin";

    private final String pass = "admin";
    public JdbcTemplate jdbcTemplate() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(name);
        basicDataSource.setPassword(pass);
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(basicDataSource);
        return jdbcTemplate;
    }
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Rate> getRate() throws SQLException {
        List<Rate> rates = new ArrayList<>();
        String SQL = "SELECT * FROM rate";
        return (List<Rate>) jdbcTemplate().query(SQL, new RateMapper());
    }

    @Override
    public Rate createRate(Rate rate) throws SQLException {
        String SQL = "INSERT INTO rate (roleId, date, name, price) VALUES (?,?,?,?)";
        jdbcTemplate().update(SQL, rate.getRateId(), rate.getDate(), rate.getName(), rate.getPrice());
        return rate;
    }

    @Override
    public void deleteRate(int rateId) throws SQLException {
        String SQL = "DELETE FROM rate WHERE rateId = ?";
        jdbcTemplate().update(SQL, rateId);
    }

    @Override
    public Rate updateRate(Rate rate) throws SQLException {
        String SQL = "UPDATE rate SET date = ?, name = ?, price = ?  WHERE rateId = ?";
        jdbcTemplate().update(SQL, rate.getRateId(), rate.getDate(), rate.getName(), rate.getPrice());
        return rate;
    }

    @Override
    public Rate getById(int rateId) throws SQLException {
        String SQL = "SELECT * FROM rate WHERE rateId = ?";
        Rate rate = (Rate) jdbcTemplate().queryForObject(SQL, new Object[]{rateId}, new RateMapper());
        return rate;
    }}
