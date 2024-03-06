package com.legacy.model.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.legacy.model.entities.Order;
import com.legacy.model.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	OrderService service;

	@PostMapping
	public ResponseEntity<Order> save(@RequestBody Order obj) {
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).body(service.save(obj));
	}

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable String id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Order> update(@RequestBody Order obj, @PathVariable String id) {
		Order refObj = service.findById(id);
		return ResponseEntity.ok().body(service.update(obj, refObj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
