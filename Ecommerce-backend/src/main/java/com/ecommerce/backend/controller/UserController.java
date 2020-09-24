package com.ecommerce.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/app")
public class UserController {

	
	    @Autowired
	    private UserRepository userRepository;
	 
	    //GET ALL USERS
	 
	    @GetMapping("/users")
	    public List<User> getAllUsers(Model model) {
	        return this.userRepository.findAll();
	    }  	
	    
	    
	    
	    // DELETE ALL USERS
	       
	    @DeleteMapping("/users")
	    public void deleteUsers() {
	        userRepository.deleteAll();
	    }
	       
	       
	   
	    // DELETE USER BY ID
	    
	    @DeleteMapping("/users/{id}")
	    public void deleteUserById(@PathVariable Long id) {
	        userRepository.deleteById(id);
	    }
	    
	    
}
