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
//@Table(name = "gyroscopedata", schema = "firstrespondermodel@cassandra_pu")
public class GyroscopeData extends MotionSensorData {

	@Id
//	@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
//	@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "gyroscopeDataID")
	private Long gyroscopeDataID;
	
	@Column (name = "degPerSecPitch")
	private int degPerSecPitch;
	
	@Column (name = "degPerSecRoll")
	private int degPerSecRoll;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;

	
	//getters & setters
	
	public Long getGyroscopeDataID() {
		return gyroscopeDataID;
	}

	public void setGyroscopeDataID(Long gyroscopeDataID) {
		this.gyroscopeDataID = gyroscopeDataID;
	}

	public int getDegPerSecPitch() {
		return degPerSecPitch;
	}

	public void setDegPerSecPitch(int degPerSecPitch) {
		this.degPerSecPitch = degPerSecPitch;
	}

	public int getDegPerSecRoll() {
		return degPerSecRoll;
	}

	public void setDegPerSecRoll(int degPerSecRoll) {
		this.degPerSecRoll = degPerSecRoll;
	}

	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}

	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	
	
}
