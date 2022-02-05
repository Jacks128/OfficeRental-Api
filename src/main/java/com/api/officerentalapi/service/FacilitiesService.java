package com.api.officerentalapi.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.officerentalapi.entity.Facilities;
import com.api.officerentalapi.entity.Types;
import com.api.officerentalapi.exception.ResourceNotFoundException;
import com.api.officerentalapi.repository.FacilitiesRepository;
import com.api.officerentalapi.repository.TypesRepository;

@Service
public class FacilitiesService {
    @Autowired
    private FacilitiesRepository facilitiesRepository;
    
    public Facilities getFacility(Integer facilitiesid) {
        return facilitiesRepository.findByfacilitiesid(facilitiesid);
    } 
    
    
    public Facilities create(Facilities facility) {
	return facilitiesRepository.save(facility);
    }
    
    public List<Facilities> getFacilities() {
        return facilitiesRepository.findAll();
    }
    
    public void delete(int userid) {
    	facilitiesRepository.deleteById(userid);
    }
    
    public Facilities findByfacilitiesid(Integer facilitiesid) {
        return facilitiesRepository.findByfacilitiesid(facilitiesid);
    }
    
    public String getFacilitiesStatus(String name){
    	Facilities fac = facilitiesRepository.findByname(name);
        if (fac == null){
            throw new ResourceNotFoundException("printer not found");
        }else{
            return fac.getState() ? "The Facility " + name + " is available" : "The Facility" + name + " is reserved";
        }
    }
    
    public String getFacilitiesType(String name){
    	Facilities fac = facilitiesRepository.findByname(name);
        if (fac == null){
            throw new ResourceNotFoundException("printer not found");
        }else{
            return fac.getTypes().equals("Space") ? "The Facility " + name + " is type Space" : "The Facility" + name + " is type Resource";
        }
    }
   
   

    
    public Facilities update(Facilities facility, Facilities facilityUpdated) {
        if(facilityUpdated.getName() !=null){
        	facility.setName(facilityUpdated.getName());
        }
        if(facilityUpdated.getState() !=null){
        	facility.setState(facilityUpdated.getState());

        }
    	facility.setPrice(facilityUpdated.getPrice());
    	facility.setTypes(facilityUpdated.getTypes());
        return facilitiesRepository.save(facility);
    }
    
}
