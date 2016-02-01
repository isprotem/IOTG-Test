package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProximitySensor extends Sensor{

	@Id
	@Column (name = "proximitySensorID")
	private Long proximitySensorID;
	
	@Column (name = "proximityTrueFalse")
	private boolean proximityTrueFalse;
	
	//getters and setters

	public Long getProximitySensorID() {
		return proximitySensorID;
	}

	public void setProximitySensorID(Long proximitySensorID) {
		this.proximitySensorID = proximitySensorID;
	}

	public boolean isProximityTrueFalse() {
		return proximityTrueFalse;
	}

	public void setProximityTrueFalse(boolean proximityTrueFalse) {
		this.proximityTrueFalse = proximityTrueFalse;
	}
	
	
	
	
	
}
