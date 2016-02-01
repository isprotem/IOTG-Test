package firstResponderModel;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FlammableGasData extends GasSensorData {
	
	@Id
	@Column (name = "flammableGasDataID")
	private Long flammableGasDataID;
	
	@Column (name  = "flammableGasType")
	private ArrayList<String> flammableGasType;
	
	@Column (name  = "flammableGasTypeConcentration")
	private  ArrayList<String>  flammableGasTypeConcentration;
	
	@Column (name  = "flammableGasTypeConcentrationUnits")
	private  ArrayList<String>  flammableGasTypeConcentrationUnits;
	
	
	//getters & setters

	public Long getFlammableGasDataID() {
		return flammableGasDataID;
	}

	public void setFlammableGasDataID(Long flammableGasDataID) {
		this.flammableGasDataID = flammableGasDataID;
	}

	public ArrayList<String> getFlammableGasType() {
		return flammableGasType;
	}

	public void setFlammableGasType(ArrayList<String> flammableGasType) {
		this.flammableGasType = flammableGasType;
	}

	public ArrayList<String> getFlammableGasTypeConcentration() {
		return flammableGasTypeConcentration;
	}

	public void setFlammableGasTypeConcentration(ArrayList<String> flammableGasTypeConcentration) {
		this.flammableGasTypeConcentration = flammableGasTypeConcentration;
	}

	public ArrayList<String> getFlammableGasTypeConcentrationUnits() {
		return flammableGasTypeConcentrationUnits;
	}

	public void setFlammableGasTypeConcentrationUnits(ArrayList<String> flammableGasTypeConcentrationUnits) {
		this.flammableGasTypeConcentrationUnits = flammableGasTypeConcentrationUnits;
	}

	
}
