package com.ecommerce.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.exception.ResourceNotFoundException;
import com.ecommerce.backend.model.Order;
import com.ecommerce.backend.repository.OrderRepository;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/app")
public class OrderController {

	
	    @Autowired
	    private OrderRepository orderRepository;
	 
	    //GET ALL ORDERS
	 
	    @GetMapping("/orders")
	    public List<Order> getAllOrders(Model model) {
	        return this.orderRepository.findAll();
	    }
	 
	    
	   
	    
	    // GET ORDER BY ID
	       
	    @GetMapping("/orders/{id}")
	    public ResponseEntity<Order> getOrderById(@PathVariable("id") UUID id)
	    throws ResourceNotFoundException {Order order= orderRepository.findById(id)
	          .orElseThrow(() -> new ResourceNotFoundException("Could not found order for this id :: " + id));
	         return ResponseEntity.ok().body(order);
	       }
	    
	
	    
	       
	    // SAVE ORDER
	    
	    
	    @PostMapping("/orders")
	    public Order saveOrder(@Validated @RequestBody Order order) {
	   	 return orderRepository.save(order);
	    }    
	      
	       
	      
	    
	    // UPDATE ORDER BY ID

	    @PutMapping("/orders/{id}")
	    Order updateOrder(@RequestBody Order newOrder, @PathVariable UUID id) {
	 
	        return orderRepository.findById(id).map(order -> {
	        	
	        	
	            order.setUsername(newOrder.getUsername());
	            order.setAddress(newOrder.getAddress());
	            order.setCity(newOrder.getCity());
                order.setState(newOrder.getState());
                order.setZipcode(newOrder.getZipcode());
                order.setCountry(newOrder.getCountry());
	            order.setPayment(newOrder.getPayment());
//	            order.setOrderItems(newOrder.getOrderItems());
	            order.setDelivered(newOrder.isDelivered());
	            
	       
	            return orderRepository.save(order);
	        }).orElseGet(() -> {
	            newOrder.setId(id);
	            return orderRepository.save(newOrder);
	        });
	    }   
	    
	    
	    // DELETE ALL ORDERS
	       
	    @DeleteMapping("/orders")
	    public void deleteOrders() {
	        orderRepository.deleteAll();
	    }
	       
	       
	   
	    // DELETE ORDER BY ID
	    
	    @DeleteMapping("/orders/{id}")
	    public void deleteOrderById(@PathVariable UUID id) {
	        orderRepository.deleteById(id);
	    }
	    
	    
	   
	   	
	    
}
