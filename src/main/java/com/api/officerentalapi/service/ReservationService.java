package com.api.officerentalapi.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.officerentalapi.entity.Facilities;
import com.api.officerentalapi.entity.Reservation;
import com.api.officerentalapi.exception.BadInputParamException;
import com.api.officerentalapi.repository.FacilitiesRepository;
import com.api.officerentalapi.repository.ReservationRepository;
import com.api.officerentalapi.repository.UserRepository;

@Repository
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Autowired
    private FacilitiesRepository facRepository;
    
    @Autowired
    private FacilitiesService facService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    
    
    public Reservation getReservation(Integer bookingid) {
        return reservationRepository.findBybookingid(bookingid);
    }
    
    public Reservation create(Reservation rev) {
    	Facilities fac=facRepository.findByfacilitiesid(rev.getFacilitiesObj().getFacilitiesid());
    	if(fac.getState()) {
    		fac.setState(false);
    		return reservationRepository.save(rev);
    	}else {
            throw new BadInputParamException("This facility is not available.");

    	}
    }

    public void removeFacilityResource(int bookingid) {
    	reservationRepository.deleteById(bookingid);
    }
    
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }
    
    public Reservation update(Reservation reser, Reservation reserUpdated) {
        	reser.setFacilitiesObj(reserUpdated.getFacilitiesObj());

        return reservationRepository.save(reser);
    }
    
}
