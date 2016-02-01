package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//@MappedSuperclass

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class WearableDevice extends Device {
	
	@Id
	@Column (name = "wearableDeviceID")
	private Long wearableDeviceID;

	
	//g & s
	
	public Long getWearableDeviceID() {
		return wearableDeviceID;
	}

	public void setWearableDeviceID(Long wearableDeviceID) {
		this.wearableDeviceID = wearableDeviceID;
	}


}
