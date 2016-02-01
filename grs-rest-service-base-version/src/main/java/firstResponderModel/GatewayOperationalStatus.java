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
//@Table (name = "gatewayoperationalstatus", schema = "firstrespondermodel@cassandra_pu")
public class GatewayOperationalStatus extends DeviceOperationalStatus {
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "gatewayOperationalStatusID")
	private Long gatewayOperationalStatusID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gatewayID")
	public Gateway operationalStatusFor;
	
	// yet to provide mapping
	//public PowerState powerState;

	
	
	//getters & setters
	

	public Gateway getOperationalStatusFor() {
		return operationalStatusFor;
	}

	public void setOperationalStatusFor(Gateway operationalStatusFor) {
		this.operationalStatusFor = operationalStatusFor;
	}

	/*public PowerState getPowerState() {
		return powerState;
	}

	public void setPowerState(PowerState powerState) {
		this.powerState = powerState;
	}*/

		
	public Long getGatewayOperationalStatusID() {
		return gatewayOperationalStatusID;
	}

	public void setGatewayOperationalStatusID(Long gatewayOperationalStatusID) {
		this.gatewayOperationalStatusID = gatewayOperationalStatusID;
	}
	
	

}
