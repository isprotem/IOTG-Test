/**
 * 
 */
package com.intel.grs.first.responder.ui.model;

import java.io.Serializable;

/**
 * @author yschauhx
 *
 */
public class LifeCycleManagementModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4067993716439801990L;

	/**
	 * 
	 */
	public LifeCycleManagementModel() {
		// TODO Auto-generated constructor stub
	}

	private IncidentModel incident;
	
	private LocationModel location;

	public IncidentModel getIncident() {
		return incident;
	}

	public void setIncident(IncidentModel incident) {
		this.incident = incident;
	}

	public LocationModel getLocation() {
		return location;
	}

	public void setLocation(LocationModel location) {
		this.location = location;
	}
	
	
	
}
