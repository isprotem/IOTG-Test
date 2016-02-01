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
//@Table(name = "humiditysensordata", schema = "firstrespondermodel@cassandra_pu")
public class HumiditySensorData extends EnvironmentSensorData {

	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "humiditySensorDataID")
	private Long humiditySensorDataID;
	
	@Column (name = "environmentHumidity")
	private int environmentHumidity;
	
	@Column (name = "environmentHumidityUnits")
	private String environmentHumidityUnits;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;


	
	//getters & setters
	
	public Long getHumiditySensorDataID() {
		return humiditySensorDataID;
	}

	public void setHumiditySensorDataID(Long humiditySensorDataID) {
		this.humiditySensorDataID = humiditySensorDataID;
	}

	public int getEnvironmentHumidity() {
		return environmentHumidity;
	}

	public void setEnvironmentHumidity(int environmentHumidity) {
		this.environmentHumidity = environmentHumidity;
	}

	public String getEnvironmentHumidityUnits() {
		return environmentHumidityUnits;
	}

	public void setEnvironmentHumidityUnits(String environmentHumidityUnits) {
		this.environmentHumidityUnits = environmentHumidityUnits;
	}

	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}

	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	
	
}
