package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class UnmanagedEquipment {

	@Id
	@Column (name = "equipmentTagID")
	private Long equipmentTagID;
	
	@Column (name = "equipmentOwner")
	private String equipmentOwner;
	
	@Column (name = "manufacturer")
	private String manufacturer;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "geographicLocation_ID")
	private GeographicLocation currentlyLocatedAt;
	
	//private ActivePersonnel assignedTo;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "corporateEntityID")
	private CorporateEntity belongsTo;
	
	@Column (name = "isActive")
	private boolean isActive;
	
	
	//getters and setters

	public Long getEquipmentTagID() {
		return equipmentTagID;
	}

	public void setEquipmentTagID(Long equipmentTagID) {
		this.equipmentTagID = equipmentTagID;
	}

	public String getEquipmentOwner() {
		return equipmentOwner;
	}

	public void setEquipmentOwner(String equipmentOwner) {
		this.equipmentOwner = equipmentOwner;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public GeographicLocation getCurrentlyLocatedAt() {
		return currentlyLocatedAt;
	}

	public void setCurrentlyLocatedAt(GeographicLocation currentlyLocatedAt) {
		this.currentlyLocatedAt = currentlyLocatedAt;
	}

	public CorporateEntity getBelongsTo() {
		return belongsTo;
	}

	public void setBelongsTo(CorporateEntity belongsTo) {
		this.belongsTo = belongsTo;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	

}
