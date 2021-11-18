package com.booking_spring.web;

import com.booking_spring.services.dto.GuestDTO;
import com.booking_spring.services.dto.UserDTO;
import com.booking_spring.services.dto.UserroleDTO;
import com.booking_spring.services.services.IGuestService;
import com.booking_spring.services.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;
/**
 * Сontroller for working with Guest
 *
 * @author LolyNika
 */
@Controller
@RequestMapping("/guests")
public class GuestController {
    private final IGuestService guestService;
    private final IUserService iuserService;

    @Autowired
    public GuestController(IGuestService guestService, IUserService iuserService) {
        this.guestService = guestService;
        this.iuserService = iuserService;
    }

//    @PostMapping(value = "/create")
//    public ResponseEntity<?> create(@RequestBody GuestDTO guestDTO) throws SQLException {
//        guestService.create(guestDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    /** The method read a Guest and redirect */
    @GetMapping(value = {"/enter"})
    public ModelAndView enter(@RequestParam("nameUser") String nameUser) throws SQLException {
        ModelAndView model = new ModelAndView("newguest");
        final UserDTO userDTO = iuserService.read(nameUser);
        model.addObject("users", userDTO);
        return model;
    }

    /** The method is used to redirect to the page for the Guest */
    @GetMapping(value = {"/createguest"})
    public String createjsp(Model model) {
        return "searchUserGuest";
    }

    /** The method create a new Guest */
    @PostMapping(value = "/create")
    public String create(@RequestParam("userId") int userId,
                         @RequestParam("roleId") int roleId,
                         @RequestParam("nameGuest") String nameGuest,
                         @RequestParam("mobile") int mobile,
                         @RequestParam("email") String email,
                         @RequestParam("address") String address,
                         Model modell) throws SQLException {
        UserroleDTO userroleDTO = new UserroleDTO();
        userroleDTO.setRoleId(roleId);

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);

        int min = 5;
        int max = 1000;
        double x = (Math.random()*((max-min)+1))+min;
        int i = (int) x;

        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setIdGuest(i);
        guestDTO.setNameGuest(nameGuest);
        guestDTO.setMobile(mobile);
        guestDTO.setEmail(email);
        guestDTO.setAddress(address);
        guestDTO.setUser(userDTO);
        guestDTO.setUserRole_guests(userroleDTO);
        guestService.create(guestDTO);
        return "redirect:/guests/list";
    }

    /** The method read a List Guest */
    @GetMapping(value = {"/list"})
    public String read(Model model) throws SQLException {
        final List<GuestDTO> guests = guestService.readAll();
        model.addAttribute("guests", guests);
        return "guests";
    }

//        @GetMapping(value = "/guests")
//    public ResponseEntity<List<GuestDTO>> read() throws SQLException {
//        final List<GuestDTO> guests = guestService.readAll();
//
//        return guests != null &&  !guests.isEmpty()
//                ? new ResponseEntity<>(guests, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    /** The method reads by Id a Guest and redirect to update Guest*/
    @GetMapping(value = "/{idGuest}/editguests")
    public ModelAndView read(@PathVariable int idGuest) throws SQLException {
        ModelAndView model = new ModelAndView("editguests");
        final GuestDTO guestDTO = guestService.read(idGuest);
        model.addObject("guests", guestDTO);
        return model;
    }

    //    @GetMapping(value = "/{idguest}/getbyid")
//    public ResponseEntity<GuestDTO> read(@PathVariable(name = "idguest") int idguest) throws SQLException {
//        final GuestDTO guestDTO = guestService.read(idguest);
//
//        return guestDTO != null
//                ? new ResponseEntity<>(guestDTO, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    /** The method update a Guest */
    @PostMapping(value = "/update")
    public String update(@RequestParam("idGuest") int idGuest,
                         @RequestParam("nameGuest") String nameGuest,
                         @RequestParam("mobile") int mobile,
                         @RequestParam("email") String email,
                         @RequestParam("address") String address, Model model) throws SQLException {
        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setIdGuest(idGuest);
        guestDTO.setNameGuest(nameGuest);
        guestDTO.setMobile(mobile);
        guestDTO.setEmail(email);
        guestDTO.setAddress(address);
        guestService.update(guestDTO);
        return "redirect:/guests/list";
    }

//    @PutMapping(value = "/guests")
//    public ResponseEntity<GuestDTO> update(@RequestBody GuestDTO guestDTO) throws SQLException {
//        try {
//            return new ResponseEntity<>(guestService.update(guestDTO),
//                    HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    /** The method delete by Id a Guest */
    @GetMapping(value = {"/{idGuest}/delete"})
    public String delete(@PathVariable int idGuest, Model model) throws SQLException {
        guestService.delete(idGuest);
        return "redirect:/guests/list";
    }

//    @DeleteMapping(value = "/guests/{guestId}")
//    public ResponseEntity<GuestDTO> delete(@PathVariable(name = "guestId") int guestId) throws SQLException {
//        try {
//            return new ResponseEntity<>(guestService.delete(guestId),
//                    HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
