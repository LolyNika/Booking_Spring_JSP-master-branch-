package com.booking_spring.dao.impl;

import com.booking_spring.dao.IPaymethodDAO;
import com.booking_spring.dao.model.Paymethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
/**
 * A class that implements IPaymethodDAO
 *
 * @author LolyNika
 */
@Repository
public class PaymethodDaoImpl implements IPaymethodDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public PaymethodDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Paymethod> getPaymethod() {
        String SQL = "SELECT * FROM paymethod";
        return (List<Paymethod>) jdbcTemplate.query(SQL, new PaymethodMapper());
    }

    @Override
    public Paymethod createPaymethod(Paymethod paymethod) {
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
                "sum\n" +
                ") VALUES (?,?, ?,?, ?,?, ?,NOW(), ?,?)";
        jdbcTemplate.update(SQL,
                paymethod.getPaymethodId(),
                paymethod.getName(),
                paymethod.getCardholderName(),
                paymethod.getExpirationDate(),
                paymethod.getCardNumber(),
                paymethod.getCvsCode(),
                paymethod.getTransactionId(),
//                paymethod.getTransactionDate(),
                paymethod.getTransactionStatus(),
                paymethod.getSum());
        return paymethod;
    }

    @Override
    public void deletePaymethod(int paymethodId) {
        String SQL = "DELETE FROM paymethod WHERE paymethodId = ?";
        jdbcTemplate.update(SQL, paymethodId);
    }

    @Override
    public Paymethod updatePaymethod(Paymethod paymethod) {
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
        jdbcTemplate.update(SQL,
                paymethod.getName(),
                paymethod.getCardholderName(),
                paymethod.getExpirationDate(),
                paymethod.getCardNumber(),
                paymethod.getCvsCode(),
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
        Paymethod paymethod = (Paymethod) jdbcTemplate.queryForObject(SQL, new Object[]{paymethodId}, new PaymethodMapper());
        return paymethod;
    }
}
