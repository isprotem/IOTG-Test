package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VibrationGenerator {

	@Id
	@Column (name = "vibrationGeneratorID")
	private Long vibrationGeneratorID;

	// g & s
	
	public Long getVibrationGeneratorID() {
		return vibrationGeneratorID;
	}

	public void setVibrationGeneratorID(Long vibrationGeneratorID) {
		this.vibrationGeneratorID = vibrationGeneratorID;
	}
	
	
}
