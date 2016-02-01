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

@Entity
public class Refinery {
	
	@Id
	@Column (name = "refineryID")
	private Long refineryID;
	
	@Column (name = "name")
	private String name;
	
	//@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "corporateEntityID")
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "corporateEntityID")
	private CorporateEntity belongsTo;
	
	//@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "geographicLocationID")
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "geographicLocation_ID")
	private GeographicLocation isLocatedAt;
	
	private ArrayList<String> mainHazardsPresent;
	
	@OneToMany (fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn (name = "refineryID") 
	private List<PlantArea> plantAreas;
	
	@OneToMany (fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn (name = "refineryID")
	private List<PrimaryOperatingUnit> primaryOperatingUnits;
	
	@OneToMany (fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn (name = "refineryID")
	private List<SecondaryOperatingUnit> secondaryOperatingUnits;

	
	//getters and setters
	
	public Long getRefineryID() {
		return refineryID;
	}

	public void setRefineryID(Long refineryID) {
		this.refineryID = refineryID;
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

	public GeographicLocation getIsLocatedAt() {
		return isLocatedAt;
	}

	public void setIsLocatedAt(GeographicLocation isLocatedAt) {
		this.isLocatedAt = isLocatedAt;
	}

	public ArrayList<String> getMainHazardsPresent() {
		return mainHazardsPresent;
	}

	public void setMainHazardsPresent(ArrayList<String> mainHazardsPresent) {
		this.mainHazardsPresent = mainHazardsPresent;
	}

	public List<PlantArea> getPlantAreas() {
		return plantAreas;
	}

	public void setPlantAreas(List<PlantArea> plantAreas) {
		this.plantAreas = plantAreas;
	}

	public List<PrimaryOperatingUnit> getPrimaryOperatingUnits() {
		return primaryOperatingUnits;
	}

	public void setPrimaryOperatingUnits(List<PrimaryOperatingUnit> primaryOperatingUnits) {
		this.primaryOperatingUnits = primaryOperatingUnits;
	}

	public List<SecondaryOperatingUnit> getSecondaryOperatingUnits() {
		return secondaryOperatingUnits;
	}

	public void setSecondaryOperatingUnits(List<SecondaryOperatingUnit> secondaryOperatingUnits) {
		this.secondaryOperatingUnits = secondaryOperatingUnits;
	}

	



}
