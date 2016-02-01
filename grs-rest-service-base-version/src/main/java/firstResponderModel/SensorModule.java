
package firstResponderModel;


import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



//import after_12_04_meet.SensorModuleOperationalStatus;


@Entity
//@Table(name = "sensormodule", schema = "firstrespondermodel@cassandra_pu")
public class SensorModule extends Device{
	

	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column(name="sensorModuleID")
	private Long sensorModuleID;
	
	
	@Column(name="numberofSensors")
	public int numberofSensors;
	
	/*//@OneToMany //can't issue post on the abstract class as we can't instantiate abstract class. same problem with references from other classes refering to sensors.
    @Column(name="associatedSensors")
	public ArrayList<Sensor> associatedSensors;
	*/
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "firstResponderID")
	//@Column(name="wornBy")
	public FirstResponder wornBy;
	
	
	
	@Column(name="mcuType")
	public String mcuType;
	@Column(name="mcuModel")
	public String mcuModel;
	@Column(name="mcuName")
	public String mcuName;
	@Column(name="mcuID")
	public String mcuID;
	
	/*//@OneToMany (mappedBy = "operationalStatusFor") 
	@Column(name="sensorModuleOperationalStatus")
	public ArrayList<SensorModuleOperationalStatus> sensorModuleOperationalStatus;
*/
	
	
	
	//getters and setters
	
	public Long getSensorModuleID() {
		return sensorModuleID;
	}
	public void setSensorModuleID(Long sensorModuleID) {
		this.sensorModuleID = sensorModuleID;
	}
	public int getNumberofSensors() {
		return numberofSensors;
	}
	public void setNumberofSensors(int numberofSensors) {
		this.numberofSensors = numberofSensors;
	}
	public FirstResponder getWornBy() {
		return wornBy;
	}
	public void setWornBy(FirstResponder wornBy) {
		this.wornBy = wornBy;
	}
	public String getMcuType() {
		return mcuType;
	}
	public void setMcuType(String mcuType) {
		this.mcuType = mcuType;
	}
	public String getMcuModel() {
		return mcuModel;
	}
	public void setMcuModel(String mcuModel) {
		this.mcuModel = mcuModel;
	}
	public String getMcuName() {
		return mcuName;
	}
	public void setMcuName(String mcuName) {
		this.mcuName = mcuName;
	}
	public String getMcuID() {
		return mcuID;
	}
	public void setMcuID(String mcuID) {
		this.mcuID = mcuID;
	}

	/*public ArrayList<Sensor> getAssociatedSensors() {
		return associatedSensors;
	}
	public void setAssociatedSensors(ArrayList<Sensor> associatedSensors) {
		this.associatedSensors = associatedSensors;
	}*/
	/*public ArrayList<SensorModuleOperationalStatus> getSensorModuleOperationalStatus() {
		return sensorModuleOperationalStatus;
	}
	public void setSensorModuleOperationalStatus(ArrayList<SensorModuleOperationalStatus> sensorModuleOperationalStatus) {
		this.sensorModuleOperationalStatus = sensorModuleOperationalStatus;
	}*/

}


