package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Booking booking = new Booking();
        booking.setBookingId(rs.getInt("bookingId"));
        booking.setCheckindate(rs.getInt("checkindate"));
        booking.setCheckoutdate(rs.getInt("checkoutdate"));
        booking.setAdultscount(rs.getInt("adultscount"));
        booking.setChildrencount(rs.getInt("childrencount"));
        booking.setRoomtype(rs.getString("roomtype"));
        booking.setComment(rs.getString("comment"));
        booking.setBookingstatus(rs.getString("bookingstatus"));
        return booking;
    }
}
