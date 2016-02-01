/**
 * 
 */
package com.intel.grs.first.responder.ui.model;

import java.io.Serializable;

/**
 * @author yschauhx
 *
 */
public class LocationModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7760806813761252020L;

	/**
	 * 
	 */
	public LocationModel() {
		// TODO Auto-generated constructor stub
	}

	
	public LocationModel(String address, String city, String state, String zipCode, String country, String latitude,
			String longitude) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	private String address;
	
	private String city;
	
	private String state;
	private String zipCode;
	private String country;
	private String latitude;
	private String longitude;

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	
}
