package com.legacy.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legacy.model.entities.Order;
import com.legacy.model.repositories.OrderRepository;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	OrderRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		return ResponseEntity.ok().body(repository.findAll());
	}
}
