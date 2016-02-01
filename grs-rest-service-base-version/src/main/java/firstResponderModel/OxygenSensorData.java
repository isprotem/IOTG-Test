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
//@Table(name = "oxygensensordata", schema = "firstrespondermodel@cassandra_pu")
public class OxygenSensorData extends GasSensorData{
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column(name="oxygenSensorDataID")
	private Long oxygenSensorDataID;
	
	
	@Column(name="oxygenConcentration")
	public int oxygenConcentration;
	@Column(name="oxygenConcentrationUnits")
	public String oxygenConcentrationUnits;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;

	
	//getters and setters
	public Long getOxygenSensorDataID() {
		return oxygenSensorDataID;
	}

	public void setOxygenSensorDataID(Long oxygenSensorDataID) {
		this.oxygenSensorDataID = oxygenSensorDataID;
	}

	public int getOxygenConcentration() {
		return oxygenConcentration;
	}

	public void setOxygenConcentration(int oxygenConcentration) {
		this.oxygenConcentration = oxygenConcentration;
	}

	public String getOxygenConcentrationUnits() {
		return oxygenConcentrationUnits;
	}

	public void setOxygenConcentrationUnits(String oxygenConcentrationUnits) {
		this.oxygenConcentrationUnits = oxygenConcentrationUnits;
	}

	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}

	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}

}



