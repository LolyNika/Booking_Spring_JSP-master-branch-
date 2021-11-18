package com.booking_spring.web;

import com.booking_spring.services.dto.*;
import com.booking_spring.services.services.*;
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
 * Сontroller for working with Booking
 *
 * @author LolyNika
 */
@Controller
@RequestMapping("/bookings")
public class BookingController {
    private final IBookingService bookingService;
    private final IRoomService roomService;
    private final IGuestService guestService;
    private final IUserService iuserService;
    private final IPaymethodService paymethodService;

    @Autowired
    public BookingController(IBookingService bookingService, IRoomService roomService, IGuestService guestService, IUserService iUserService, IPaymethodService paymethodService) {
        this.bookingService = bookingService;
        this.roomService = roomService;
        this.guestService = guestService;
        this.iuserService = iUserService;
        this.paymethodService = paymethodService;
    }

    /** The method read a List Bookings */
    @GetMapping(value = {"/list"})
    public String read(Model model) throws SQLException {
        final List<BookingDTO> bookings = bookingService.readAll();
        model.addAttribute("bookings", bookings);
        return "bookings";
    }

//    @PostMapping(value = "/bookings")
//    public ResponseEntity<?> create(@RequestBody BookingDTO bookingDTO) throws SQLException {
//        bookingService.create(bookingDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    /** The method read a List Room */
    @GetMapping(value = {"/listrooms"})
    public String readRooms(Model model) throws SQLException {
        final List<RoomDTO> rooms = roomService.readAll();
        model.addAttribute("rooms", rooms);
        return "newbook";
    }

    /** The method read by Id a Room */
    @GetMapping(value = "/{idroom}/takerooms")
    public ModelAndView read(@PathVariable(name = "idroom") int idRoom) throws SQLException {
        ModelAndView model = new ModelAndView("searchGuestBook");
        final RoomDTO roomDTO = roomService.read(idRoom);
        model.addObject("rooms", roomDTO);
        return model;
    }

    /** The method use info about a Guest to redirect to create a new Booking */
    @GetMapping(value = {"/enter"})
    public ModelAndView enter(@RequestParam("nameUser") String nameUser,
                              @RequestParam("idroom") int idroom,
                              @RequestParam("rateId") int rateId,
                              @RequestParam("nameroom") String nameroom) throws SQLException {
        ModelAndView model = new ModelAndView("addnewbook");
        final UserDTO userDTO = iuserService.read(nameUser);
        model.addObject("users", userDTO);
        model.addObject("idroomm", idroom);
        model.addObject("rateId", rateId);
        model.addObject("nameroomm", nameroom);
        return model;
    }

    /** The method create a new Booking use tables room, roomstatus, rate, guest, paymethod */
    @PostMapping(value = "/create")
    public String create(@RequestParam("idroom") int idRoom,
                         @RequestParam("rateId") int rateId,
                         @RequestParam("nameroom") String nameroom,

                         @RequestParam("userId") int userId,
                         @RequestParam("roleId") int roleId,
                         @RequestParam("nameGuest") String nameGuest,
                         @RequestParam("mobile") int mobile,
                         @RequestParam("email") String email,
                         @RequestParam("address") String address,

                         @RequestParam("checkindate") String checkindate,
                         @RequestParam("checkoutdate") String checkoutdate,
                         @RequestParam("adultscount") int adultscount,
                         @RequestParam("childrencount") int childrencount,
                         @RequestParam("roomtype") String roomtype,
                         @RequestParam("comment") String comment,
                         @RequestParam("bookingstatus") String bookingstatus,

                         @RequestParam("name") String name,
                         @RequestParam("cardholderName") String cardholderName,
                         @RequestParam("expirationDate") int expirationDate,
                         @RequestParam("cardNumber") int cardNumber,
                         @RequestParam("cvsCode") int cvsCode,
                         @RequestParam("transactionDate") int transactionDate,
                         @RequestParam("transactionStatus") String transactionStatus,
                         @RequestParam("sum") int sum
                         ) throws SQLException {
        int min = 5;
        int max = 1000;
        double x = (Math.random()*((max-min)+1))+min;
        int i = (int) x;

        RateDTO rateDTO = new RateDTO();
        rateDTO.setRateId(rateId);

        UserroleDTO userroleDTO = new UserroleDTO();
        userroleDTO.setRoleId(roleId);

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);

