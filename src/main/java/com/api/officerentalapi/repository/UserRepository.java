package com.api.officerentalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.officerentalapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByuserid(Integer userid);
    
    User findByname(String name);
}