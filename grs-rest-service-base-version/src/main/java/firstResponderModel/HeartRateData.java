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
//@Table(name = "heartratedata", schema = "firstrespondermodel@cassandra_pu")
public class HeartRateData extends BiometricSensorData{
	
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "heartRateDataID")
	private Long heartRateDataID;
	
	@Column (name = "heartRate")
	private int heartRate;
	
	@Column (name = "pulseRate")
	private int pulseRate;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;


	
	//getters & setters
	
	public Long getHeartRateDataID() {
		return heartRateDataID;
	}

	public void setHeartRateDataID(Long heartRateDataID) {
		this.heartRateDataID = heartRateDataID;
	}

	public int getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public int getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(int pulseRate) {
		this.pulseRate = pulseRate;
	}

	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}

	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	
	

}
