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

import firstResponderModel.*;

@Entity
public class CorporateEntity  {
	
	@Id
	@Column (name = "corparateEntityID")
	private Long corporateEntityID;
	
	@Column (name = "corporationName")
	private String corporationName;
	
	@Column (name = "corporationTaxID")
	private String corporationTaxID;
	
	@Column (name = "isActive")
	private boolean isActive;
	
	@OneToMany (fetch = FetchType.EAGER /*, cascade = CascadeType.ALL*/)
	@JoinColumn (name = "corparateEntityID")
	private List<GeographicLocation> companyLocations;
	
	
	// getters & setters

	public Long getCorporateEntityID() {
		return corporateEntityID;
	}

	public void setCorporateEntityID(Long corporateEntityID) {
		this.corporateEntityID = corporateEntityID;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}

	public String getCorporationTaxID() {
		return corporationTaxID;
	}

	public void setCorporationTaxID(String corporationTaxID) {
		this.corporationTaxID = corporationTaxID;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<GeographicLocation> getCompanyLocations() {
		return companyLocations;
	}

	public void setCompanyLocations(List<GeographicLocation> companyLocations) {
		this.companyLocations = companyLocations;
	}

	
}
