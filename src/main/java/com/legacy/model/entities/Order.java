package com.legacy.model.entities;

import java.time.Instant;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.legacy.model.entities.DTO.UserDTO;
import com.legacy.model.entities.enums.OrderStatus;

@Document
public class Order {
	
	@Id
	private String id;
	private Instant moment;
	private OrderStatus orderStatus;
	
	private UserDTO seller;
	private UserDTO payer;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	public Order() {
	}

	public Order(String id, Instant moment, OrderStatus orderStatus, UserDTO seller, UserDTO payer) {
		this.id = id;
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.seller = seller;
		this.payer = payer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public UserDTO getSeller() {
		return seller;
	}

	public void setSeller(UserDTO seller) {
		this.seller = seller;
	}

	public UserDTO getPayer() {
		return payer;
	}

	public void setPayer(UserDTO payer) {
		this.payer = payer;
	}

	public List<OrderItem> getItems() {
		return items;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
}
