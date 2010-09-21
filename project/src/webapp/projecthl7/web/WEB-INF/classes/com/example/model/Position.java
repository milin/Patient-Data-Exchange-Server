package com.example.model;

import java.util.Set;


public class Position {
	private int id;
	private String name;
	private Set<Personal> personals = new java.util.HashSet<Personal>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Personal> getPersonals() {
		return personals;
	}
	public void setPersonals(Set<Personal> personals) {
		this.personals = personals;
	}

	
}
