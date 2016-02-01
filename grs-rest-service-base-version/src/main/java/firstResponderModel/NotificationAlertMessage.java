package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class NotificationAlertMessage {

	@Id
	@Column (name = "alertID")
	private Long alertID;
	
	//@Column (name = "alertSeverity")
   // private AlertSeverity alertSeverity;
    
	@Column (name = "timestamp")
    private int timestamp;
    
	@Column (name = "description")
    private String description;
    
	@Column (name = "acknowledged")
    private boolean acknowledged;
    
	@Column (name = "notificationSent")
    private boolean notificationSent;
    
/*    private ActivePersonnel acknowledgedBy;
    
    private ActivePersonnel notificationSentBy;
    
    private ActivePersonnel notificationSentTo;
    
    private Device alertForManagedDevice;    */
    
	@OneToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "equipmentTagID")
    private UnmanagedEquipment alertForUnmanagedEquipment;
    
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "incidentID")
    private Incident alertForIncident;

	
	
	//getters and setters
	
	public Long getAlertID() {
		return alertID;
	}

	public void setAlertID(Long alertID) {
		this.alertID = alertID;
	}

	/*public AlertSeverity getAlertSeverity() {
		return alertSeverity;
	}

	public void setAlertSeverity(AlertSeverity alertSeverity) {
		this.alertSeverity = alertSeverity;
	}*/

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAcknowledged() {
		return acknowledged;
	}

	public void setAcknowledged(boolean acknowledged) {
		this.acknowledged = acknowledged;
	}

	public boolean isNotificationSent() {
		return notificationSent;
	}

	public void setNotificationSent(boolean notificationSent) {
		this.notificationSent = notificationSent;
	}

	public UnmanagedEquipment getAlertForUnmanagedEquipment() {
		return alertForUnmanagedEquipment;
	}

	public void setAlertForUnmanagedEquipment(UnmanagedEquipment alertForUnmanagedEquipment) {
		this.alertForUnmanagedEquipment = alertForUnmanagedEquipment;
	}

	public Incident getAlertForIncident() {
		return alertForIncident;
	}

	public void setAlertForIncident(Incident alertForIncident) {
		this.alertForIncident = alertForIncident;
	}
    
	
	
	
}
