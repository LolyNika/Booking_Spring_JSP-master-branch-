package com.booking_spring.services.services;

import com.booking_spring.services.dto.PaymethodDTO;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Paymethod
 *
 * @author LolyNika
 */
public interface IPaymethodService {
    /**
     * A method that adds information about a new paymethodDTO
     *
     * @return object paymethodDTO
     */
    PaymethodDTO create(PaymethodDTO paymethodDTO) throws SQLException;
    /**
     * A method that outputs information about paymethodDTO
     *
     * @return List<PaymethodDTO> filled in
     */
    List<PaymethodDTO> readAll() throws SQLException;
    /**
     * A method that searching information about a specific paymethodDTO
     *
     * @return object paymethodDTO
     */
    PaymethodDTO read(int paymethodId) throws SQLException;
    /**
     * A method that updates information about a specific paymethodDTO
     *
     * @return object paymethodDTO
     */
    PaymethodDTO update(PaymethodDTO paymethodDTO) throws SQLException;
    /**
     * A method that deletes information about a specific paymethodDTO
     *
     * @return object NULL
     */
    PaymethodDTO delete(int paymethodId) throws SQLException;

}