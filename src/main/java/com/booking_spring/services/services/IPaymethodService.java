package com.booking_spring.services.services;

import com.booking_spring.services.dto.PaymethodDTO;

import java.sql.SQLException;
import java.util.List;

public interface IPaymethodService {
    PaymethodDTO create(PaymethodDTO paymethodDTO) throws SQLException;

    List<PaymethodDTO> readAll() throws SQLException;

    PaymethodDTO read(int paymethodId) throws SQLException;

    PaymethodDTO update(PaymethodDTO paymethodDTO) throws SQLException;

    void delete(int paymethodId) throws SQLException;

}
