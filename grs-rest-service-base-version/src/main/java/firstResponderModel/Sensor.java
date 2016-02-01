package firstResponderModel;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/*@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)*/
@MappedSuperclass
public abstract class Sensor extends Device{

	@Column(name="timeStampOfMeasurement")
	public Date timeStampOfMeasurement;

	@ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	@JoinColumn(name = "sensorModuleID")
	//@Column(name="parentSensorModule")
	public SensorModule parentSensorModule;
	
	/*@OneToMany (mappedBy = "sensorID")
	//@Column(name="sensorOperationalStatus")
	public ArrayList<SensorOperationalStatus> sensorOperationalStatus;*/

	
	
	

	//getters and setters
	
	
	public Date getTimeStampOfMeasurement() {
		return timeStampOfMeasurement;
	}

	public void setTimeStampOfMeasurement(Date timeStampOfMeasurement) {
		this.timeStampOfMeasurement = timeStampOfMeasurement;
	}
	
	
	
	public SensorModule getParentSensorModule() {
		return parentSensorModule;
	}

	public void setParentSensorModule(SensorModule parentSensorModule) {
		this.parentSensorModule = parentSensorModule;
	}


	/*public ArrayList<SensorOperationalStatus> getSensorOperationalStatus() {
		return sensorOperationalStatus;
	}

	public void setSensorOperationalStatus(ArrayList<SensorOperationalStatus> sensorOperationalStatus) {
		this.sensorOperationalStatus = sensorOperationalStatus;
	}
*/
	
	
}


