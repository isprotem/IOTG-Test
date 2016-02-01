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
//@Table (name = "combustiblegasdata", schema = "firstrespondermodel@cassandra_pu")
public class CombustibleGasData extends GasSensorData{
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "combustibleGasDataID")
	private Long combustibleGasDataID;
	
	@Column (name = "combustibleGasConcentrationUnits")
	private String combustibleGasConcentrationUnits;
	
	@Column (name = "methaneConcentration")
	private int methaneConcentration;
	
	@Column (name = "hydrogenSulfideConcentration")
	private int hydrogenSulfideConcentration;
	
	@Column (name = "ammoniaConcentration")
	private int ammoniaConcentration;
	
	@Column (name = "propaneConcentration")
	private int propaneConcentration;
	
	@Column (name = "butaneConcentration")
	private int butaneConcentration;
	
	@Column (name = "hectaneConcentration")
	private int hectaneConcentration;
	
	@Column (name = "phosphineConcentration")
	private int phosphineConcentration;
	
	@Column (name = "hydrogenCyanideConcentration")
	private int hydrogenCyanideConcentration;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;
	
	
	
	//getters & Setters
	
	public Long getCombustibleGasDataID() {
		return combustibleGasDataID;
	}
	public void setCombustibleGasDataID(Long combustibleGasDataID) {
		this.combustibleGasDataID = combustibleGasDataID;
	}
	

	public String getCombustibleGasConcentrationUnits() {
		return combustibleGasConcentrationUnits;
	}
	
	public void setCombustibleGasConcentrationUnits(String combustibleGasConcentrationUnits) {
		this.combustibleGasConcentrationUnits = combustibleGasConcentrationUnits;
	}
	public int getMethaneConcentration() {
		return methaneConcentration;
	}
	public void setMethaneConcentration(int methaneConcentration) {
		this.methaneConcentration = methaneConcentration;
	}
	public int getHydrogenSulfideConcentration() {
		return hydrogenSulfideConcentration;
	}
	public void setHydrogenSulfideConcentration(int hydrogenSulfideConcentration) {
		this.hydrogenSulfideConcentration = hydrogenSulfideConcentration;
	}
	public int getAmmoniaConcentration() {
		return ammoniaConcentration;
	}
	public void setAmmoniaConcentration(int ammoniaConcentration) {
		this.ammoniaConcentration = ammoniaConcentration;
	}
	public int getPropaneConcentration() {
		return propaneConcentration;
	}
	public void setPropaneConcentration(int propaneConcentration) {
		this.propaneConcentration = propaneConcentration;
	}
	public int getButaneConcentration() {
		return butaneConcentration;
	}
	public void setButaneConcentration(int butaneConcentration) {
		this.butaneConcentration = butaneConcentration;
	}
	public int getHectaneConcentration() {
		return hectaneConcentration;
	}
	public void setHectaneConcentration(int hectaneConcentration) {
		this.hectaneConcentration = hectaneConcentration;
	}
	public int getPhosphineConcentration() {
		return phosphineConcentration;
	}
	public void setPhosphineConcentration(int phosphineConcentration) {
		this.phosphineConcentration = phosphineConcentration;
	}
	public int getHydrogenCyanideConcentration() {
		return hydrogenCyanideConcentration;
	}
	public void setHydrogenCyanideConcentration(int hydrogenCyanideConcentration) {
		this.hydrogenCyanideConcentration = hydrogenCyanideConcentration;
	}
	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}
	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	
	
	
	
}


