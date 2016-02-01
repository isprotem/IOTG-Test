package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Speaker {

	@Id
	@Column (name = "speakerID")
	private Long speakerID;

	
	// g & s
	
	public Long getSpeakerID() {
		return speakerID;
	}

	public void setSpeakerID(Long speakerID) {
		this.speakerID = speakerID;
	}

	
	
}
