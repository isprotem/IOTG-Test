package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SecondaryOperatingUnit {

	@Id
	@Column (name = "secondaryOperatingUnitID")
	private Long secondaryOperatingUnitID;

	
	//getters & setters
	
	public Long getSecondaryOperatingUnitID() {
		return secondaryOperatingUnitID;
	}

	public void setSecondaryOperatingUnitID(Long secondaryOperatingUnitID) {
		this.secondaryOperatingUnitID = secondaryOperatingUnitID;
	}
	

	
}
