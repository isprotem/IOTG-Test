package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MobileResponseVehicle extends UnmanagedEquipment{
	
	@Column (name = "vehicleVIN")
	private String vehicleVIN;
	
	@Column (name = "vehicleLicense")
	private String vehicleLicense;
	
	@Column (name = "stateLicensedIn")
	private String stateLicensedIn;

	//getters and setters
	
	public String getVehicleVIN() {
		return vehicleVIN;
	}

	public void setVehicleVIN(String vehicleVIN) {
		this.vehicleVIN = vehicleVIN;
	}

	public String getVehicleLicense() {
		return vehicleLicense;
	}

	public void setVehicleLicense(String vehicleLicense) {
		this.vehicleLicense = vehicleLicense;
	}

	public String getStateLicensedIn() {
		return stateLicensedIn;
	}

	public void setStateLicensedIn(String stateLicensedIn) {
		this.stateLicensedIn = stateLicensedIn;
	}
	
	

}
