package firstResponderModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@Table(name = "ecgdata", schema = "firstrespondermodel@cassandra_pu")
public class ECGData extends BiometricSensorData {
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column(name="ecgDataID")
	private Long ecgDataID;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;


	//getters & setters
	
	public Long getEcgDataID() {
		return ecgDataID;
	}


	public void setEcgDataID(Long ecgDataID) {
		this.ecgDataID = ecgDataID;
	}


	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}


	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	
	

}
