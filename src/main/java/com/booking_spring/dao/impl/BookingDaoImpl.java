package com.booking_spring.dao.impl;

import com.booking_spring.dao.IBookingDAO;
import com.booking_spring.dao.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
/**
 * A class that implements IBookingDAO
 *
 * @author LolyNika
 */
@Repository
public class BookingDaoImpl implements IBookingDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public BookingDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Booking> getBooking() {
        String SQL = "SELECT * FROM booking.booking inner join booking.paymethod ON (booking.booking.`paymethodId` = booking.paymethod.`paymethodId`)\n" +
                "inner join booking.guest ON (booking.booking.`idguest` = booking.guest.`idguest`)\n" +
                "inner join booking.room ON (booking.booking.`room_idroom` = booking.room.`idroom`)\n" +
                "inner join booking.rate ON (booking.booking.`room_idrate` = booking.rate.`idrate`)\n" +
                "inner join booking.roomstatus ON (booking.booking.`room_idroomStatus` = booking.roomstatus.`idroomStatus`)";
        return (List<Booking>) jdbcTemplate.query(SQL, new BookingMapper());
    }

    @Override
    public Booking createBooking(Booking booking) {
        String SQL = "INSERT INTO booking (" +
                "idbooking, " +
                "checkindate, " +
                "checkoutdate, " +
                "adultscount, " +
                "childrencount, " +
                "roomtype, " +
                "comment, " +
                "bookingstatus, " +
                "paymethodId, " +
                "idguest, " +
                "room_idroom, " +
                "room_idroomStatus, " +
                "room_idrate) VALUES" +
                " (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(SQL,
                booking.getIdBooking(),
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getAdultsCount(),
                booking.getChildrenCount(),
                booking.getRoomType(),
                booking.getComment(),
                booking.getBookingStatus(),
                booking.getPaymethod().getPaymethodId(),
                booking.getGuest().getIdGuest(),
                booking.getRoom().getIdRoom(),
                booking.getRoomStatus().getRoomstatusId(),
                booking.getRate().getRateId());
        return booking;
    }

    @Override
    public void deleteBooking(int idbooking) {
        String SQL = "DELETE FROM booking WHERE idbooking = ?";
        jdbcTemplate.update(SQL, idbooking);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        String SQL = "UPDATE booking SET checkindate = ? , checkoutdate = ?, adultscount = ?, childrencount = ?, roomtype = ?, comment = ?, bookingstatus = ? WHERE idbooking = ?";
        jdbcTemplate.update(SQL,
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getAdultsCount(),
                booking.getChildrenCount(),
                booking.getRoomType(),
                booking.getComment(),
                booking.getBookingStatus(),
                booking.getIdBooking());
        return booking;
    }

    @Override
    public Booking getById(int idbooking) throws SQLException {
        String SQL = "SELECT * FROM booking.booking inner join booking.paymethod ON (booking.booking.`paymethodId` = booking.paymethod.`paymethodId`)\n" +
                "inner join booking.guest ON (booking.booking.`idguest` = booking.guest.`idguest`)\n" +
                "inner join booking.room ON (booking.booking.`room_idroom` = booking.room.`idroom`)\n" +
                "inner join booking.rate ON (booking.booking.`room_idrate` = booking.rate.`idrate`)\n" +
                "inner join booking.roomstatus ON (booking.booking.`room_idroomStatus` = booking.roomstatus.`idroomStatus`) WHERE idbooking = ?";
        Booking booking = (Booking) jdbcTemplate.queryForObject(SQL, new Object[]{idbooking}, new BookingMapper());
        return booking;
    }
}
