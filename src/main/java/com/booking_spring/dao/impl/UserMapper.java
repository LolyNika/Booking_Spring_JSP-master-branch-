package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.User;
import com.booking_spring.dao.model.Userrole;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * The class is a mapper for UserDaoImpl
 * Here tables mapped: user, userrole
 * @author LolyNika
 */
public class UserMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException, DataAccessException {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setNameUser(rs.getString("nameUser"));
        user.setPassword(rs.getString("password"));

//        Object userRole = rs.getObject("roleId");
//        user.setUserRole((Userrole)userRole);

        Userrole userrole = new Userrole();
        userrole.setRoleId(rs.getInt("roleId"));
        userrole.setNameRole(rs.getString("nameRole"));

        user.setUserRole(userrole);
//        user.setUserRole(rs.getObject("roleId", Userrole.class));
        return user;
    }
}
