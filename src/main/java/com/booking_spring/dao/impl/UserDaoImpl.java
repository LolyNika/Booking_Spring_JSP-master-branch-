package com.booking_spring.dao.impl;

import com.booking_spring.dao.IUserDAO;
import com.booking_spring.dao.model.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements IUserDAO {
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
//    public JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getUser() throws SQLException {
        List<User> users = new ArrayList<>();
        String SQL = "SELECT * FROM user";
        return (List<User>) jdbcTemplate().query(SQL, new UserMapper());
    }

    @Override
    public User createUser(User user) throws SQLException {
        String SQL = "INSERT INTO user (userId, name, password) VALUES (?,?, ?)";
        jdbcTemplate().update(SQL, user.getUserId(), user.getName(), user.getPassword());
        return user;

//        String SQL = "INSERT INTO user (userId, name, password) VALUES (?,?, ?)";
//        jdbcTemplate().update(SQL, new UserMapper());
//        return user;
    }

    public static void main(String[] args) throws SQLException {

        String name = "name1", password = "pass1";
        int userid = 1;

        User user = new User(userid, name, password);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.createUser(user);
    }

//    @Override
//    public void createUser(int userId, String name, String password) throws SQLException {
//        String SQL = "INSERT INTO user (userId, name, password) VALUES (?,?, ?)";
////        jdbcTemplate.update(SQL, userId, name, password);
//    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        String SQL = "DELETE FROM user WHERE userId = ?";
        jdbcTemplate().update(SQL, userId);
    }

    @Override
    public User updateUser(User user) throws SQLException {
        String SQL = "UPDATE user SET name = ?, password = ? WHERE userId = ?";
        jdbcTemplate().update(SQL, user.getName(), user.getPassword(), user.getUserId());
        return user;
    }

    @Override
    public User getById(int userId) throws SQLException {
        String SQL = "SELECT * FROM user WHERE userId = ?";
        User user = (User) jdbcTemplate().queryForObject(SQL, new Object[]{userId}, new UserMapper());
        return user;
    }
}
