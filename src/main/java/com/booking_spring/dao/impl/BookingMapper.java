package com.booking_spring.dao.impl;

import com.booking_spring.dao.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * The class is a mapper for BookingDaoImpl
 * Here tables mapped: booking, paymethod, guest, room, rate, roomstatus
 * @author LolyNika
 */
public class BookingMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Booking booking = new Booking();
        booking.setIdBooking(rs.getInt("idbooking"));
        booking.setCheckInDate(rs.getString("checkindate"));
        booking.setCheckOutDate(rs.getString("checkoutdate"));
        booking.setAdultsCount(rs.getInt("adultscount"));
        booking.setChildrenCount(rs.getInt("childrencount"));
        booking.setRoomType(rs.getString("roomtype"));
        booking.setComment(rs.getString("comment"));
        booking.setBookingStatus(rs.getString("bookingstatus"));

        Paymethod paymethod = new Paymethod();
        paymethod.setPaymethodId(rs.getInt("paymethodId"));
        paymethod.setName(rs.getString("name"));
        paymethod.setCardholderName(rs.getString("cardholderName"));
        paymethod.setExpirationDate(rs.getInt("expirationDate"));
        paymethod.setCardNumber(rs.getInt("cardNumber"));
        paymethod.setCvsCode(rs.getInt("cvsCode"));
        paymethod.setTransactionId(rs.getInt("transactionId"));
        paymethod.setTransactionDate(rs.getInt("transactionDate"));
        paymethod.setTransactionStatus(rs.getString("transactionStatus"));
        paymethod.setSum(rs.getInt("sum"));

        Guest guest = new Guest();
        guest.setIdGuest(rs.getInt("idguest"));
        guest.setNameGuest(rs.getString("nameGuest"));
        guest.setMobile(rs.getInt("mobile"));
        guest.setEmail(rs.getString("email"));
        guest.setAddress(rs.getString("address"));

        Room room = new Room();
        room.setIdRoom(rs.getInt("idroom"));
        room.setNameRoom(rs.getString("nameRoom"));

        Rate rate = new Rate();
        rate.setRateId(rs.getInt("idrate"));
        rate.setDate(rs.getInt("date"));
        rate.setPrice(rs.getInt("price"));

        Roomstatus roomstatus = new Roomstatus();
        roomstatus.setRoomstatusId(rs.getInt("idroomstatus"));
        roomstatus.setNameStatus(rs.getString("nameStatus"));

        booking.setPaymethod(paymethod);
        booking.setGuest(guest);
        booking.setRoom(room);
        booking.setRate(rate);
        booking.setRoomStatus(roomstatus);

        return booking;
    }
}
