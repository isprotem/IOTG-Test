package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PrimaryOperatingUnit {
	
	@Id
	@Column (name = "primaryOperatingUnitID")
	private Long primaryOperatingUnitID;

	//getters & setters
	
	public Long getPrimaryOperatingUnitID() {
		return primaryOperatingUnitID;
	}

	public void setPrimaryOperatingUnitID(Long primaryOperatingUnitID) {
		this.primaryOperatingUnitID = primaryOperatingUnitID;
	}

}
