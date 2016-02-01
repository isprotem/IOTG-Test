package firstResponderModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
//@Table (name = "gateway", schema = "firstrespondermodel@cassandra_pu")
public class Gateway extends Device {
	
	@Id
	@Column (name = "gatewayID")
	private Long gatewayID;


/*   @OneToMany(fetch = FetchType.EAGER, mappedBy = "operationalStatusFor" )
   public List<GatewayOperationalStatus> gatewayOperationalStatus;
   */
	
	
	//private String powerSupply;
	
	
	
	
	//getters & setters
	
	/*
	public String getPowerSupply() {
		return powerSupply;
	}

	public void setPowerSupply(String powerSupply) {
		this.powerSupply = powerSupply;
	}*/


	public Long getGatewayID() {
		return gatewayID;
	}

	public void setGatewayID(Long gatewayID) {
		this.gatewayID = gatewayID;
	}

/*	public List<GatewayOperationalStatus> getGatewayOperationalStatus() {
		return gatewayOperationalStatus;
	}

	public void setGatewayOperationalStatus(List<GatewayOperationalStatus> gatewayOperationalStatus) {
		this.gatewayOperationalStatus = gatewayOperationalStatus;
	}

	*/


	

}
