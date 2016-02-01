package firstResponderModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class FireDepartment {
	@Id
	@Column (name = "fireDepartmentID")
	private Long fireDepartmentID;
	
	@Column (name = "name")
	private String name;
	
	//@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "corporateEntityID")		
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@PrimaryKeyJoinColumn
	@JoinColumn (name = "corporateEntityID")
	private CorporateEntity belongsTo;
	
	@OneToMany (fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn (name = "fireDepartmentID") 
	private List<FireStation> manages;
	
	
 
	
	//private ActivePersonnel fireDepartmentChief;
	
	
	//getters & setters

	public Long getFireDepartmentID() {
		return fireDepartmentID;
	}

	public void setFireDepartmentID(Long fireDepartmentID) {
		this.fireDepartmentID = fireDepartmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CorporateEntity getBelongsTo() {
		return belongsTo;
	}

	public void setBelongsTo(CorporateEntity belongsTo) {
		this.belongsTo = belongsTo;
	}




	public List<FireStation> getManages() {
		return manages;
	}

	public void setManages(List<FireStation> manages) {
		this.manages = manages;
	}


	
	
}
