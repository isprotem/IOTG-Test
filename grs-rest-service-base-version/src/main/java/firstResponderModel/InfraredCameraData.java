package firstResponderModel;

import java.net.URL;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;



@Entity
//@Table(name = "infraredcameradata", schema = "firstrespondermodel@cassandra_pu")
public class InfraredCameraData extends EnvironmentSensorData {
	
	@Id
	//@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")
	@Column (name = "infraredCameraDataID")
	private Long infraredCameraDataID;
	
	@Column (name = "imageDataLink")
	private URL imageDataLink;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "geographicLocation_ID")
	//@Column(name="locationOfDevice")
	public GeographicLocation locationOfDevice;
	
	//getters & setters

	public Long getInfraredCameraDataID() {
		return infraredCameraDataID;
	}

	public void setInfraredCameraDataID(Long infraredCameraDataID) {
		this.infraredCameraDataID = infraredCameraDataID;
	}

	public URL getImageDataLink() {
		return imageDataLink;
	}

	public void setImageDataLink(URL imageDataLink) {
		this.imageDataLink = imageDataLink;
	}

	public GeographicLocation getLocationOfDevice() {
		return locationOfDevice;
	}

	public void setLocationOfDevice(GeographicLocation locationOfDevice) {
		this.locationOfDevice = locationOfDevice;
	}
	
	
	
	
}
