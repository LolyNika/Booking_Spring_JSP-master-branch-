package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.User;
import com.booking_spring.dao.model.Userrole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
/**
 * The class is a mapper for UserroleDaoImpl
 * Here tables mapped: userrole, user
 * @author LolyNika
 */
public class UserroleMapper implements RowMapper {

    @Override
    public Userrole mapRow(ResultSet rs, int i) throws SQLException {
        Userrole userrole = new Userrole();
        userrole.setRoleId(rs.getInt("roleId"));
        userrole.setNameRole(rs.getString("nameRole"));

        Set<User> users = new HashSet<>();
//        while (rs.next()) {
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setNameUser(rs.getString("nameUser"));
            user.setPassword(rs.getString("password"));
            users.add(user);
//        }

        userrole.setUsers(users);

        return userrole;
    }
}
