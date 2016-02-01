package firstResponderModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
//@Table (name = "pulseoximeterdata", schema = "firstrespondermodel@cassandra_pu")
public class PulseOximeterData extends BiometricSensorData {
	
	@Id
//	@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
//	@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "pulseOximeterDataID")
	private Long pulseOximeterDataID;
	
	@Column (name = "bloodOxidationLevel")
	private int bloodOxidationLevel;
	
	@Column (name = "bloodOxidationLevelUnits")
	private String bloodOxidationLevelUnits;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;
	
	//getters & setters
	
	public Long getPulseOximeterDataID() {
		return pulseOximeterDataID;
	}

	public void setPulseOximeterDataID(Long pulseOximeterDataID) {
		this.pulseOximeterDataID = pulseOximeterDataID;
	}

	public int getBloodOxidationLevel() {
		return bloodOxidationLevel;
	}

	public void setBloodOxidationLevel(int bloodOxidationLevel) {
		this.bloodOxidationLevel = bloodOxidationLevel;
	}

	public String getBloodOxidationLevelUnits() {
		return bloodOxidationLevelUnits;
	}

	public void setBloodOxidationLevelUnits(String bloodOxidationLevelUnits) {
		this.bloodOxidationLevelUnits = bloodOxidationLevelUnits;
	}

	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}

	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}

	
	
}
