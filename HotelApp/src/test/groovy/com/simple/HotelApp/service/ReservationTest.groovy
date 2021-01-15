package com.simple.HotelApp.service

import com.simple.HotelApp.domain.DTO.NewReservationDTO
import com.simple.HotelApp.domain.entity.Reservation
import com.simple.HotelApp.domain.repository.ReservationRepository
import spock.lang.Specification

class ReservationTest extends Specification {
    public static final int client_id = 1
    public static final String start_date = "12/01/2021"
    public static final int room_id = 1
    ReservationRepository newrepo = new FakeReservationRepository()
    ReservationServices reservation = new ReservationServices(newrepo)
    NewReservationDTO newDto = new NewReservationDTO(client_id, room_id, start_date,"14/01/2021")
    def "should create a new reservation"(
    ){
        when: "add a new reservation"
        reservation.addReservation(newDto)
        then: "reservation is created"
        def all = reservation.findAll()
        all.id_client == [client_id]
        all.start_date == [start_date]
        all.id_room == [room_id]
    }

    def "should delete "(
    ){
        given: "there is a reservation"
        reservation.addReservation(newDto)
        def reservation_id = reservation.findAll().id_reservation.first()
        when: "add a new reservation"
        reservation.removeReservation(reservation_id)
        then: "reservation is created"
        reservation.findAll() == []
    }

    def "should not delete "(
    ){
        given: "there is a reservation"
        reservation.addReservation(newDto)
        def reservation_id = reservation.findAll().id_reservation.first()
        when: "add a new reservation"
        reservation.removeReservation(null)
        then: "reservation is created"
        reservation.findAll().id_reservation == [reservation_id]
    }
// reservation when null
// ymh ok, dzięki za pomoc

}
