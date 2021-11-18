package com.booking_spring.dao.impl;

import com.booking_spring.dao.IBookingDAO;
import com.booking_spring.dao.model.Booking;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BookingDaoImpl implements IBookingDAO {

    private final String driver = "com.mysql.cj.jdbc.Driver";

    private final String url = "jdbc:mysql://localhost:3306/booking";

    private final String name = "admin";

    private final String pass = "admin";

    public JdbcTemplate jdbcTemplate() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(name);
        basicDataSource.setPassword(pass);
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(basicDataSource);
        return jdbcTemplate;
    }
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Booking> getBooking() throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        String SQL = "SELECT * FROM booking";
        return (List<Booking>) jdbcTemplate().query(SQL, new BookingMapper());
    }

    @Override
    public Booking createBooking(Booking booking) throws SQLException {
        String SQL = "INSERT INTO booking (bookingId, checkindate, checkoutdate, adultscount, childrencount, roomtype, comment, bookingstatus) VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate().update(SQL,
                booking.getBookingId(),
                booking.getCheckindate(),
                booking.getCheckoutdate(),
                booking.getAdultscount(),
                booking.getChildrencount(),
                booking.getRoomtype(),
                booking.getComment(),
                booking.getBookingstatus());
        return booking;
    }

    @Override
    public void deleteBooking(int bookingId) throws SQLException {
        String SQL = "DELETE FROM booking WHERE rolbookingIdeId = ?";
        jdbcTemplate().update(SQL, bookingId);
    }

    @Override
    public Booking updateBooking(Booking booking) throws SQLException {
        String SQL = "UPDATE booking SET checkindate = ? , checkoutdate = ?, adultscount = ?, childrencount = ?, roomtype = ?, comment = ?, bookingstatus = ? WHERE bookingId = ?";
        jdbcTemplate().update(SQL,
                booking.getCheckindate(),
                booking.getCheckoutdate(),
                booking.getAdultscount(),
                booking.getChildrencount(),
                booking.getRoomtype(),
                booking.getComment(),
                booking.getBookingstatus(),
                booking.getBookingId());
        return booking;
    }

    @Override
    public Booking getById(int bookingId) throws SQLException {
        String SQL = "SELECT * FROM booking WHERE roleId = ?";
        Booking booking = (Booking) jdbcTemplate().queryForObject(SQL, new Object[]{bookingId}, new BookingMapper());
        return booking;
    }}
