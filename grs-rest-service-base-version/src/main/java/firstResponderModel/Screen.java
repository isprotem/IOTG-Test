package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Screen {

	@Id
	@Column (name = "screenID")
	private Long screenID;

	
	//g & s
	
	public Long getScreenID() {
		return screenID;
	}

	public void setScreenID(Long screenID) {
		this.screenID = screenID;
	}
	
	
}
