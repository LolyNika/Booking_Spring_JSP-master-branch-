package com.booking_spring.dao;

import com.booking_spring.dao.model.Userrole;

import java.sql.SQLException;
import java.util.List;

public interface IUserroleDAO {
    List<Userrole> getUserrole() throws SQLException;

    Userrole createUserrole(Userrole userrole) throws SQLException;

    void deleteUserrole(int roleId) throws SQLException;

    Userrole updateUserrole(Userrole userrole) throws SQLException;

    Userrole getById(int roleId) throws SQLException;

}
