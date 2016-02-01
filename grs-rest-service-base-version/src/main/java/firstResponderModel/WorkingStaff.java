package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkingStaff extends ActivePersonnel {
	
	@Id
	@Column (name = "workingStaffID")
	private Long workingStaffID;

	public Long getWorkingStaffID() {
		return workingStaffID;
	}

	public void setWorkingStaffID(Long workingStaffID) {
		this.workingStaffID = workingStaffID;
	}
	


}
