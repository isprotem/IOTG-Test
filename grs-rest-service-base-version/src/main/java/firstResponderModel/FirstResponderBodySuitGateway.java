
package firstResponderModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import firstResponderModel.FirstResponder;
import firstResponderModel.Gateway;

@Entity
public class FirstResponderBodySuitGateway extends Gateway {
	
	
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "firstResponderID")
	public FirstResponder wornBy;
	
	//@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "batteryID")
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "batteryID")
	private Battery containedBattery;
	
	
	
	//getters & setters


	public FirstResponder getWornBy() {
		return wornBy;
	}

	public void setWornBy(FirstResponder wornBy) {
		this.wornBy = wornBy;
	}

	public Battery getContainedBattery() {
		return containedBattery;
	}

	public void setContainedBattery(Battery containedBattery) {
		this.containedBattery = containedBattery;
	}

}
