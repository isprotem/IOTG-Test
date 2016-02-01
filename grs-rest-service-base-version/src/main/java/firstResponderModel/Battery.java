package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Battery {
	
	@Id
	@Column (name = "batteryID")
	private Long batteryID;
	
	@Column (name = "batteryModel")
	private String batteryModel;
	
	@Column (name = "batteryManufacturer")
	private String batteryManufacturer;
	
	@Column (name = "batteryTimeRemainingSeconds")
	private int batteryTimeRemainingSeconds;
	
	@Column (name = "batteryRemainingPercentage")
	private int batteryRemainingPercentage;

	
	
	//getters & setters
	
	public Long getBatteryID() {
		return batteryID;
	}

	public void setBatteryID(Long batteryID) {
		this.batteryID = batteryID;
	}

	public String getBatteryModel() {
		return batteryModel;
	}

	public void setBatteryModel(String batteryModel) {
		this.batteryModel = batteryModel;
	}

	public String getBatteryManufacturer() {
		return batteryManufacturer;
	}

	public void setBatteryManufacturer(String batteryManufacturer) {
		this.batteryManufacturer = batteryManufacturer;
	}

	public int getBatteryTimeRemainingSeconds() {
		return batteryTimeRemainingSeconds;
	}

	public void setBatteryTimeRemainingSeconds(int batteryTimeRemainingSeconds) {
		this.batteryTimeRemainingSeconds = batteryTimeRemainingSeconds;
	}

	public int getBatteryRemainingPercentage() {
		return batteryRemainingPercentage;
	}

	public void setBatteryRemainingPercentage(int batteryRemainingPercentage) {
		this.batteryRemainingPercentage = batteryRemainingPercentage;
	}

	
	
	
}
