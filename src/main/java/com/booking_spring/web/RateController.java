package com.booking_spring.web;

import com.booking_spring.services.dto.RateDTO;
import com.booking_spring.services.services.IRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
/**
 * Сontroller for working with Rate
 *
 * @author LolyNika
 */
@RestController
public class RateController {
    private final IRateService rateService;

    @Autowired
    public RateController(IRateService rateService) {
        this.rateService = rateService;
    }

    /** The method create a new Rate */
    @PostMapping(value = "/rate")
    public ResponseEntity<?> create(@RequestBody RateDTO rateDTO) throws SQLException {
        rateService.create(rateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /** The method read a List Rate */
    @GetMapping(value = "/rate")
    public ResponseEntity<List<RateDTO>> read() throws SQLException {
        final List<RateDTO> rates = rateService.readAll();

        return rates != null &&  !rates.isEmpty()
                ? new ResponseEntity<>(rates, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /** The method reads by Id a Rate */
    @GetMapping(value = "/rate/{rateId}")
    public ResponseEntity<RateDTO> read(@PathVariable(name = "rateId") int rateId) throws SQLException {
        final RateDTO rateDTO = rateService.read(rateId);

        return rateDTO != null
                ? new ResponseEntity<>(rateDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /** The method update a Rate */
    @PutMapping(value = "/rate")
    public ResponseEntity<RateDTO> update(@RequestBody RateDTO rateDTO) throws SQLException {
        try {
            return new ResponseEntity<>(rateService.update(rateDTO),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /** The method delete by Id a Rate */
    @DeleteMapping(value = "/rate/{rateId}")
    public ResponseEntity<RateDTO> delete(@PathVariable(name = "rateId") int rateId) throws SQLException {
        try {
            return new ResponseEntity<>(rateService.delete(rateId),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
