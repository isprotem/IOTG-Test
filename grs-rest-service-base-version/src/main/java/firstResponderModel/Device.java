package firstResponderModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;


@MappedSuperclass

// use @Inheritence, if needed.
/*@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)*/
public abstract class Device{
	//@Id
	@Column(name="deviceID")
	public String deviceID;
	@Column(name="deviceName")
	public String deviceName;
	@Column(name="deviceVendor")
	public String deviceVendor;
	@Column(name="deviceModel")
	public String deviceModel;
	
	
	@Column(name="firmwareVersion")
	public String firmwareVersion;
	
	/*@OneToMany (fetch = FetchType.EAGER)
	@JoinColumn (name = "deviceID")
    public List<NetworkInterface> interfacesSupported = new ArrayList<NetworkInterface>();
	*/
	@Column (name = "isActive")
	public boolean isActive;
	
	//@Column(name="belongToNetwork")
	//public Network belongToNetwork;
	
	

	
	//getters and setters
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceVendor() {
		return deviceVendor;
	}
	public void setDeviceVendor(String deviceVendor) {
		this.deviceVendor = deviceVendor;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}
	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}


