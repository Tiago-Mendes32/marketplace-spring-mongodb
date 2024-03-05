package com.legacy.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legacy.model.entities.Product;
import com.legacy.model.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}
}
