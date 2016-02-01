package firstResponderModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Wristband extends WearableDevice  {
	

	
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "heartRateDataID")
	private HeartRateData heartRateSensorInWristband; 
	
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "accelerometerDataID")
	private AccelerometerData accelerometerInWristband;
	
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "proximitySensorID")
	private ProximitySensor proximitySensorInWristband;
	
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "screenID")
	private Screen wristbandDisplayScreen;
	
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "ledNotificationLightsID")
	private LEDNotificationLights wristbandLEDNotificationLights;
	
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "speakerID")
	private Speaker wristbandSpeaker;
	
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "vibrationGeneratorID")
	private VibrationGenerator wristbandVibrationGenerator;
	
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "processorID")
	private Processor processorInWristband;
	
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "batteryID")
	private Battery batteryInWristband;

	
	// g & s


	public HeartRateData getHeartRateSensorInWristband() {
		return heartRateSensorInWristband;
	}

	public void setHeartRateSensorInWristband(HeartRateData heartRateSensorInWristband) {
		this.heartRateSensorInWristband = heartRateSensorInWristband;
	}

	public AccelerometerData getAccelerometerInWristband() {
		return accelerometerInWristband;
	}

	public void setAccelerometerInWristband(AccelerometerData accelerometerInWristband) {
		this.accelerometerInWristband = accelerometerInWristband;
	}

	public ProximitySensor getProximitySensorInWristband() {
		return proximitySensorInWristband;
	}

	public void setProximitySensorInWristband(ProximitySensor proximitySensorInWristband) {
		this.proximitySensorInWristband = proximitySensorInWristband;
	}

	public Screen getWristbandDisplayScreen() {
		return wristbandDisplayScreen;
	}

	public void setWristbandDisplayScreen(Screen wristbandDisplayScreen) {
		this.wristbandDisplayScreen = wristbandDisplayScreen;
	}

	public LEDNotificationLights getWristbandLEDNotificationLights() {
		return wristbandLEDNotificationLights;
	}

	public void setWristbandLEDNotificationLights(LEDNotificationLights wristbandLEDNotificationLights) {
		this.wristbandLEDNotificationLights = wristbandLEDNotificationLights;
	}

	public Speaker getWristbandSpeaker() {
		return wristbandSpeaker;
	}

	public void setWristbandSpeaker(Speaker wristbandSpeaker) {
		this.wristbandSpeaker = wristbandSpeaker;
	}

	public VibrationGenerator getWristbandVibrationGenerator() {
		return wristbandVibrationGenerator;
	}

	public void setWristbandVibrationGenerator(VibrationGenerator wristbandVibrationGenerator) {
		this.wristbandVibrationGenerator = wristbandVibrationGenerator;
	}

	public Processor getProcessorInWristband() {
		return processorInWristband;
	}

	public void setProcessorInWristband(Processor processorInWristband) {
		this.processorInWristband = processorInWristband;
	}

	public Battery getBatteryInWristband() {
		return batteryInWristband;
	}

	public void setBatteryInWristband(Battery batteryInWristband) {
		this.batteryInWristband = batteryInWristband;
	}
	
	
	
	
	

}
