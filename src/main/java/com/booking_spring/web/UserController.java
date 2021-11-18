package com.booking_spring.web;

import com.booking_spring.services.dto.UserDTO;
import com.booking_spring.services.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {
    private final IUserService iuserService;

    @Autowired
    public UserController(IUserService iuserService) {
        this.iuserService = iuserService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody UserDTO user) throws SQLException {
        iuserService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDTO>> read() throws SQLException {
        final List<UserDTO> users = iuserService.readAll();

        return users != null &&  !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<UserDTO> read(@PathVariable(name = "userId") int userId) throws SQLException {
        final UserDTO userDTO = iuserService.read(userId);

        return userDTO != null
                ? new ResponseEntity<>(userDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/users")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) throws SQLException {
        try {
            return new ResponseEntity<>(iuserService.update(userDTO),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/users/{userId}")
    public ResponseEntity<UserDTO> delete(@PathVariable(name = "userId") int userId) throws SQLException {
        try {
            return new ResponseEntity<>(iuserService.delete(userId),
            HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
