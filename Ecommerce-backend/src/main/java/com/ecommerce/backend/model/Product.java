package com.ecommerce.backend.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
	
    @Id
    @GeneratedValue
    @Column(name="product_id")
    private Long id;
    
    @NotBlank
	@Size(max = 200)
    private String name;
    
  
    private int inventory;
    
    @NotBlank
    @Size(max=20)
    private String type;
 
   
    private float price;
    
   
    private ArrayList<String> size;
    
   
    private ArrayList<String> color;
    
    @NotBlank
    private String description;
    
    
    private ArrayList<String> image;
    
    
    public Product() {
    	
    }


	public Product(@NotBlank @Size(max = 200) String name, int inventory,
			@NotBlank @Size(max = 20) String type,  float price,  ArrayList<String> size,
			 ArrayList<String> color, @NotBlank String description, ArrayList<String> image) {
		super();
		this.name = name;
		this.inventory = inventory;
		this.type = type;
		this.price = price;
		this.size = size;
		this.color = color;
		this.description = description;
		this.image = image;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getInventory() {
		return inventory;
	}


	public void setInventory(int inventory) {
		this.inventory = inventory;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public ArrayList<String> getSize() {
		return size;
	}


	public void setSize(ArrayList<String> size) {
		this.size = size;
	}


	public ArrayList<String> getColor() {
		return color;
	}


	public void setColor(ArrayList<String> color) {
		this.color = color;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public ArrayList<String> getImage() {
		return image;
	}


	public void setImage(ArrayList<String> image) {
		this.image = image;
	}
    

}
