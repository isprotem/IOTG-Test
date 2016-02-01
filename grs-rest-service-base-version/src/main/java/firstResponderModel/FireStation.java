package firstResponderModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class FireStation {
	
	@Id
	@Column (name = "fireStationID")
	private Long fireStationID;
	
	@Column (name = "name")
	private String name;
	
	
	
	//private ActivePersonnel fireStationChief;

	
	//getters & setters
	
		
	public Long getFireStationID() {
		return fireStationID;
	}

	public void setFireStationID(Long fireStationID) {
		this.fireStationID = fireStationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
	
	

}
