package com.legacy.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.RepresentationModel;

import com.legacy.model.entities.enums.UserType;

@Document
public class User extends RepresentationModel<User> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String fisrtName;
	private String lastName;
	private String document;
	private LocalDate birthday;
	
	private UserType userType;
	
	public User() {
	}

	public User(String id, String fisrtName, String lastName, String document, LocalDate birthday, UserType userType) {
		this.id = id;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.document = document;
		this.birthday = birthday;
		this.userType = userType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
