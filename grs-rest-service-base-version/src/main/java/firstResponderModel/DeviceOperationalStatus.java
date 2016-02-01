package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DeviceOperationalStatus extends OperationalStatus {

	@Column (name = "upTime")
	private int upTime;
	@Column (name = "dateLastServiced")
	private String dateLastServiced;
	@Column (name = "batteryStatus")
	private String batteryStatus;
	
	
	//getters & setters

	public int getUpTime() {
		return upTime;
	}

	public void setUpTime(int upTime) {
		this.upTime = upTime;
	}

	public String getDateLastServiced() {
		return dateLastServiced;
	}

	public void setDateLastServiced(String dateLastServiced) {
		this.dateLastServiced = dateLastServiced;
	}

	public String getBatteryStatus() {
		return batteryStatus;
	}

	public void setBatteryStatus(String batteryStatus) {
		this.batteryStatus = batteryStatus;
	}
	
	
	
}
