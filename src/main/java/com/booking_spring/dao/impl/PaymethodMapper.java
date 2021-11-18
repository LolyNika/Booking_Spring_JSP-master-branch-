package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.Paymethod;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * The class is a mapper for PaymethodDaoImpl
 * Here tables mapped: paymethod
 * @author LolyNika
 */
public class PaymethodMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Paymethod paymethod = new Paymethod();
        paymethod.setPaymethodId(rs.getInt("paymethodId"));
        paymethod.setName(rs.getString("name"));
        paymethod.setCardholderName(rs.getString("cardholderName"));
        paymethod.setExpirationDate(rs.getInt("expirationDate"));
        paymethod.setCardNumber(rs.getInt("cardNumber"));
        paymethod.setCvsCode(rs.getInt("cvsCode"));
        paymethod.setTransactionId(rs.getInt("transactionId"));
        paymethod.setTransactionDate(rs.getInt("transactionDate"));
        paymethod.setTransactionStatus(rs.getString("transactionStatus"));
        paymethod.setSum(rs.getInt("sum"));
        return paymethod;
    }
}
