package com.legacy.model.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.legacy.model.entities.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
}