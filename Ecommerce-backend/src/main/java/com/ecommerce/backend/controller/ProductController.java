package com.ecommerce.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.exception.ResourceNotFoundException;
import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.repository.ProductRepository;


@RestController
@RequestMapping(value = "/api/app")
public class ProductController {


    @Autowired
    private ProductRepository productRepository;
 
    //GET ALL PRODUCTS
 
    @GetMapping("/products")
    public List<Product> getAllProducts(Model model) {
        return this.productRepository.findAll();
    }
 
    
    // GET PRODUCT BY ID
       
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId)
    throws ResourceNotFoundException {Product product= productRepository.findById(productId)
          .orElseThrow(() -> new ResourceNotFoundException("Could not found product for this id :: " + productId));
         return ResponseEntity.ok().body(product);
       }
       
       
    // SAVE PRODUCT
       
    @PostMapping("/products")
    public Product addProduct(@Validated @RequestBody Product product) {
   	 return productRepository.save(product);
    }    
      
    
    // UPDATE PRODUCT BY ID

    @PutMapping("/products/{id}")
    Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
 
        return productRepository.findById(id).map(product -> {
            product.setName(newProduct.getName());
            product.setImage(newProduct.getImage());
            product.setType(newProduct.getType());
            product.setType(newProduct.getType());
            product.setPrice(newProduct.getPrice());
            product.setSize(newProduct.getSize());
            product.setColor(newProduct.getColor());
            return productRepository.save(product);
        }).orElseGet(() -> {
            newProduct.setId(id);
            return productRepository.save(newProduct);
        });
    }   
    
    
    // DELETE ALL PRODUCTS
       
    @DeleteMapping("/products")
    void deleteProduct() {
        productRepository.deleteAll();
    }
       
       
   
    // DELETE PRODUCT BY ID
    
    @DeleteMapping("/products/{id}")
    void deleteProductById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
    
}

