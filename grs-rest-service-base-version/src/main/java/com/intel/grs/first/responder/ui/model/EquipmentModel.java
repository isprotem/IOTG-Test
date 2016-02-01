/**
 * 
 */
package com.intel.grs.first.responder.ui.model;

import java.io.Serializable;

/**
 * @author yschauhx
 *
 */
public class EquipmentModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7226723531765124773L;
	
	private Long id;
	private String name;
	private String type;
	private String model;
	private String lastDeployedDate;
	private String status;
	
	public EquipmentModel() {
		super();
	}
	
	public EquipmentModel(Long id, String name, String type, String model, String lastDeployedDate, String status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.model = model;
		this.lastDeployedDate = lastDeployedDate;
		this.status = status;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLastDeployedDate() {
		return lastDeployedDate;
	}

	public void setLastDeployedDate(String lastDeployedDate) {
		this.lastDeployedDate = lastDeployedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
