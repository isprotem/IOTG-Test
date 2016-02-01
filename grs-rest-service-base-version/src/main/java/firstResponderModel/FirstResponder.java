package firstResponderModel;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity

public class FirstResponder extends ActivePersonnel{
	
	@Id
	@Column (name = "firstResponderID")
	private Long firstResponderID;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	private GeographicLocation glocation;

	
	//@OneToMany (mappedBy = "wornBy")
	/*@Column (name = "sensorGroupWorn")
	public ArrayList<SensorModule> sensorGroupWorn; 
*/
/*	@Column (name = "biometricInfo")
	public ArrayList<BiometricSensorData> biometricInfo;

	//@OneToOne (mappedBy = "wornBy")
	@Column (name = "gatewayWorn")
	public FirstResponderBodySuitGateway gatewayWorn;
*/
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "incidentID")
	private Incident respondsTo;
	
	
	

	public Long getFirstResponderID() {
		return firstResponderID;
	}

	public void setFirstResponderID(Long firstResponderID) {
		this.firstResponderID = firstResponderID;
	}

	public GeographicLocation getGlocation() {
		return glocation;
	}

	public void setGlocation(GeographicLocation glocation) {
		this.glocation = glocation;
	}

	/*public ArrayList<SensorModule> getSensorGroupWorn() {
		return sensorGroupWorn;
	}

	public void setSensorGroupWorn(ArrayList<SensorModule> sensorGroupWorn) {
		this.sensorGroupWorn = sensorGroupWorn;
	}*/
/*
	public ArrayList<BiometricSensorData> getBiometricInfo() {
		return biometricInfo;
	}

	public void setBiometricInfo(ArrayList<BiometricSensorData> biometricInfo) {
		this.biometricInfo = biometricInfo;
	}

	public FirstResponderBodySuitGateway getGatewayWorn() {
		return gatewayWorn;
	}

	public void setGatewayWorn(FirstResponderBodySuitGateway gatewayWorn) {
		this.gatewayWorn = gatewayWorn;
	}
*/
	public Incident getRespondsTo() {
		return respondsTo;
	}

	public void setRespondsTo(Incident respondsTo) {
		this.respondsTo = respondsTo;
	}


	

	



	
	
	
	
	
}

