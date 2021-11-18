package com.booking_spring.web;

import com.booking_spring.services.dto.RoomstatusDTO;
import com.booking_spring.services.services.IRoomstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
/**
 * Сontroller for working with Roomstatus
 *
 * @author LolyNika
 */
@RestController
public class RoomstatusController {
    private final IRoomstatusService roomstatusService;

    @Autowired
    public RoomstatusController(IRoomstatusService roomstatusService) {
        this.roomstatusService = roomstatusService;
    }

    /** The method create a new roomstatus */
    @PostMapping(value = "/roomstatus")
    public ResponseEntity<?> create(@RequestBody RoomstatusDTO roomstatusDTO) throws SQLException {
        roomstatusService.create(roomstatusDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /** The method that read List Roomstatus */
    @GetMapping(value = "/roomstatus")
    public ResponseEntity<List<RoomstatusDTO>> read() throws SQLException {
        final List<RoomstatusDTO> users = roomstatusService.readAll();

        return users != null &&  !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /** The method that reads by Id a Roomstatus */
    @GetMapping(value = "/roomstatus/{roomstatusId}")
    public ResponseEntity<RoomstatusDTO> read(@PathVariable(name = "roomstatusId") int roomstatusId) throws SQLException {
        final RoomstatusDTO roomstatusDTO = roomstatusService.read(roomstatusId);

        return roomstatusDTO != null
                ? new ResponseEntity<>(roomstatusDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /** The method that upfate a  Roomstatus */
    @PutMapping(value = "/roomstatus")
    public ResponseEntity<RoomstatusDTO> update(@RequestBody RoomstatusDTO roomstatusDTO) throws SQLException {
        try {
            return new ResponseEntity<>(roomstatusService.update(roomstatusDTO),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /** The method that delete by Id a Roomstatus */
    @DeleteMapping(value = "/roomstatus/{roomstatusId}")
    public ResponseEntity<RoomstatusDTO> delete(@PathVariable(name = "roomstatusId") int roomstatusId) throws SQLException {
        try {
            return new ResponseEntity<>(roomstatusService.delete(roomstatusId),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
