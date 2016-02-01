package firstResponderModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Hospital {

	@Id
	@Column (name = "hospitalID")
	private Long hospitalID;
	
	@Column (name = "name")
	private String name;
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "corporateEntityID")
	private CorporateEntity isOwnedBy;
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "geographicLocation_ID")
	private GeographicLocation isLocatedAt;

	
	//getters & setters
	
	public Long getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(Long hospitalID) {
		this.hospitalID = hospitalID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CorporateEntity getIsOwnedBy() {
		return isOwnedBy;
	}

	public void setIsOwnedBy(CorporateEntity isOwnedBy) {
		this.isOwnedBy = isOwnedBy;
	}

	public GeographicLocation getIsLocatedAt() {
		return isLocatedAt;
	}

	public void setIsLocatedAt(GeographicLocation isLocatedAt) {
		this.isLocatedAt = isLocatedAt;
	}
	
	
	
}
