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
//@Table(name = "hydrationdata", schema = "firstrespondermodel@cassandra_pu")
public class HydrationData extends BiometricSensorData{
	
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "hydrationDataID")
	private Long hydrationDataID;
	
	@Column (name = "breathMoistureLevel")
	private int breathMoistureLevel;
	
	@Column (name = "breathMoistureLevelUnits")
	private String breathMoistureLevelUnits;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;
	
	//getters & setters
	
	public Long getHydrationDataID() {
		return hydrationDataID;
	}

	public void setHydrationDataID(Long hydrationDataID) {
		this.hydrationDataID = hydrationDataID;
	}

	public int getBreathMoistureLevel() {
		return breathMoistureLevel;
	}

	public void setBreathMoistureLevel(int breathMoistureLevel) {
		this.breathMoistureLevel = breathMoistureLevel;
	}

	public String getBreathMoistureLevelUnits() {
		return breathMoistureLevelUnits;
	}

	public void setBreathMoistureLevelUnits(String breathMoistureLevelUnits) {
		this.breathMoistureLevelUnits = breathMoistureLevelUnits;
	}

	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}

	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	
	
	
}
