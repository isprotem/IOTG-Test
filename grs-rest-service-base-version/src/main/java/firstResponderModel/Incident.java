package firstResponderModel;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
//@Table(name = "incident",/*schema = "test",*/ schema = "firstrespondermodel@cassandra_pu")
public class Incident{
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column(name="incidentID")
	public Long incidentID;

	@Column(name="startTime")
	@JsonFormat(pattern = "MM/dd/yyyy HH:mm")
	public Date incidentStartTime;

	@Column(name="incidentCloseTime")
	@JsonFormat(pattern = "MM/dd/yyyy HH:mm")
	public Date incidentCloseTime;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "geographicLocation_ID")
	public GeographicLocation glocation;

	@Column (name="incidentCommander")
	public String incidentCommander;

	@Column (name="incidentClassification")
	public String incidentClassification;
	
	
	/*@Column(name="isServicedBy")
	public List<FirstResponder> isServicedBy;*/
	
//	public LocalSupportCEnterStaff incidentCommander;
	
	//@OneToMany (fetch = FetchType.EAGER)
	//@JoinColumn (name = "incidentID")
	/*@Column (name = "deploysMobileResponseVehicleGateway")
	public ArrayList<MobileResponseVehicleGateway> deploysMobileResponseVehicleGateway;*/

//	public ArrayList<NotificationAlertMessage>[] alertsForIncident;

	//public ArrayList<ActivePersonnel>[] supportStaff;

	
	
	
	//getters and setters
	
	public Long getIncidentID() {
		return incidentID;
	}


	public void setIncidentID(Long incidentID) {
		this.incidentID = incidentID;
	}


	public Date getIncidentStartTime() {
		return incidentStartTime;
	}


	public void setIncidentStartTime(Date incidentStartTime) {
		this.incidentStartTime = incidentStartTime;
	}


	public Date getIncidentCloseTime() {
		return incidentCloseTime;
	}


	public void setIncidentCloseTime(Date incidentCloseTime) {
		this.incidentCloseTime = incidentCloseTime;
	}


	public GeographicLocation getGlocation() {
		return glocation;
	}


	public void setGlocation(GeographicLocation glocation) {
		this.glocation = glocation;
	}




	public String getIncidentClassification() {
		return incidentClassification;
	}


	public void setIncidentClassification(String incidentClassification) {
		this.incidentClassification = incidentClassification;
	}


	public String getIncidentCommander() {
		return incidentCommander;
	}


	public void setIncidentCommander(String incidentCommander) {
		this.incidentCommander = incidentCommander;
	}


	

	/*public List<FirstResponder> getIsServicedBy() {
		return isServicedBy;
	}


	public void setIsServicedBy(List<FirstResponder> isServicedBy) {
		this.isServicedBy = isServicedBy;
	}*/

/*
	public ArrayList<MobileResponseVehicleGateway> getDeploysMobileResponseVehicleGateway() {
		return deploysMobileResponseVehicleGateway;
	}


	public void setDeploysMobileResponseVehicleGateway(
			ArrayList<MobileResponseVehicleGateway> deploysMobileResponseVehicleGateway) {
		this.deploysMobileResponseVehicleGateway = deploysMobileResponseVehicleGateway;
	}*/


	


	
}

