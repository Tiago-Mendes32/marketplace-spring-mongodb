package com.legacy.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legacy.model.entities.User;
import com.legacy.model.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("Entity not found!"));
	}

	public User save(User obj) {
		return repository.save(obj);
	}
}
