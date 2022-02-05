package com.api.officerentalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.officerentalapi.entity.Types;
import com.api.officerentalapi.repository.TypesRepository;

@Service

public class TypesService {
	@Autowired
    private TypesRepository typesRepository;
	
	public Types getTypes(Integer typesid) {
        return typesRepository.findBytypesid(typesid);
    } 
    
    public Types create(Types type) {
	return typesRepository.save(type);
    }
    
    public List<Types> getTypeses() {
        return typesRepository.findAll();
    }
    
    public void delete(int typesid) {
    	typesRepository.deleteById(typesid);
    }
    
    public Types findBytypesid(Integer typesid) {
        return typesRepository.findBytypesid(typesid);
    }
}
