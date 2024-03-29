package com.legacy.model.entities.DTO;

import java.util.Objects;

import com.legacy.model.entities.enums.UserType;

public class UserDTO {

	private String id;
	private String name;
	private String document;
	
	public UserDTO() {
	}

	public UserDTO(String id, String name, String document) {
		this.id = id;
		this.name = name;
		this.document = document;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
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
		UserDTO other = (UserDTO) obj;
		return Objects.equals(id, other.id);
	}
}
