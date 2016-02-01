/*package firstResponderModel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@Table (name = "sensormoduleoperationalstatus", schema = "firstrespondermodel@cassandra_pu")
public class SensorOperationalStatus extends DeviceOperationalStatus {
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name="sensorOperationalStatusID")
	private Long sensorOperationalStatusID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sensorID")
	public Sensor operationalStatusFor;

	
	
	//getters & setters
	

	public Long getSensorOperationalStatusID() {
		return sensorOperationalStatusID;
	}

	public void setSensorOperationalStatusID(Long sensorOperationalStatusID) {
		this.sensorOperationalStatusID = sensorOperationalStatusID;
	}

	public Sensor getOperationalStatusFor() {
		return operationalStatusFor;
	}

	public void setOperationalStatusFor(Sensor operationalStatusFor) {
		this.operationalStatusFor = operationalStatusFor;
	}
	

} 
*/