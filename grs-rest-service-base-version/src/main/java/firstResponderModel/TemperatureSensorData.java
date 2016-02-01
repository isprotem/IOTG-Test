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
//@Table(name = "temperaturesensordata", schema = "firstrespondermodel@cassandra_pu")
public class TemperatureSensorData extends EnvironmentSensorData {
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "temperatureSensorDataID")
	private Long temperatureSensorDataID;
	
	@Column (name = "ambientTemperature")
	private int ambientTemperature;
	
	@Column (name = "ambientTemperatureUnits")
	private String ambientTemperatureUnits;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;


	


	//getters & setters
	
	public Long getTemperatureSensorDataID() {
		return temperatureSensorDataID;
	}

	public void setTemperatureSensorDataID(Long temperatureSensorDataID) {
		this.temperatureSensorDataID = temperatureSensorDataID;
	}

	public int getAmbientTemperature() {
		return ambientTemperature;
	}

	
	public void setAmbientTemperature(int ambientTemperature) {
		this.ambientTemperature = ambientTemperature;
	}

	public String getAmbientTemperatureUnits() {
		return ambientTemperatureUnits;
	}

	public void setAmbientTemperatureUnits(String ambientTemperatureUnits) {
		this.ambientTemperatureUnits = ambientTemperatureUnits;
	}

	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}

	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	
	
	
}
