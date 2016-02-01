package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

@MappedSuperclass
public abstract class OperationalStatus {
	
	
	
	@Column (name = "timeStamp")
	private int timeStamp;
	
	

	//getters & setters

	public int getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
