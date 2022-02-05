package com.api.officerentalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.officerentalapi.entity.User;
import com.api.officerentalapi.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	public User getUser(Integer userid) {
        return userRepository.findByuserid(userid);
    } 
    
    public User create(User user) {
	return userRepository.save(user);
    }
    
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
    public void delete(int userid) {
    	userRepository.deleteById(userid);
    }
    
    public User findByuserid(Integer userid) {
        return userRepository.findByuserid(userid);
    }
    
    public User update(User user, User userUpdated) {
        if(userUpdated.getName()!=null){
            user.setName(userUpdated.getName());
        }
        if(userUpdated.getLastname()!=null){
            user.setLastname(userUpdated.getLastname());
        }
        return userRepository.save(user);
    }
    
	
}
