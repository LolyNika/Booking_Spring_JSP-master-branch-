package com.booking_spring.web;

import com.booking_spring.services.dto.UserroleDTO;
import com.booking_spring.services.services.IUserroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
/**
 * Сontroller for working with Userrole
 *
 * @author LolyNika
 */
@RestController
public class UserroleController {
    private final IUserroleService iuserroleService;

    @Autowired
    public UserroleController(IUserroleService iuserroleService) {
        this.iuserroleService = iuserroleService;
    }

    /** A method that add a new Userrole */
    @PostMapping(value = "/userroles")
    public ResponseEntity<?> create(@RequestBody UserroleDTO userroleDTO) throws SQLException {
        iuserroleService.create(userroleDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /** A method that read a Userrole */
    @GetMapping(value = "/userroles")
    public ResponseEntity<List<UserroleDTO>> read() throws SQLException {
        final List<UserroleDTO> userroles = iuserroleService.readAll();

        return userroles != null &&  !userroles.isEmpty()
                ? new ResponseEntity<>(userroles, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /** A method that reads by id a Userrole */
    @GetMapping(value = "/userroles/{roleId}")
    public ResponseEntity<UserroleDTO> read(@PathVariable(name = "roleId") int roleId) throws SQLException {
        final UserroleDTO userroleDTO = iuserroleService.read(roleId);

        return userroleDTO != null
                ? new ResponseEntity<>(userroleDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
