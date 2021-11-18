package com.booking_spring.web;

import com.booking_spring.services.dto.RateDTO;
import com.booking_spring.services.dto.RoomDTO;
import com.booking_spring.services.dto.RoomstatusDTO;
import com.booking_spring.services.dto.UserDTO;
import com.booking_spring.services.services.IGuestService;
import com.booking_spring.services.services.IRateService;
import com.booking_spring.services.services.IRoomService;
import com.booking_spring.services.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;
/**
 * Сontroller for working with Room
 *
 * @author LolyNika
 */
@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final IRoomService roomService;
    private final IGuestService guestService;
    private final IRateService rateService;
    private final IUserService iuserService;

    @Autowired
    public RoomController(IRoomService roomService, IGuestService guestService, IRateService rateService, IUserService iuserService) {
        this.roomService = roomService;
        this.guestService = guestService;
        this.rateService = rateService;
        this.iuserService = iuserService;
    }

    //    @PostMapping(value = "/rooms")
//    public ResponseEntity<?> create(@RequestBody RoomDTO RoomDTO) throws SQLException {
//        roomService.create(RoomDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    /** The method is used to redirect to the page for the room */
    @GetMapping(value = {"/createroom"})
    public String createjsp(Model model) {
        return "newroom";
    }

    /** The method create a new room use also table rate and roomstatus */
    @PostMapping(value = "/create")
    public String create(@RequestParam("nameRoom") String nameRoom,
                         @RequestParam("date") int date,
                         @RequestParam("price") int price,
                         Model model) throws SQLException {
        int min = 5;
        int max = 1000;
        double x = (Math.random()*((max-min)+1))+min;
        int i = (int) x;

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setIdRoom(i);
        roomDTO.setNameRoom(nameRoom);

        RoomstatusDTO roomstatusDTO = new RoomstatusDTO();
        roomstatusDTO.setRoomstatusId(2);
        roomstatusDTO.setNameStatus("free");
        roomDTO.setRoomstatus(roomstatusDTO);

        RateDTO rateDTO = new RateDTO();
        rateDTO.setRateId(i);
        rateDTO.setDate(date);
        rateDTO.setPrice(price);
        rateService.create(rateDTO);

        roomDTO.setRate(rateDTO);

        roomService.create(roomDTO);
        return "redirect:/rooms/list";
    }

//    @GetMapping(value = "/rooms")
//    public ResponseEntity<List<RoomDTO>> read() throws SQLException {
//        final List<RoomDTO> rooms = roomService.readAll();
//
//        return rooms != null &&  !rooms.isEmpty()
//                ? new ResponseEntity<>(rooms, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    /** The method read List Roomstatus */
    @GetMapping(value = {"/list"})
    public String read(Model model) throws SQLException {
        final List<RoomDTO> rooms = roomService.readAll();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    /** The method raeds by Id a Roomstatus */
    @GetMapping(value = "/{idroom}/editrooms")
    public ModelAndView read(@PathVariable(name = "idroom") int idRoom, Model modell) throws SQLException {
        ModelAndView model = new ModelAndView("editrooms");
        final RoomDTO roomDTO = roomService.read(idRoom);
        model.addObject("rooms", roomDTO);
        return model;
    }

//    @GetMapping(value = "/rooms/{roomId}")
//    public ResponseEntity<RoomDTO> read(@PathVariable(name = "roomId") int roomId) throws SQLException {
//        final RoomDTO roomDTO = roomService.read(roomId);
//
//        return roomDTO != null
//                ? new ResponseEntity<>(roomDTO, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    /** The method update a Roomstatus */
    @PostMapping(value = "/update")
    public String update(@RequestParam("idroom") int idRoom,
                         @RequestParam("nameRoom") String nameRoom, Model model) throws SQLException {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setIdRoom(idRoom);
        roomDTO.setNameRoom(nameRoom);
        roomService.update(roomDTO);
        return "redirect:/rooms/list";
    }

    //    @PutMapping(value = "/rooms")
//    public ResponseEntity<RoomDTO> update(@RequestBody RoomDTO RoomDTO) throws SQLException {
//        try {
//            return new ResponseEntity<>(roomService.update(RoomDTO),
//                    HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    /** The method delete by Id a Roomstatus */
    @GetMapping(value = {"/{idroom}/delete"})
    public String delete(@PathVariable(name = "idroom") int idRoom, Model model) throws SQLException {
        roomService.delete(idRoom);
        return "redirect:/rooms/list";
    }
//    @DeleteMapping(value = "/rooms/{roomId}")
//    public ResponseEntity<RoomDTO> delete(@PathVariable(name = "roomId") int roomId) throws SQLException {
//        try {
//            return new ResponseEntity<>(roomService.delete(roomId),
//                    HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
