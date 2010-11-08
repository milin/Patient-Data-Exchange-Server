package com.check.www;
import java.util.ArrayList;

public class InputForm extends org.apache.struts.action.ActionForm
{

	private String country;
    
    private String state;

    private ArrayList countryList;

    private ArrayList stateList;
     private String patientid;
	 private String firstname;
	 private String lastname;
	 private String sex;
	 private String age;
	 private String phoneno;
	 private String email;
     private String address;
     

    public InputForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the country
     */
    
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the countryList
     */
    public ArrayList getCountryList() {
        return countryList;
    }

    /**
     * @param countryList the countryList to setp
     */
    public void setCountryList(ArrayList countryList) {
        this.countryList = countryList;
    }

    /**
     * @return the stateList
     */
    public ArrayList getStateList() {
        return stateList;
    }

    /**
     * @param stateList the stateList to set
     */
    public void setStateList(ArrayList stateList) {
        this.stateList = stateList;
    }

}
