package com.booking_spring.web;

import com.booking_spring.services.dto.PaymethodDTO;
import com.booking_spring.services.services.IPaymethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
/**
 * Сontroller for working with Paymethod
 *
 * @author LolyNika
 */
@RestController
public class PaymethodController {
    private final IPaymethodService paymethodService;

    @Autowired
    public PaymethodController(IPaymethodService paymethodService) {
        this.paymethodService = paymethodService;
    }

    /** The method create a new Paymethod */
    @PostMapping(value = "/paymethod")
    public ResponseEntity<?> create(@RequestBody PaymethodDTO paymethodDTO) throws SQLException {
        paymethodService.create(paymethodDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /** The method raed a List Paymethod */
    @GetMapping(value = "/paymethod")
    public ResponseEntity<List<PaymethodDTO>> read() throws SQLException {
        final List<PaymethodDTO> paymethods = paymethodService.readAll();

        return paymethods != null &&  !paymethods.isEmpty()
                ? new ResponseEntity<>(paymethods, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /** The method reads by id a Paymethod */
    @GetMapping(value = "/paymethod/{paymethodId}")
    public ResponseEntity<PaymethodDTO> read(@PathVariable(name = "paymethodId") int paymethodId) throws SQLException {
        final PaymethodDTO paymethodDTO = paymethodService.read(paymethodId);

        return paymethodDTO != null
                ? new ResponseEntity<>(paymethodDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /** The method update a Paymethod */
    @PutMapping(value = "/paymethod")
    public ResponseEntity<PaymethodDTO> update(@RequestBody PaymethodDTO paymethodDTO) throws SQLException {
        try {
            return new ResponseEntity<>(paymethodService.update(paymethodDTO),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /** The method delete by Id a Paymethod */
    @DeleteMapping(value = "/paymethod/{paymethodId}")
    public ResponseEntity<PaymethodDTO> delete(@PathVariable(name = "paymethodId") int paymethodId) throws SQLException {
        try {
            return new ResponseEntity<>(paymethodService.delete(paymethodId),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
