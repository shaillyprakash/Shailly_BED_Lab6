package com.gl.collegefest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String name) {
		super();
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
