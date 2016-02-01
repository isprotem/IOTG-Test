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
//@Table(name = "poisonousgasdata", schema = "firstrespondermodel@cassandra_pu")
public class PoisonousGasData extends GasSensorData {
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "poisonousGasDataID")
	private Long poisonousGasDataID;
	
	
	@Column (name = "carbonMonoxideConcentration")
	private int carbonMonoxideConcentration;
	
	@Column (name = "carbonMonoxideConcentrationUnits")
	private String carbonMonoxideConcentrationUnits;
	
	@Column (name = "phosgeneConcentration")
	private int phosgeneConcentration;
	
	@Column (name = "phosgeneConcentrationUnits")
	private String phosgeneConcentrationUnits;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;
	
	
	// ****getters & setters******
	public int getCarbonMonoxideConcentration() {
		return carbonMonoxideConcentration;
	}
	public void setCarbonMonoxideConcentration(int carbonMonoxideConcentration) {
		this.carbonMonoxideConcentration = carbonMonoxideConcentration;
	}
	public String getCarbonMonoxideConcentrationUnits() {
		return carbonMonoxideConcentrationUnits;
	}
	public void setCarbonMonoxideConcentrationUnits(String carbonMonoxideConcentrationUnits) {
		this.carbonMonoxideConcentrationUnits = carbonMonoxideConcentrationUnits;
	}
	public int getPhosgeneConcentration() {
		return phosgeneConcentration;
	}
	public void setPhosgeneConcentration(int phosgeneConcentration) {
		this.phosgeneConcentration = phosgeneConcentration;
	}
	public String getPhosgeneConcentrationUnits() {
		return phosgeneConcentrationUnits;
	}
	public void setPhosgeneConcentrationUnits(String phosgeneConcentrationUnits) {
		this.phosgeneConcentrationUnits = phosgeneConcentrationUnits;
	}
	public Long getPoisonousGasDataID() {
		return poisonousGasDataID;
	}
	public void setPoisonousGasDataID(Long poisonousGasDataID) {
		this.poisonousGasDataID = poisonousGasDataID;
	}
	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}
	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	
	
	
	

}
