package com.booking_spring.dao;

import com.booking_spring.dao.model.User;

import java.sql.SQLException;
import java.util.List;
/**
 * Interface for CRUD User
 *
 * @author LolyNika
 */
public interface IUserDAO {
    /**
     * A method that outputs information about User
     *
     * @return List<User> filled in
     */
    List<User> getUser() throws SQLException;
    /**
     * A method that adds information about a new user to the User table
     *
     * @return object User
     */
    User createUser(User user) throws SQLException;
    /**
     * A method that deletes information about a specific user in the User table
     */
    void deleteUser(int userId) throws SQLException;
    /**
     * A method that updates information about a specific user in the User table
     *
     * @return object User
     */
    User updateUser(User user) throws SQLException;
    /**
     * A method that searching information about a specific user in the User table
     *
     * @return object User
     */
    User getById(String nameUser) throws SQLException;

}