        RoomstatusDTO roomstatusDTO = new RoomstatusDTO();
        roomstatusDTO.setRoomstatusId(1);

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setIdRoom(idRoom);
        roomDTO.setNameRoom(nameroom);
        roomDTO.setRoomstatus(roomstatusDTO);
        roomService.update(roomDTO);

        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setIdGuest(i);
        guestDTO.setNameGuest(nameGuest);
        guestDTO.setMobile(mobile);
        guestDTO.setEmail(email);
        guestDTO.setAddress(address);
        guestDTO.setUser(userDTO);
        guestDTO.setUserRole_guests(userroleDTO);
        guestService.create(guestDTO);

        PaymethodDTO paymethodDTO = new PaymethodDTO();
        paymethodDTO.setPaymethodId(i);
        paymethodDTO.setName(name);
        paymethodDTO.setCardholderName(cardholderName);
        paymethodDTO.setExpirationDate(expirationDate);
        paymethodDTO.setCardNumber(cardNumber);
        paymethodDTO.setCvsCode(cvsCode);
        paymethodDTO.setTransactionId(i);
        paymethodDTO.setTransactionDate(transactionDate);
        paymethodDTO.setTransactionStatus(transactionStatus);
        paymethodDTO.setSum(sum);
        paymethodService.create(paymethodDTO);

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setIdBooking(i);
        bookingDTO.setCheckInDate(checkindate);
        bookingDTO.setCheckOutDate(checkoutdate);
        bookingDTO.setAdultsCount(adultscount);
        bookingDTO.setChildrenCount(childrencount);
        bookingDTO.setRoomType(roomtype);
        bookingDTO.setComment(comment);
        bookingDTO.setBookingStatus(bookingstatus);
        bookingDTO.setPaymethod(paymethodDTO);
        bookingDTO.setGuest(guestDTO);
        bookingDTO.setRoom(roomDTO);
        bookingDTO.setRoomstatus(roomstatusDTO);
        bookingDTO.setRate(rateDTO);

        bookingService.create(bookingDTO);

        return "redirect:/bookings/list";
    }

//    @GetMapping(value = "/bookings")
//    public ResponseEntity<List<BookingDTO>> read() throws SQLException {
//        final List<BookingDTO> bookings = bookingService.readAll();
//
//        return bookings != null &&  !bookings.isEmpty()
//                ? new ResponseEntity<>(bookings, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @GetMapping(value = "/bookings/{idbooking}")
//    public ResponseEntity<BookingDTO> read(@PathVariable(name = "idbooking") int idBooking) throws SQLException {
//        final BookingDTO bookingDTO = bookingService.read(idBooking);
//
//        return bookingDTO != null
//                ? new ResponseEntity<>(bookingDTO, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @PutMapping(value = "/bookings")
//    public ResponseEntity<BookingDTO> update(@RequestBody BookingDTO bookingDTO) throws SQLException {
//        try {
//            return new ResponseEntity<>(bookingService.update(bookingDTO),
//                    HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    /** The method delete by Id a Guest */
    @GetMapping(value = {"/{idBooking}/delete"})
    public String delete(@PathVariable int idBooking, Model model) throws SQLException {
        bookingService.delete(idBooking);
        paymethodService.delete(idBooking);
        return "redirect:/bookings/list";
    }

//    @DeleteMapping(value = "/bookings/{idbooking}")
//    public ResponseEntity<BookingDTO> delete(@PathVariable(name = "idbooking") int idBooking) throws SQLException {
//        try {
//            return new ResponseEntity<>(bookingService.delete(idBooking),
//                    HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
