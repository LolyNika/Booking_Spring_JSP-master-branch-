package com.booking_spring.services.services.impl;

import com.booking_spring.dao.impl.UserDaoImpl;
import com.booking_spring.services.dto.UserDTO;
import com.booking_spring.services.mapper.UserDTOMapper;
import com.booking_spring.services.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserService implements IUserService {
    private final UserDaoImpl userDao;
    private final UserDTOMapper userDTOMapper;

    @Autowired
    public UserService(UserDaoImpl userDao, UserDTOMapper userDTOMapper) {
        this.userDTOMapper = userDTOMapper;
        this.userDao = userDao;
    }


    @Override
    public UserDTO create(UserDTO user) throws SQLException {
        return userDTOMapper.convertToDto(userDao.createUser(userDTOMapper.convertToEntity(user)));
    }

    @Override
    public List<UserDTO> readAll() throws SQLException {
        return userDao.getUser().stream().map(userDTOMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO read(int userId) throws SQLException {
        return userDTOMapper.convertToDto(userDao.getById(userId));
    }

    @Override
    public UserDTO update(UserDTO user) throws SQLException {
        return userDTOMapper.convertToDto(userDao.updateUser(userDTOMapper.convertToEntity(user)));
    }

    @Override
    public UserDTO delete(int userId) throws SQLException {
        userDao.deleteUser(userId);
        return null;
    }}
