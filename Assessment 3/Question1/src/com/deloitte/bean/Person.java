package com.deloitte.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Person")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Person_id")
	private int id;
	@Column(name="Person_name")
	private String name;
	@Column(name="Person_password")
	private String password;

	public Person() {
	}

	public Person(int id, String name, String gender, String email, String mobile) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotEmpty(message="Enter the person's name.")
	@Pattern(regexp="^[A-Z][A-Za-z]{2,40}$", 
	   message="Person name should have only characters and the first letter should be uppercase")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name +"]";
	}

}
