package com.api.officerentalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.api.officerentalapi.entity.Facilities;

@Repository
public interface FacilitiesRepository extends JpaRepository<Facilities, Integer> {
	Facilities findByfacilitiesid(Integer facilitiesid);
	Facilities findBytypes(String types);
	Facilities findByname(String name);
	Facilities findBystate (boolean state);

}
