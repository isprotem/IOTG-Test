/**
 * 
 */
package com.intel.grs.first.responder.ui.model;

import java.io.Serializable;

/**
 * @author yschauhx
 *
 */
public class IncidentModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2749830815491876977L;
	/**
	 * 
	 */
	public IncidentModel() {
		// TODO Auto-generated constructor stub
	}

	private String startTime;
	private String endTime;
	private String incidentDate;
	private String incidentType;
	private String incidentCommander;
	public IncidentModel(String startTime, String endTime, String incidentDate, String incidentType,
			String incidentCommander) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.incidentDate = incidentDate;
		this.incidentType = incidentType;
		this.incidentCommander = incidentCommander;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getIncidentDate() {
		return incidentDate;
	}
	public void setIncidentDate(String incidentDate) {
		this.incidentDate = incidentDate;
	}
	public String getIncidentType() {
		return incidentType;
	}
	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}
	public String getIncidentCommander() {
		return incidentCommander;
	}
	public void setIncidentCommander(String incidentCommander) {
		this.incidentCommander = incidentCommander;
	}
	
	
	
}
