package firstResponderModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;


@MappedSuperclass


public abstract class ActivePersonnel{
	
	/*@Column(name = "personnelID")
	private String personnelID;*/
	
	
	@Column(name = "personnelName")
	private String personnelName;
    
	@Column(name = "personnelTitle")
	private String personnelTitle;
	
	@Column (name = "personnelAge")
	private int personnelAge;
	
	@Column (name = "personnelGender")
	private String personnelGender;
	
	@Column (name = "personnelSSN")
	private String personnelSSN;
	
	@Column (name = "address1")
	private String address1;
	
	@Column (name = "address2")
	private String address2;
	
	@Column (name = "address3")
	private String address3;
	
	@Column (name = "city")
	private String city;
	
	@Column (name = "state")
	private String state;
	
	@Column (name = "postalCode")
	private String postalCode;
	
	@Column (name = "phoneNumber")
	private String phoneNumber;
	
	@Column (name = "startDateWithCorporation")
	@JsonFormat (pattern = "MM/dd/yyyy")
	private Date startDateWithCorporation;
	
	@Column (name = "positionTitle")
	private String positionTitle;
	
	@Column (name = "professionalSpeciality")
	private String professionalSpeciality;
	
	@Column (name = "isActive")
	private boolean isActive;
	

	//private GeographicLocation locationOfActivePersonnel;
	
	public ActivePersonnel()
	{
		
	}
	
	
	// getters and setters
	
	public String getPersonnelName() {
		return personnelName;
	}

	public void setPersonnelName(String personnelName) {
		this.personnelName = personnelName;
	}

	public String getPersonnelTitle() {
		return personnelTitle;
	}

	public void setPersonnelTitle(String personnelTitle) {
		this.personnelTitle = personnelTitle;
	}


	public int getPersonnelAge() {
		return personnelAge;
	}


	public void setPersonnelAge(int personnelAge) {
		this.personnelAge = personnelAge;
	}


	public String getPersonnelGender() {
		return personnelGender;
	}


	public void setPersonnelGender(String personnelGender) {
		this.personnelGender = personnelGender;
	}


	public String getPersonnelSSN() {
		return personnelSSN;
	}


	public void setPersonnelSSN(String personnelSSN) {
		this.personnelSSN = personnelSSN;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getAddress3() {
		return address3;
	}


	public void setAddress3(String address3) {
		this.address3 = address3;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Date getStartDateWithCorporation() {
		return startDateWithCorporation;
	}


	public void setStartDateWithCorporation(Date startDateWithCorporation) {
		this.startDateWithCorporation = startDateWithCorporation;
	}


	public String getPositionTitle() {
		return positionTitle;
	}


	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}


	public String getProfessionalSpeciality() {
		return professionalSpeciality;
	}


	public void setProfessionalSpeciality(String professionalSpeciality) {
		this.professionalSpeciality = professionalSpeciality;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

/*
	public String getPersonnelID() {
		return personnelID;
	}


	public void setPersonnelID(String personnelID) {
		this.personnelID = personnelID;
	}*/

	

}

