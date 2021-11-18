package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.Paymethod;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymethodMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Paymethod paymethod = new Paymethod();
        paymethod.setPaymethodId(rs.getInt("paymethodId"));
        paymethod.setName(rs.getString("name"));
        paymethod.setCardholdername(rs.getString("cardholderName"));
        paymethod.setExpirationdate(rs.getInt("expirationDate"));
        paymethod.setCardnumber(rs.getInt("cardNumber"));
        paymethod.setCvscode(rs.getInt("cvsCode"));
        paymethod.setTransactionId(rs.getInt("transactionId"));
        paymethod.setTransactionDate(rs.getInt("transactionDate"));
        paymethod.setTransactionStatus(rs.getString("transactionStatus"));
        paymethod.setSum(rs.getInt("sum"));
        return paymethod;
    }
}
