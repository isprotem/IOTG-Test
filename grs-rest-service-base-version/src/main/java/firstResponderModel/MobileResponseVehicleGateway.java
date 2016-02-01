package firstResponderModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MobileResponseVehicleGateway extends Gateway {
	
	
	
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "incidentID")
	private Incident isDeployedFor;

	
	
	//getters and setters
	
	public Incident getIsDeployedFor() {
		return isDeployedFor;
	}

	public void setIsDeployedFor(Incident isDeployedFor) {
		this.isDeployedFor = isDeployedFor;
	}
	


}

