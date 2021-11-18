package com.booking_spring.services.services.impl;

import com.booking_spring.dao.impl.PaymethodDaoImpl;
import com.booking_spring.services.dto.PaymethodDTO;
import com.booking_spring.services.mapper.PaymethodDTOMapper;
import com.booking_spring.services.services.IPaymethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
/**
 * A class that implements IPaymethodService
 * The class is used for transfer DTO to DAO and on the contrary
 * @author LolyNika
 */
@Service
public class PaymethodService implements IPaymethodService {
    private final PaymethodDaoImpl paymethodDao;
    private final PaymethodDTOMapper paymethodDTOMapper;

    @Autowired
    public PaymethodService(PaymethodDaoImpl paymethodDao, PaymethodDTOMapper paymethodDTOMapper) {
        this.paymethodDao = paymethodDao;
        this.paymethodDTOMapper = paymethodDTOMapper;
    }

    @Override
    public PaymethodDTO create(PaymethodDTO paymethodDTO) throws SQLException {
        return paymethodDTOMapper.convertToDto(paymethodDao.createPaymethod(paymethodDTOMapper.convertToEntity(paymethodDTO)));
    }

    @Override
    public List<PaymethodDTO> readAll() throws SQLException {
        return paymethodDao.getPaymethod().stream().map(paymethodDTOMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public PaymethodDTO read(int paymethodId) throws SQLException {
        return paymethodDTOMapper.convertToDto(paymethodDao.getById(paymethodId));
    }

    @Override
    public PaymethodDTO update(PaymethodDTO paymethodDTO) throws SQLException {
        return paymethodDTOMapper.convertToDto(paymethodDao.updatePaymethod(paymethodDTOMapper.convertToEntity(paymethodDTO)));
    }

    @Override
    public PaymethodDTO delete(int paymethodId) throws SQLException {
        paymethodDao.deletePaymethod(paymethodId);
        return null;
    }
}
