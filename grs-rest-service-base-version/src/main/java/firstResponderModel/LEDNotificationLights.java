package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class LEDNotificationLights {

	@Id
	@Column (name = "ledNotificationLightsID")
	private Long ledNotificationLightsID;

	//g & s
	
	public Long getLedNotificationLightsID() {
		return ledNotificationLightsID;
	}

	public void setLedNotificationLightsID(Long ledNotificationLightsID) {
		this.ledNotificationLightsID = ledNotificationLightsID;
	}
	
	
	
}
