package com.legacy.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.legacy.model.entities.Order;
import com.legacy.model.entities.OrderItem;
import com.legacy.model.entities.Product;
import com.legacy.model.entities.User;
import com.legacy.model.entities.enums.Category;
import com.legacy.model.entities.enums.OrderStatus;
import com.legacy.model.entities.enums.UserType;
import com.legacy.model.repositories.OrderRepository;
import com.legacy.model.repositories.ProductRepository;
import com.legacy.model.repositories.UserRepository;

@Configuration
public class InstanciationTest implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		productRepository.deleteAll();
		orderRepository.deleteAll();
		
		User user = new User(null, "Tiago", "Mendes", "50434220841", LocalDate.parse("2001-07-02"), UserType.SELLER);		
		userRepository.save(user);
		
		Product prod = new Product(null, "Redmi Note 12 6Gb", LocalDate.now());
		prod.getCategories().addAll(Arrays.asList(Category.SMARTPHONES));
		productRepository.save(prod);
		
		OrderItem orderItem = new OrderItem(null, prod, 20, 15.99);
		
		Order ord = new Order(null, Instant.now(), OrderStatus.AWAITING_SHIPMENT, user, null);
		ord.getItems().add(orderItem);
		orderRepository.save(ord);
	}

}
