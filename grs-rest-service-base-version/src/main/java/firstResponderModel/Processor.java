package firstResponderModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Processor {
	
	@Id
	@Column (name = "processorID")
	private Long processorID;
	
	@Column (name = "processorBrand")
	private String processorBrand;
	
	@Column (name = "processorName")
	private String processorName;
	
	@Column (name = "processorModel")
	private String processorModel;

	
	// g & s
	
	public Long getProcessorID() {
		return processorID;
	}

	public void setProcessorID(Long processorID) {
		this.processorID = processorID;
	}

	public String getProcessorBrand() {
		return processorBrand;
	}

	public void setProcessorBrand(String processorBrand) {
		this.processorBrand = processorBrand;
	}

	public String getProcessorName() {
		return processorName;
	}

	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}

	public String getProcessorModel() {
		return processorModel;
	}

	public void setProcessorModel(String processorModel) {
		this.processorModel = processorModel;
	}
	
	

}
