package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.Guest;
import com.booking_spring.dao.model.User;
import com.booking_spring.dao.model.Userrole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * The class is a mapper for GuestDaoImpl
 * Here tables mapped: guest, user, userrole
 * @author LolyNika
 */
public class GuestMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Guest guest = new Guest();
        guest.setIdGuest(rs.getInt("idguest"));
        guest.setNameGuest(rs.getString("nameGuest"));
        guest.setMobile(rs.getInt("mobile"));
        guest.setEmail(rs.getString("email"));
        guest.setAddress(rs.getString("address"));

        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setNameUser(rs.getString("nameUser"));
        user.setPassword(rs.getString("password"));
        guest.setUser(user);

        Userrole userrole = new Userrole();
        userrole.setRoleId(rs.getInt("roleId"));
        userrole.setNameRole(rs.getString("nameRole"));
        guest.setUserRole_guests(userrole);
        return guest;
    }
}
