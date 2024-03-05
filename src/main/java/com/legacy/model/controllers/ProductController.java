package com.legacy.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legacy.model.entities.Product;
import com.legacy.model.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	ProductRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok().body(repository.findAll());
	}
}
