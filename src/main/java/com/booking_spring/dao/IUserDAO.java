package com.booking_spring.dao;

import com.booking_spring.dao.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    List<User> getUser() throws SQLException;

    User createUser(User user) throws SQLException;

    void deleteUser(int userId) throws SQLException;

    User updateUser(User user) throws SQLException;

    User getById(int userId) throws SQLException;

}
