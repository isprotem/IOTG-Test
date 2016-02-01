package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlantArea {
	
	@Id
	@Column (name = "plantAreaID")
	private Long plantAreaID;

	
	//getters & setters
	
	public Long getPlantAreaID() {
		return plantAreaID;
	}

	public void setPlantAreaID(Long plantAreaID) {
		this.plantAreaID = plantAreaID;
	}

}
