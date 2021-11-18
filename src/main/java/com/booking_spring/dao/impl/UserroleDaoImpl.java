package com.booking_spring.dao.impl;

import com.booking_spring.dao.IUserroleDAO;
import com.booking_spring.dao.model.Userrole;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserroleDaoImpl implements IUserroleDAO {
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
    public List<Userrole> getUserrole() throws SQLException {
        List<Userrole> userroles = new ArrayList<>();
        String SQL = "SELECT * FROM userrole";
        return (List<Userrole>) jdbcTemplate().query(SQL, new UserroleMapper());
    }

    @Override
    public Userrole createUserrole(Userrole userrole) throws SQLException {
        String SQL = "INSERT INTO userrole (roleId, name) VALUES (?,?)";
        jdbcTemplate().update(SQL, userrole.getRoleId(), userrole.getName());
        return userrole;
    }

    @Override
    public void deleteUserrole(int roleId) throws SQLException {
        String SQL = "DELETE FROM userrole WHERE roleId = ?";
        jdbcTemplate().update(SQL, roleId);
    }

    @Override
    public Userrole updateUserrole(Userrole userrole) throws SQLException {
        String SQL = "UPDATE userrole SET name = ? WHERE roleId = ?";
        jdbcTemplate().update(SQL, userrole.getName(), userrole.getRoleId());
        return userrole;
    }

    @Override
    public Userrole getById(int roleId) throws SQLException {
        String SQL = "SELECT * FROM userrole WHERE roleId = ?";
        Userrole userrole = (Userrole) jdbcTemplate().queryForObject(SQL, new Object[]{roleId}, new UserroleMapper());
        return userrole;
    }}
