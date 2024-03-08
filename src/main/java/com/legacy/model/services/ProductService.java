package com.legacy.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legacy.model.entities.Product;
import com.legacy.model.entities.DTO.ProductDTO;
import com.legacy.model.repositories.ProductRepository;
import com.legacy.model.services.exceptions.InsuficientStockException;
import com.legacy.model.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(String id) {
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Entity not found: " + id));
	}

	public Product save(Product obj) {
		return repository.save(obj);
	}
	
	public Product update(Product obj, Product refObj) {
		obj = updateData(obj, refObj);
		return save(obj);
	}

	private Product updateData(Product obj, Product refObj) {
		refObj.setCreateDate(obj.getCreateDate());
		refObj.setName(obj.getName());
		
		return refObj;
	}
	
	public void deleteById(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public ProductDTO convertDTO(Product obj) {
		obj = findById(obj.getId());
		return new ProductDTO(obj.getId(), obj.getName(), obj.getPrice());
	}
	
	public List<ProductDTO> convertListDTO(List<Product> listObj) {
		List<Product> list = findAll();
		List<ProductDTO> listDTO = new ArrayList<>();
		
		for(Product x: list) {
			listDTO.add(convertDTO(x));
		}
		return listDTO;
	}
	
	public Integer stockValidation(Product prod, Integer qnt) throws InsuficientStockException {
		if (prod.getQuantity() < qnt) {
			throw new InsuficientStockException("Stock not suficient! Available stock: " + prod.getQuantity());
		}
		return qnt;
	}
}


