package com.hsr.springcloud.msvc.products.services;

import java.util.List;
import java.util.Optional;

import com.hsr.springcloud.msvc.products.entities.Product;

public interface ProductService {

    //Listar todos
    List<Product> findAll();

    //Buscar por Id
    Optional<Product> findById(Long id);
}
