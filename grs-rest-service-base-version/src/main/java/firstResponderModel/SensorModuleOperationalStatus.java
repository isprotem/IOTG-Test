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

import firstResponderModel.DeviceOperationalStatus;
import firstResponderModel.SensorModule;

@Entity
//@Table (name = "sensormoduleoperationalstatus", schema = "firstrespondermodel@cassandra_pu")
public class SensorModuleOperationalStatus extends DeviceOperationalStatus {
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name="sensorModuleOperationalStatusID")
	private Long sensorModuleOperationalStatusID;
	
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name = "sensorModuleID")
	public SensorModule operationalStatusFor;
	
	
	//getters & setters

	public Long getSensorModuleOperationalStatusID() {
		return sensorModuleOperationalStatusID;
	}

	public void setSensorModuleOperationalStatusID(Long sensorModuleOperationalStatusID) {
		this.sensorModuleOperationalStatusID = sensorModuleOperationalStatusID;
	}

	public SensorModule getOperationalStatusFor() {
		return operationalStatusFor;
	}

	public void setOperationalStatusFor(SensorModule operationalStatusFor) {
		this.operationalStatusFor = operationalStatusFor;
	}
	
	
	

}
