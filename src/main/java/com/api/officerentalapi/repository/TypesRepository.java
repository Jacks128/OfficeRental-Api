package com.api.officerentalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.officerentalapi.entity.Types;

@Repository
public interface TypesRepository extends JpaRepository<Types, Integer>  {
	Types findBytypesid(Integer typesid);
	
	Types findBytype(String type);
}
