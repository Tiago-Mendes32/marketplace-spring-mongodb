package com.legacy.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legacy.model.entities.Order;
import com.legacy.model.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}
}
