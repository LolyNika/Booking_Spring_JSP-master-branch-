package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.Guest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Guest guest = new Guest();
        guest.setGuestId(rs.getInt("guestId"));
        guest.setName(rs.getString("name"));
        guest.setMobile(rs.getInt("mobile"));
        guest.setEmail(rs.getString("email"));
        guest.setAddress(rs.getString("address"));
        return guest;
    }
}
