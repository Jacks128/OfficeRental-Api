package com.api.officerentalapi.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.officerentalapi.entity.Reservation;
import com.api.officerentalapi.entity.dto.ReservationDTO;
import com.api.officerentalapi.exception.ResourceNotFoundException;
import com.api.officerentalapi.service.ReservationService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/booking")

public class BookingController {
	
	@Autowired
	ReservationService reservationService;
	
    @Autowired
    private ModelMapper modelMapper;
	
    @GetMapping("/getBooking")
    public ReservationDTO getBorrowedBook(@RequestParam("borrowingid") Integer borrowingid) {

    	Reservation reservation = reservationService.getReservation(borrowingid);
        if (reservation == null) {
            throw new ResourceNotFoundException("Reservation not found with id=" + borrowingid);
        }
        return convertToDTO(reservation);
    }
    
    @GetMapping("/getBookings")
    public List<ReservationDTO> getBorrowedBooks() {
        return reservationService.getReservations()
                .stream()
                .map(t -> convertToDTO(t))
                .collect(Collectors.toList());
    }
    
    @PostMapping("/create")
    public ReservationDTO create(@RequestBody Reservation reser) {

            return convertToDTO(reservationService.create(reser));
        
    }
    
    @DeleteMapping("/removeFacilityResource/{bookingid}")
    private void removeFacilityResource(@PathVariable("bookingid") int bookingid) {
    	reservationService.removeFacilityResource(bookingid);
    }

 
    private ReservationDTO convertToDTO(Reservation borrowingid) {
        configModelMapper();
        return modelMapper.map(borrowingid, ReservationDTO.class);
    }

    private void configModelMapper() {
        if (!modelMapper.getConfiguration().getMatchingStrategy().equals(MatchingStrategies.LOOSE)) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        }
    }
}
