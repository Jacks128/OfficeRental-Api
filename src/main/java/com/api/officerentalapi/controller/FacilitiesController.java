package com.api.officerentalapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.officerentalapi.entity.Facilities;
import com.api.officerentalapi.entity.dto.FacilitiesDTO;
import com.api.officerentalapi.exception.ResourceNotFoundException;
import com.api.officerentalapi.service.FacilitiesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/facilities")
public class FacilitiesController {
	 @Autowired
	    FacilitiesService facilitiesService;
	    
	    @Autowired
	    private ModelMapper modelMapper;
	    
	    @GetMapping("/getFacility")
	    public FacilitiesDTO getFacility(@RequestParam("facilitiesid") Integer facilitiesid) {
	    	Facilities facility = facilitiesService.findByfacilitiesid(facilitiesid);
	    	if(facility==null) {
	            throw new ResourceNotFoundException("Facility not found with id=" + facilitiesid);
	    	}
	    	return convertToDTO(facility);
	    }


	    @GetMapping("/getFacilities")
	    public List<FacilitiesDTO> getFacilities() {
	        return facilitiesService.getFacilities()
	                .stream()
	                .map(t -> convertToDTO(t))
	                .collect(Collectors.toList());
	    }
	    
	    @GetMapping("/getFacilitiesStatus/{name}")
	    public String getFacilitiesStatus(@PathVariable String name){
	        String outs = facilitiesService.getFacilitiesStatus(name);
	        return outs;
	    }
	    
	    @GetMapping("/getFacilitiesType/{name}")
	    public String getFacilitiesType(@PathVariable String name){
	        String outs = facilitiesService.getFacilitiesType(name);
	        return outs;
	    }
	    @PostMapping("/create")
	    public FacilitiesDTO create(@RequestBody Facilities facilities) {
	        return convertToDTO(facilitiesService.create(facilities));
	    }
	    
	    private FacilitiesDTO convertToDTO(Facilities facilities) {
	        return modelMapper.map(facilities, FacilitiesDTO.class);
	    }
	    
	    @PutMapping("/update/{facilitiesid}")
	    private FacilitiesDTO update(@RequestBody Facilities facilitiesUpdated, @PathVariable("facilitiesid") int facilitiesid) {
	        Facilities facilities = facilitiesService.findByfacilitiesid(facilitiesid);
	        return convertToDTO(facilitiesService.update(facilities, facilitiesUpdated));
	    }

	    private void configModelMapper() {
	        if (!modelMapper.getConfiguration().getMatchingStrategy().equals(MatchingStrategies.LOOSE)) {
	            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	        }
	    }
}
