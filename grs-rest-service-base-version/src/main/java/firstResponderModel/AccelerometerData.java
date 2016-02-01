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
//@Table(name = "accelerometerdata", schema = "firstrespondermodel@cassandra_pu")
public class AccelerometerData extends MotionSensorData {

	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "accelerometerDataID")
	private Long accelerometerDataID;
	
	@Column (name = "xAccel")
	private int xAccel;
	
	@Column (name = "yAccel")
	private int yAccel;
	
	@Column (name = "zAccel")
	private int zAccel;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;
	
	//getters & setters

	public Long getAccelerometerDataID() {
		return accelerometerDataID;
	}

	public void setAccelerometerDataID(Long accelerometerDataID) {
		this.accelerometerDataID = accelerometerDataID;
	}

	public int getxAccel() {
		return xAccel;
	}

	public void setxAccel(int xAccel) {
		this.xAccel = xAccel;
	}

	public int getyAccel() {
		return yAccel;
	}

	public void setyAccel(int yAccel) {
		this.yAccel = yAccel;
	}

	public int getzAccel() {
		return zAccel;
	}

	public void setzAccel(int zAccel) {
		this.zAccel = zAccel;
	}

	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}

	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	
	
	
	
	
	
}
