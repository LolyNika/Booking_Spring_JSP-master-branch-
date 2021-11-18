package com.booking_spring.dao.impl;

import com.booking_spring.dao.IUserroleDAO;
import com.booking_spring.dao.model.Userrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
/**
 * A class that implements IUserroleDAO
 *
 * @author LolyNika
 */
@Repository
public class UserroleDaoImpl implements IUserroleDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserroleDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Userrole> getUserrole() {

        String SQL = "select * from booking.userrole inner join booking.user ON (booking.userrole.`roleId` = booking.user.`roleId`);";
        return (List<Userrole>) jdbcTemplate.query(SQL, new UserroleMapper());
    }

    @Override
    public Userrole createUserrole(Userrole userrole) {
        String SQL = "INSERT INTO userrole (roleId, nameRole) VALUES (?,?)";
        jdbcTemplate.update(SQL, userrole.getRoleId(), userrole.getNameRole());
        return userrole;
    }

    @Override
    public void deleteUserrole(int roleId) {
        String SQL = "DELETE FROM userrole WHERE roleId = ?";
        jdbcTemplate.update(SQL, roleId);
    }

    @Override
    public Userrole updateUserrole(Userrole userrole) {
        String SQL = "UPDATE userrole SET nameRole = ? WHERE roleId = ?";
        jdbcTemplate.update(SQL, userrole.getNameRole(), userrole.getRoleId());
        return userrole;
    }

    @Override
    public Userrole getById(int roleId) throws SQLException {
        String SQL = "SELECT * FROM userrole WHERE roleId = ?";
        Userrole userrole = (Userrole) jdbcTemplate.queryForObject(SQL, new Object[]{roleId}, new UserroleMapper());
        return userrole;
    }}
