package com.booking_spring.services.services.impl;

import com.booking_spring.dao.impl.UserroleDaoImpl;
import com.booking_spring.services.dto.UserroleDTO;
import com.booking_spring.services.mapper.UserroleDTOMapper;
import com.booking_spring.services.services.IUserroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
/**
 * A class that implements IuserroleService
 * The class is used for transfer DTO to DAO and on the contrary
 * @author LolyNika
 */
@Service
public class UserroleService implements IUserroleService {
    private final UserroleDaoImpl userroleDao;
    private final UserroleDTOMapper userroleDTOMapper;

    @Autowired
    public UserroleService(UserroleDaoImpl userroleDao, UserroleDTOMapper userroleDTOMapper) {
        this.userroleDao = userroleDao;
        this.userroleDTOMapper = userroleDTOMapper;
    }

    @Override
    public UserroleDTO create(UserroleDTO userroleDTO) throws SQLException {
        return userroleDTOMapper.convertToDto(userroleDao.createUserrole(userroleDTOMapper.convertToEntity(userroleDTO)));
    }

    @Override
    public List<UserroleDTO> readAll() throws SQLException {
        return userroleDao.getUserrole().stream().map(userroleDTOMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserroleDTO read(int roleId) throws SQLException {
        return userroleDTOMapper.convertToDto(userroleDao.getById(roleId));
    }

    @Override
    public UserroleDTO update(UserroleDTO UserroleDTO) throws SQLException {
        return userroleDTOMapper.convertToDto(userroleDao.updateUserrole(userroleDTOMapper.convertToEntity(UserroleDTO)));
    }

    @Override
    public UserroleDTO delete(int roleId) throws SQLException {
        userroleDao.deleteUserrole(roleId);
        return null;
    }
}
