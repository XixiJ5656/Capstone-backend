package com.ecommerce.backend.model;




import java.sql.Timestamp;
import java.util.UUID;

//import java.sql.Timestamp;
//import java.util.ArrayList;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name="customer_orders")
public class Order {
    
	
	@Id
	@Column(name="order_no.")
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	@NotBlank
	private String zipcode;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String payment;
	
//	@NotBlank
//	private ArrayList<OrderItem> orderItems;
	
	@NotBlank
	private boolean delivered;
	

	@CreationTimestamp
	private Timestamp createTime;
	
	
	@UpdateTimestamp
	private Timestamp updateTime;

	
	public Order() {
		
	}


	public Order(@NotBlank String username, @NotBlank String address, @NotBlank String city, @NotBlank String state,
			@NotBlank String zipcode, @NotBlank String country, @NotBlank String payment,
		 @NotBlank boolean delivered) {
		
		this.username = username;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
		this.payment = payment;
//		this.orderItems = orderItems;
		this.delivered = delivered;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPayment() {
		return payment;
	}


	public void setPayment(String payment) {
		this.payment = payment;
	}

//
//	public ArrayList<String> getOrderItems() {
//		return orderItems;
//	}
//
//
//	public void setOrderItems(ArrayList<String> orderItems) {
//		this.orderItems = orderItems;
//	}


	public boolean isDelivered() {
		return delivered;
	}


	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}


	public Timestamp getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


	public Timestamp getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}


}
