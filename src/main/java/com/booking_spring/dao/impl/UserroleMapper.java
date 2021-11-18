package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.Booking;
import com.booking_spring.dao.model.Userrole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserroleMapper implements RowMapper {
    @Override
    public Userrole mapRow(ResultSet rs, int i) throws SQLException {
        Userrole userrole = new Userrole();
        userrole.setRoleId(rs.getInt("roleId"));
        userrole.setName(rs.getString("name"));
        return userrole;
    }
}
