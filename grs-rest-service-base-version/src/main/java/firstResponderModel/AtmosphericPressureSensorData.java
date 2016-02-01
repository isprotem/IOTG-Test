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
//@Table(name = "atmosphericpressuresensordata", schema = "firstrespondermodel@cassandra_pu")
public class AtmosphericPressureSensorData extends EnvironmentSensorData {
	
	
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "atmosphericPressureSensorDataID")
	private Long atmosphericPressureSensorDataID;
	
	@Column (name = "barometricPressure")
	private int barometricPressure;
	
	@Column (name = "barometricPressureUnits")
	private String barometricPressureUnits;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;
	
	
	
	//getters & setters

	

	public Long getAtmosphericPressureSensorDataID() {
		return atmosphericPressureSensorDataID;
	}

	public void setAtmosphericPressureSensorDataID(Long atmosphericPressureSensorDataID) {
		this.atmosphericPressureSensorDataID = atmosphericPressureSensorDataID;
	}

	public int getBarometricPressure() {
		return barometricPressure;
	}

	public void setBarometricPressure(int barometricPressure) {
		this.barometricPressure = barometricPressure;
	}

	public String getBarometricPressureUnits() {
		return barometricPressureUnits;
	}

	public void setBarometricPressureUnits(String barometricPressureUnits) {
		this.barometricPressureUnits = barometricPressureUnits;
	}

	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}

	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	

}
