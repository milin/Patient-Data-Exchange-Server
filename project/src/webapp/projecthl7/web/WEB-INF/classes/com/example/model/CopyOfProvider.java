package com.example.model;


import java.util.Date;
import java.util.Set;

public class CopyOfProvider {
	private long id;
	private String name;
	private String username;
    private String password;
	private Short type;
    private String www;
    private String contactName;
	private String contactMobile;
    private String ipAddress;
	private String twoNdIp;
	private String address;
	private String zip;
	private String phone;
    private String fax;
	private String contactEmail;
	private Integer status;
	private Integer statusOnline;
	private Date createdOn;
	private String serviceId;
    private Set<Personal> personals = new java.util.HashSet<Personal>();
    private Set<ProviderService> providerServices = new java.util.HashSet<ProviderService>();
    private Set<ProviderService> providerServicess = new java.util.HashSet<ProviderService>();
    private Set<Online> onlines = new java.util.HashSet<Online>();
    private City city;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}
	public String getWww() {
		return www;
	}
	public void setWww(String www) {
		this.www = www;
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
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getTwoNdIp() {
		return twoNdIp;
	}
	public void setTwoNdIp(String twoNdIp) {
		this.twoNdIp = twoNdIp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getStatusOnline() {
		return statusOnline;
	}
	public void setStatusOnline(Integer statusOnline) {
		this.statusOnline = statusOnline;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Set<Personal> getPersonals() {
		return personals;
	}
	public void setPersonals(Set<Personal> personals) {
		this.personals = personals;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Set<ProviderService> getProviderServices() {
		return providerServices;
	}
	public void setProviderServices(Set<ProviderService> providerServices) {
		this.providerServices = providerServices;
	}
	public Set<ProviderService> getProviderServicess() {
		return providerServicess;
	}
	public void setProviderServicess(Set<ProviderService> providerServicess) {
		this.providerServicess = providerServicess;
	}
	public Set<Online> getOnlines() {
		return onlines;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public void setOnlines(Set<Online> onlines) {
		this.onlines = onlines;
	}
	
}