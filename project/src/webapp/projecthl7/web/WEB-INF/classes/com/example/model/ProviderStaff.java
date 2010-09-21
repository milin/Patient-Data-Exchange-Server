package com.example.model;

import java.util.Date;
import java.util.Set;

public class ProviderStaff {
	private Long id;
	private String username;
    private String password;
	private String contactName;
	private String contactMobile;
	private String contactEmail;
	private Date createdOn;
	private Integer status;
	private Integer master;
	private Provider provider;
	private Set<Personal> personals = new java.util.HashSet<Personal>();
	private Set<Online> onlines = new java.util.HashSet<Online>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getMaster() {
		return master;
	}
	public void setMaster(Integer master) {
		this.master = master;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Set<Personal> getPersonals() {
		return personals;
	}
	public void setPersonals(Set<Personal> personals) {
		this.personals = personals;
	}
	public Set<Online> getOnlines() {
		return onlines;
	}
	public void setOnlines(Set<Online> onlines) {
		this.onlines = onlines;
	}
	
}
