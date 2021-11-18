package com.booking_spring.dao.impl;

import com.booking_spring.dao.IPaymethodDAO;
import com.booking_spring.dao.model.Paymethod;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PaymethodDaoImpl implements IPaymethodDAO {
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
    public List<Paymethod> getPaymethod() throws SQLException {
        List<Paymethod> userroles = new ArrayList<>();
        String SQL = "SELECT * FROM paymethod";
        return (List<Paymethod>) jdbcTemplate().query(SQL, new PaymethodMapper());
    }

    @Override
    public Paymethod createPaymethod(Paymethod paymethod) throws SQLException {
        String SQL = "INSERT INTO paymethod (" +
                "paymethodId, " +
                "name, " +
                "cardholderName, " +
                "expirationDate, " +
                "cardNumber," +
                "cvsCode," +
                "transactionId, " +
                "transactionDate," +
                "transactionStatus, " +
                "sum;\n" +
                ") VALUES (?,?, ?,?, ?,?, ?,?, ?,?)";
        jdbcTemplate().update(SQL,
                paymethod.getPaymethodId(),
                paymethod.getName(),
                paymethod.getCardholdername(),
                paymethod.getExpirationdate(),
                paymethod.getCardnumber(),
                paymethod.getCvscode(),
                paymethod.getTransactionId(),
                paymethod.getTransactionDate(),
                paymethod.getTransactionStatus(),
                paymethod.getSum());
        return paymethod;
    }

    @Override
    public void deletePaymethod(int paymethodId) throws SQLException {
        String SQL = "DELETE FROM paymethod WHERE paymethodId = ?";
        jdbcTemplate().update(SQL, paymethodId);
    }

    @Override
    public Paymethod updatePaymethod(Paymethod paymethod) throws SQLException {
        String SQL = "UPDATE paymethod SET " +
                "name = ?, " +
                "cardholderName = ?, " +
                "expirationDate = ?, " +
                "cardNumber = ?, " +
                "cvsCode = ?, " +
                "transactionId = ?, " +
                "transactionDate = ?, " +
                "transactionStatus = ?, " +
                "sum = ? " +
                "WHERE paymethodId = ?";
        jdbcTemplate().update(SQL,
                paymethod.getName(),
                paymethod.getCardholdername(),
                paymethod.getExpirationdate(),
                paymethod.getCardnumber(),
                paymethod.getCvscode(),
                paymethod.getTransactionId(),
                paymethod.getTransactionDate(),
                paymethod.getTransactionStatus(),
                paymethod.getSum(),
                paymethod.getPaymethodId());
        return paymethod;
    }

    @Override
    public Paymethod getById(int paymethodId) throws SQLException {
        String SQL = "SELECT * FROM paymethod WHERE paymethodId = ?";
        Paymethod paymethod = (Paymethod) jdbcTemplate().queryForObject(SQL, new Object[]{paymethodId}, new PaymethodMapper());
        return paymethod;
    }
}
