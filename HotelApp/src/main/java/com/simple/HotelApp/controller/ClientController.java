package com.simple.HotelApp.controller;

import com.simple.HotelApp.domain.DTO.ClientEditDTO;
import com.simple.HotelApp.domain.DTO.LoggedClientDTO;
import com.simple.HotelApp.domain.DTO.ReceiptDTO;
import com.simple.HotelApp.domain.DTO.ShowRoomDTO;
import com.simple.HotelApp.domain.entity.Client;
import com.simple.HotelApp.domain.entity.LoggedClient;
import com.simple.HotelApp.domain.entity.Reservation;
import com.simple.HotelApp.domain.exception.DuplicateUserException;
import com.simple.HotelApp.service.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value="/api")
public class ClientController {
    ClientServices cService;

    @Autowired
    public ClientController(ClientServices cService) {
        this.cService = cService;
    }

    //works
    @CrossOrigin
    @GetMapping(value ="/client")
    public List<Client> getAll(){
        return cService.getAll();
    }

    //works
    @CrossOrigin
    @GetMapping(value ="/client/{id}")
    public Optional<Client> getById(@PathVariable Integer id){
        return cService.getById(id);
    }


    //works
    @CrossOrigin
    @DeleteMapping(value ="/client/{id}")
    public String removeById(@PathVariable Integer id){
        cService.removeClientById(id);
        return "Works";
    }


    //works
    @CrossOrigin
    @PutMapping(value ="/client/")
    public String editClient(@RequestBody ClientEditDTO newclient){
        cService.editClient(newclient);
        return "Works";
    }

    //works
    @CrossOrigin
    @GetMapping(value ="/client/rooms")
    public List<ShowRoomDTO> getAvailableRooms(){
        return cService.getAvailableRooms();
    }

    @CrossOrigin
    @GetMapping(value ="/client/filterrooms-sizerange")
    public List<ShowRoomDTO> getFilteredRooms3part(@RequestParam String size, String pricestart, String priceend){
        return cService.getFilteredRooms3part(size,pricestart,priceend);
    }

    @CrossOrigin
    @GetMapping(value ="/client/filterrooms-size")
    public List<ShowRoomDTO> getFilteredRoomsSize(@RequestParam String size){
        return cService.getFilteredRoomsSize(size);
    }

    @CrossOrigin
    @GetMapping(value ="/client/filterrooms-range")
    public List<ShowRoomDTO> getFilteredRoomsRange(@RequestParam  String pricestart, String priceend){
        return cService.getFilteredRoomsRange(pricestart,priceend);
    }

    @CrossOrigin
    @GetMapping(value ="/client/filterrooms-sizestart")
    public List<ShowRoomDTO> getFilteredRoomsSizeStart(@RequestParam String size, String pricestart){
        return cService.getFilteredRoomsSizeStart(size,pricestart);
    }

    @CrossOrigin
    @GetMapping(value ="/client/filterrooms-sizeend")
    public List<ShowRoomDTO> getFilteredRoomsSizeEnd(@RequestParam String size, String priceend){
        return cService.getFilteredRoomsSizeEnd(size,priceend);
    }

    // 1 new loggin
    //
    @CrossOrigin
    @GetMapping(value ="/client/login")
    public int logIn(@RequestParam String login, String password){
        return cService.login(login,password);
    }

    //works
    @CrossOrigin
    @GetMapping(value ="/client/{id}/past-reservations")
    public List<Reservation> getPastReservations(@PathVariable Integer id){
        return cService.getPastReservations(id);
    }

    //works
    @CrossOrigin
    @GetMapping(value ="/client/{id}/active-reservations")
    public List<Reservation> getActiveReservations(@PathVariable Integer id){
        return cService.getActiveReservations(id);
    }

    //works
    @CrossOrigin
    @GetMapping(value ="/client/{id}/paymenthistory")
    public List<ReceiptDTO> getPaymentHistory(@PathVariable Integer id){
        return cService.getPaymentHistory(id);
    }

    //works
    @CrossOrigin
    @PostMapping(value ="/client/register")
    public boolean registerClient(@RequestBody LoggedClientDTO newclient)
    {
        try{
        cService.register(newclient);
        return true;}
        catch (DuplicateUserException duo){
            return false;
        }
    }

    //
    @CrossOrigin
    @PutMapping(value ="/update-registered/{ID}")
    public boolean updateClient(@PathVariable int ID,@RequestBody LoggedClientDTO newclient)
    {
         return cService.updateLoggedClient(ID,newclient);
    }

    //
    @CrossOrigin
    @DeleteMapping(value ="/client/delete-registered/{id_client}")
    public boolean deleteClient(@PathVariable int id_client)
    {
        return cService.deleteLoggedClient(id_client);
    }

    @CrossOrigin
    @GetMapping(value ="/logged-client/{id}")
    public Optional<LoggedClient> getLoggedById(@PathVariable Integer id){
        return cService.getLoggedById(id);
    }

}
