package com.ecommerce.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.model.Role;
import com.ecommerce.backend.repository.RoleRepository;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/auth")
public class RoleController {


    @Autowired
    private RoleRepository roleRepository;
 
    //GET ALL ROLES
 
    @GetMapping("/roles")
    public List<Role> getAllProducts(Model model) {
        return this.roleRepository.findAll();
    }
 

       
    // SAVE ROLE
    
       
    @PostMapping("/roles")
    public Role saveRole(@Validated @RequestBody Role role) {
   	 return roleRepository.save(role);
    }    
      
    
  
}

