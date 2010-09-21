package com.example.model;



import java.util.Set;

public class Provider {
	private long id;
	private String name;
	private Short type;
    private String www;
    private String ipAddress;
	private String twoNdIp;
	private String address;
	private String zip;
	private String phone;
    private String fax;
	private Integer status;
	private Integer statusOnline;
	private String serviceId;
	private Integer numberStaff;
	private Set<ProviderStaff> providerStaffs = new java.util.HashSet<ProviderStaff>();
    
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
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Integer getNumberStaff() {
		return numberStaff;
	}
	public void setNumberStaff(Integer numberStaff) {
		this.numberStaff = numberStaff;
	}
	public Set<ProviderStaff> getProviderStaffs() {
		return providerStaffs;
	}
	public void setProviderStaffs(Set<ProviderStaff> providerStaffs) {
		this.providerStaffs = providerStaffs;
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