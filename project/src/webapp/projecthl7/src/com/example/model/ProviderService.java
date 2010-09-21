package com.example.model;

import java.util.Date;

public class ProviderService {
	private long id;
	private Date createdOn;
	private Provider provider;
	private Provider providerTwo;
	private int status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Provider getProviderTwo() {
		return providerTwo;
	}
	public void setProviderTwo(Provider providerTwo) {
		this.providerTwo = providerTwo;
	}
}
