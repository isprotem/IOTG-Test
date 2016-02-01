package firstResponderModel;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import firstResponderModel.FirstResponder;
import firstResponderModel.Sensor;

@MappedSuperclass
public abstract class BiometricSensorData extends Sensor {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "firstResponderID")
	public FirstResponder biometricDataFor;


	public FirstResponder getBiometricDataFor() {
		return biometricDataFor;
	}

	public void setBiometricDataFor(FirstResponder biometricDataFor) {
		this.biometricDataFor = biometricDataFor;
	}
	
	
	
}
