

package firstResponderModel;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.impetus.client.cassandra.thrift.*;
import com.impetus.kundera.index.Index;
import com.impetus.kundera.index.IndexCollection;

@Entity
//@Table(name = "geographiclocation",/*schema = "test",*/ schema = "firstrespondermodel@cassandra_pu")

//@IndexCollection(columns = { @Index(name = "nearbyLocations"), @Index(name = "firstResponder") })
public class GeographicLocation{
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column(name="geographicLocation_ID")
	private Long geographicLocationID;

	@Column(name="locationName")
	private String locationName;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="address3")
	private String address3;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postalCode")
	private String postalCode;
	
	@Column(name="country")
	private String country;
	
	@Column(name="latitude")
	private Float latitude;
	
	@Column(name="longitude")
	private Float longitude;
	
	@Column(name="altitude")
	private Float altitude;
	
	/*@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "corporateEntityID")
	private CorporateEntity associatedCorporateEntity;*/
/*
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name="geographicLocation_ID",referencedColumnName="geographicLocation_ID")
	private List<FirstResponder> firstResponder;
	*/

	
	/*
	@ElementCollection
	@CollectionTable(name = "nearbyLocations")
	private List<NearbyLocation> nearbyLocations = new ArrayList<NearbyLocation>();
	
	*/
	
	/*@Column (name = "associatedDevices")
    private ArrayList<Device> associatedDevices;


	public ArrayList<Device> getAssociatedDevices() {
		return associatedDevices;
	}


	public void setAssociatedDevices(ArrayList<Device> associatedDevices) {
		this.associatedDevices = associatedDevices;
	}

	*/
	
	public  GeographicLocation()
	{
		
	}
	
	
	//Getters and Setters
	
	
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getAltitude() {
		return altitude;
	}

	public void setAltitude(Float altitude) {
		this.altitude = altitude;
	}

	public Long getGeographicLocationID() {
		return geographicLocationID;
	}

	public void setGeographicLocationID(Long geographicLocationID) {
		this.geographicLocationID = geographicLocationID;
	}


/*	public CorporateEntity getAssociatedCorporateEntity() {
		return associatedCorporateEntity;
	}


	public void setAssociatedCorporateEntity(CorporateEntity associatedCorporateEntity) {
		this.associatedCorporateEntity = associatedCorporateEntity;
	}


*/



	/*
	
	public List<FirstResponder> getFirstResponder() {
		return firstResponder;
	}

	public void setFirstResponder(List<FirstResponder> firstResponder) {
		this.firstResponder = firstResponder;
	}
	*/
	
	
	
	/*
	 * 
	 * 
	 * public List<NearbyLocation> getNearbyLocations() {
		return nearbyLocations;
	}

	public void setNearbyLocations(List<NearbyLocation> nearbyLocations) {
		this.nearbyLocations = nearbyLocations;
	}
			
			*/
	
	
	
	
	
	
	
	
}

