package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
 * 
 * @ Author acratchx
 * 
 */

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class NetworkInterface {

	@Id
	@Column (name = "networkInterfaceID")
	private Long networkInterfaceID;
	
	@Column (name = "interfaceName")
	private String interfaceName;

	
	
	// g & s
	
	public Long getNetworkInterfaceID() {
		return networkInterfaceID;
	}

	public void setNetworkInterfaceID(Long networkInterfaceID) {
		this.networkInterfaceID = networkInterfaceID;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	
	
	
}
