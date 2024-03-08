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
import com.legacy.model.services.ProductService;
import com.legacy.model.services.UserService;

@Configuration
public class InstanciationTest implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		productRepository.deleteAll();
		orderRepository.deleteAll();
		
		User user = new User(null, "Tiago", "Mendes", "50434220841", LocalDate.parse("2001-07-02"), UserType.SELLER);		
		userRepository.save(user);
		
		User user2 = new User(null, "Lucas", "Mendes", "50434220841", LocalDate.parse("2001-07-02"), UserType.SELLER);		
		userRepository.save(user2);
		
		Product prod = new Product(null, "Redmi Note 12 6Gb", LocalDate.now(), 999.99, 150);
		prod.getCategories().addAll(Arrays.asList(Category.SMARTPHONES));
		productRepository.save(prod);
		
		Order ord = new Order(null, Instant.now(), OrderStatus.AWAITING_SHIPMENT, userService.convertDTO(user), userService.convertDTO(user2));
		
		OrderItem orderItem = new OrderItem(productService.convertDTO(prod), productService.stockValidation(prod, 25), OrderItem.getSubtotal(prod));
		
		ord.getItems().add(orderItem);
		orderRepository.save(ord);
	}

}
