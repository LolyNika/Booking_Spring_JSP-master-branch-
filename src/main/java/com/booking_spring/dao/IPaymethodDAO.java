package com.booking_spring.dao;

import com.booking_spring.dao.model.Paymethod;

import java.sql.SQLException;
import java.util.List;

public interface IPaymethodDAO {
    List<Paymethod> getPaymethod() throws SQLException;

    Paymethod createPaymethod(Paymethod paymethod) throws SQLException;

    void deletePaymethod(int paymethodId) throws SQLException;

    Paymethod updatePaymethod(Paymethod paymethod) throws SQLException;

    Paymethod getById(int paymethodId) throws SQLException;

}
