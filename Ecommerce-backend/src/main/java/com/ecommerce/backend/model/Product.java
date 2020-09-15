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
    
    @NotBlank
    private String image;
    
    @NotBlank
    @Size(max=20)
    private String type;
 
    @NotBlank
    private float price;
    
    @NotBlank
    private ArrayList<String> size;
    
    @NotBlank
    private ArrayList<String> color;
    
    @NotBlank
    private String description;
    
    public Product() {
    	
    }

	public Product(@NotBlank @Size(max = 200) String name, @NotBlank String image,
			@NotBlank @Size(max = 20) String type, @NotBlank float price, @NotBlank ArrayList<String> size,
			@NotBlank ArrayList<String> color, @NotBlank String description) {
		this.name = name;
		this.image = image;
		this.type = type;
		this.price = price;
		this.size = size;
		this.color = color;
		this.description = description;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	

}
