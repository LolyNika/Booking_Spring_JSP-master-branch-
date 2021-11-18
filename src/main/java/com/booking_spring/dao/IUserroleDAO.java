package com.booking_spring.dao;

import com.booking_spring.dao.model.Userrole;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD Userrole
 *
 * @author LolyNika
 */
public interface IUserroleDAO {
    /**
     * A method that outputs information about Userrole
     *
     * @return List<Userrole> filled in
     */
    List<Userrole> getUserrole() throws SQLException;
    /**
     * A method that adds information about a new userrole to the Userrole table
     *
     * @return object Userrole
     */
    Userrole createUserrole(Userrole userrole) throws SQLException;
    /**
     * A method that deletes information about a specific userrole in the Userrole table
     */
    void deleteUserrole(int roleId) throws SQLException;
    /**
     * A method that updates information about a specific userrole in the Userrole table
     *
     * @return object Userrole
     */
    Userrole updateUserrole(Userrole userrole) throws SQLException;
    /**
     * A method that searching information about a specific userrole in the Userrole table
     *
     * @return object Userrole
     */
    Userrole getById(int roleId) throws SQLException;

}