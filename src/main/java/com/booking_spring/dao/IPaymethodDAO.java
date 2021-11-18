package com.booking_spring.dao;

import com.booking_spring.dao.model.Paymethod;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Paymethod
 *
 * @author LolyNika
 */
public interface IPaymethodDAO {
    /**
     * A method that outputs information about Paymethod
     *
     * @return List<Paymethod> filled in
     */
    List<Paymethod> getPaymethod() throws SQLException;
    /**
     * A method that adds information about a new paymethod to the Paymethod table
     *
     * @return object Paymethod
     */
    Paymethod createPaymethod(Paymethod paymethod) throws SQLException;
    /**
     * A method that deletes information about a specific paymethod in the Paymethod table
     */
    void deletePaymethod(int paymethodId) throws SQLException;
    /**
     * A method that updates information about a specific paymethod in the Paymethod table
     *
     * @return object Paymethod
     */
    Paymethod updatePaymethod(Paymethod paymethod) throws SQLException;
    /**
     * A method that searching information about a specific paymethod in the Paymethod table
     *
     * @return object Paymethod
     */
    Paymethod getById(int paymethodId) throws SQLException;
}