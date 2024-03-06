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

	public Order findById(String id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("Entity not found!"));
	}

	public Order save(Order obj) {
		return repository.save(obj);
	}
	
	public Order update(Order obj, Order refObj) {
		obj = updateData(obj, refObj);
		return save(obj);
	}

	private Order updateData(Order obj, Order refObj) {
		refObj.setMoment(obj.getMoment());
		refObj.setOrderStatus(obj.getOrderStatus());
		refObj.setPayer(obj.getPayer());
		refObj.setSeller(obj.getSeller());
		return refObj;
	}
	
	public void deleteById(String id) {
		findById(id);
		repository.deleteById(id);
	}	
}


