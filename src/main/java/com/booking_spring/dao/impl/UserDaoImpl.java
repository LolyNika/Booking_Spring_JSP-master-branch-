package com.booking_spring.dao.impl;

import com.booking_spring.dao.IUserDAO;
import com.booking_spring.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * A class that implements IUserDAO
 *
 * @author LolyNika
 */
@Repository
public class UserDaoImpl implements IUserDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getUser()  {
        String SQL = "select * from booking.user inner join booking.userrole ON (booking.user.`roleId` = booking.userrole.`roleId`);";
        return (List<User>) jdbcTemplate.query(SQL, new UserMapper());
    }

    @Override
    public User createUser(User user) {
        String SQL = "INSERT INTO user (userId, nameUser, password) VALUES (?,?, ?)";
        jdbcTemplate.update(SQL, user.getUserId(), user.getNameUser(), user.getPassword());
        return user;

//        String SQL = "INSERT INTO user (userId, name, password) VALUES (?,?, ?)";
//        jdbcTemplate().update(SQL, new UserMapper());
//        return user;
    }

    @Override
    public void deleteUser(int userId) {
        String SQL = "DELETE FROM user WHERE userId = ?";
        jdbcTemplate.update(SQL, userId);
    }

    @Override
    public User updateUser(User user) {
        String SQL = "UPDATE user SET nameUser = ?, password = ? WHERE userId = ?";
        jdbcTemplate.update(SQL, user.getNameUser(), user.getPassword(), user.getUserId());
        return user;
    }

    @Override
    public User getById(String nameUser) throws SQLException {
//        String SQL = "SELECT * FROM user WHERE nameUser = 'nameUser'";
        String SQL = "select * from booking.user inner join booking.userrole " +
                "ON (booking.user.`roleId` = booking.userrole.`roleId`) " +
                "WHERE nameUser = ?";
        User user = (User) jdbcTemplate.queryForObject(SQL, new Object[]{nameUser}, new UserMapper());
        return user;
    }
}
