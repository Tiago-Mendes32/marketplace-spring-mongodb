package com.legacy.model.entities;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class OrderItem {
	
	@Id
	private String id;
	private Product product;
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
	}

	public OrderItem(String id, Product product, Integer quantity, Double price) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
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
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
}
