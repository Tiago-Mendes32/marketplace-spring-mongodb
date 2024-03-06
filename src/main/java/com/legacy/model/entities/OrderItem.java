package com.legacy.model.entities;

import java.io.Serializable;

import com.legacy.model.entities.DTO.ProductDTO;

public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ProductDTO product;
	private Integer quantity;
	private Double price;

	
	public OrderItem() {
	}

	public OrderItem(ProductDTO product, Integer quantity, Double price) {
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
