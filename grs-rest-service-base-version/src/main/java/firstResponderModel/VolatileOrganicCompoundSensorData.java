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
//@Table(name = "volatileorganiccompoundsensordata", schema = "firstrespondermodel@cassandra_pu")
public class VolatileOrganicCompoundSensorData extends GasSensorData {
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column(name = "volatileOrganicCompoundSensorDataID")
	private Long volatileOrganicCompoundSensorDataID;

	@Column(name = "vocConcentrationInEnvironment")
	private int vocConcentrationInEnvironment;
	
	@Column(name = "vocConcentrationInEnvironmentUnits")
	private String vocConcentrationInEnvironmentUnits;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;
	
	

	// getters & setters
	

	

	public Long getVolatileOrganicCompoundSensorDataID() {
		return volatileOrganicCompoundSensorDataID;
	}

	public void setVolatileOrganicCompoundSensorDataID(Long volatileOrganicCompoundSensorDataID) {
		this.volatileOrganicCompoundSensorDataID = volatileOrganicCompoundSensorDataID;
	}

	public int getVocConcentrationInEnvironment() {
		return vocConcentrationInEnvironment;
	}

	public void setVocConcentrationInEnvironment(int vocConcentrationInEnvironment) {
		this.vocConcentrationInEnvironment = vocConcentrationInEnvironment;
	}

	public String getVocConcentrationInEnvironmentUnits() {
		return vocConcentrationInEnvironmentUnits;
	}

	public void setVocConcentrationInEnvironmentUnits(String vocConcentrationInEnvironmentUnits) {
		this.vocConcentrationInEnvironmentUnits = vocConcentrationInEnvironmentUnits;
	}

	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}

	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	
	
	
	
      
}
