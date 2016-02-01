/**
 * 
 */
package com.intel.grs.first.responder.ui.model;

import java.io.Serializable;

/**
 * @author yschauhx
 *
 */
public class FirstResponderModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4758820991374508836L;
	
	private Long id;
	private String name;
	private Integer age;
	private String gender;
	private String position;
	private String type;
	private String fireDepartment;
	private String status;
	
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFireDepartment() {
		return fireDepartment;
	}
	public void setFireDepartment(String fireDepartment) {
		this.fireDepartment = fireDepartment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
