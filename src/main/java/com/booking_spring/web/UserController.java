package com.booking_spring.web;

import com.booking_spring.services.dto.UserDTO;
import com.booking_spring.services.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;
/**
 * Сontroller for working with User
 *
 * @author LolyNika
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private final IUserService iuserService;

    @Autowired
    public UserController(IUserService iuserService) {
        this.iuserService = iuserService;
    }

    /** The method create a new User */
    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody UserDTO user) throws SQLException {
        iuserService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @GetMapping(value = { "/", "/users" })
//    public String read(Model model) throws SQLException {
//        final List<UserDTO> users = iuserService.readAll();
//        model.addAttribute("users", users);
//        return "users";
//    }

    /** The method is used to redirect to the page for the user */
    @GetMapping(value = "/admin")
    public ModelAndView admin(@RequestParam("nickname") String nickname,
                              @RequestParam("password") String password,Model modell) {
        ModelAndView model = new ModelAndView("admin");
        model.addObject("nickname", nickname);
        model.addObject("password", password);
        return model;
//        return "admin";
    }

    /** The method is used to redirect to the page for the admin */
    @GetMapping(value = "/user")
    public ModelAndView user(@RequestParam("nickname") String nickname,
                             @RequestParam("password") String password, Model modell) {
        ModelAndView model = new ModelAndView("user");
        model.addObject("nickname", nickname);
        model.addObject("password", password);
        return model;
//        return "user";
    }

    @GetMapping(value = "/autoriz")
    public String autoriz(Model model) {
        return "autoriz";
    }

    /** The method is used to read User data */
    @GetMapping(value = "/enter")
    public ModelAndView enter(@RequestParam("nameUser") String nameUser,
                               @RequestParam("password") String password,
                               Model modell) throws SQLException {
        ModelAndView model = new ModelAndView("enter");
        final UserDTO userDTO = iuserService.read(nameUser);
        model.addObject("users", userDTO);
        model.addObject("nickname", nameUser);
        model.addObject("password", password);
        return model;
    }

//
//    @GetMapping(value = {"/{nameUser}/delete"})
//    public String delete(@PathVariable(name = "nameUser") String nameUser, Model model) throws SQLException {
//        iuserService.read(nameUser);
//        return "redirect:/rooms/list";
//    }


    /** A method that read a List User */
    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDTO>> read() throws SQLException {
        final List<UserDTO> users = iuserService.readAll();
        return users != null &&  !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping(value = "/users/{userId}")
//    public ResponseEntity<UserDTO> read(@PathVariable(name = "userId") int userId, Model model) throws SQLException {
//        final UserDTO userDTO = iuserService.read(userId);
//
//        return userDTO != null
//                ? new ResponseEntity<>(userDTO, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    /** A method that update a User */
    @PutMapping(value = "/users")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) throws SQLException {
        try {
            return new ResponseEntity<>(iuserService.update(userDTO),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /** A method that deleat by id a User */
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
