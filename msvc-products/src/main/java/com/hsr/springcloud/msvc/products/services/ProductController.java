package com.hsr.springcloud.msvc.products.services;

import org.springframework.web.bind.annotation.RestController;

import com.hsr.springcloud.msvc.products.entities.Product;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductController {

    final private ProductService service;

    //Constructor
    public ProductController(ProductService service) {
        this.service = service;
    }
    

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(this.service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id) {

        Optional<Product> productoOptional = this.service.findById(id);

        if (productoOptional.isPresent()){
            return ResponseEntity.ok(productoOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }
    
}
