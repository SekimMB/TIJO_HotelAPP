package com.simple.HotelApp.controller;

import com.simple.HotelApp.domain.DTO.AddRoomDTO;
import com.simple.HotelApp.domain.DTO.ClientEditDTO;
import com.simple.HotelApp.domain.entity.Reservation;
import com.simple.HotelApp.service.AdminServices;
import com.simple.HotelApp.service.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value="/api")
public class AdminController {
    AdminServices admins;

    @Autowired
    public AdminController(AdminServices admins) {
        this.admins = admins;
    }

    //works
    @CrossOrigin
    @PostMapping(value = "/admin/add-room")
    public String addRoom(@RequestBody AddRoomDTO newroom) {
        admins.addRoom(newroom);
        return "Added room";
    }

    @CrossOrigin
    @PostMapping(value = "/admin/add-client")
    public String addClient(@RequestBody ClientEditDTO newclient) {
        admins.addClient(newclient);
        return "Added client";
    }

    //works
    @CrossOrigin
    @PutMapping(value = "/admin/change-room-price")
    public String changeRoomPrice(@RequestParam int id, String price) {
        admins.changeRoomPrice(id,price);
        return "Price changed";
    }

    //works
    @CrossOrigin
    @GetMapping(value = "/admin/reservations")
    public List<Reservation> getReservations() {
        return admins.showReservations();
    }
}
