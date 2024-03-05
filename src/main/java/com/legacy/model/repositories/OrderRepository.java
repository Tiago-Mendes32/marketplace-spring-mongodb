package com.legacy.model.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.legacy.model.entities.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{
}