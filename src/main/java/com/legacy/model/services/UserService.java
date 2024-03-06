package com.legacy.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legacy.model.entities.User;
import com.legacy.model.entities.DTO.UserDTO;
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
	
	public User update(User obj, User refObj) {
		refObj = updateData(obj, refObj);
		return save(refObj);
	}

	private User updateData(User obj, User refObj) {
		refObj.setFisrtName(obj.getFisrtName());
		refObj.setLastName(obj.getLastName());
		refObj.setDocument(obj.getDocument());
		refObj.setBirthday(obj.getBirthday());
		refObj.setUserType(obj.getUserType());
		
		return refObj;
	}
	
	public void deleteById(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public UserDTO convertDTO(User obj) {
		obj = findById(obj.getId());
		return new UserDTO(obj.getId(), obj.getFisrtName(), obj.getDocument());
	}
	
	public List<UserDTO> convertListDTO(List<User> listObj) {
		List<User> list = findAll();
		List<UserDTO> listDTO = new ArrayList<>();
		
		for(User x: list) {
			listDTO.add(convertDTO(x));
		}
		return listDTO;
	}
}


