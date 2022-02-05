package com.api.officerentalapi.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
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

import com.api.officerentalapi.entity.Types;
import com.api.officerentalapi.entity.dto.TypesDTO;
import com.api.officerentalapi.exception.ResourceNotFoundException;
import com.api.officerentalapi.service.TypesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/type")
public class TypesController {

	 @Autowired
	    TypesService typeService;
	 
	 @Autowired
	    private ModelMapper modelMapper;
	 
	 @GetMapping("/getTypes")
	    public TypesDTO getTypes(@RequestParam("typesid") Integer typesid) {

	        Types typeFound = typeService.getTypes(typesid);
	        if (typeFound == null) {
	            throw new ResourceNotFoundException("Ticket not found with id=" + typesid);
	        }
	        return convertToDTO(typeFound);
	    }

	    @GetMapping("/getTypeses")
	    public List<TypesDTO> getTypeses() {
	        return typeService.getTypeses()
	                .stream()
	                .map(t -> convertToDTO(t))
	                .collect(Collectors.toList());
	    }
	    
	    private TypesDTO convertToDTO(Types type) {
	        configModelMapper();
	        return modelMapper.map(type, TypesDTO.class);
	    }

	    private void configModelMapper() {
	        if (!modelMapper.getConfiguration().getMatchingStrategy().equals(MatchingStrategies.LOOSE)) {
	            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	        }
	    }
}
