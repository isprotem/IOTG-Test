package firstResponderModel;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.AnnotationMemberValue;
import javassist.bytecode.annotation.AnnotationsWriter;
import javassist.bytecode.annotation.ClassMemberValue;
import javassist.bytecode.annotation.EnumMemberValue;
import javassist.bytecode.annotation.IntegerMemberValue;
import javassist.bytecode.annotation.MemberValue;
import javassist.bytecode.annotation.StringMemberValue;
import javax.persistence.TableGenerator;


public class AddRunTimeAnnotation {
	 
								
	public static void addAnnotations(String dataStore)
	{
		
		if(dataStore.equalsIgnoreCase("rdbms_pu"))
		{
			
			System.out.println(dataStore);
			try {
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.GeographicLocation","firstrespondermodel",  "geographiclocation",   "geographicLocationID"  , "geographicLocation_ID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.FirstResponder","firstrespondermodel",  "firstresponder",   "firstResponderID"  , "firstResponderID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.Incident","firstrespondermodel",  "incident",   "incidentID"  , "incidentID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.OxygenSensorData","firstrespondermodel",  "oxygensensordata",   "oxygenSensorDataID"  , "oxygenSensorDataID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.SensorModule","firstrespondermodel",  "sensormodule",   "sensorModuleID"  , "sensorModuleID");
				
				//WorkingStaff
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.WorkingStaff","firstrespondermodel",  "workingstaff",   "workingStaffID"  , "workingStaffID");
				
				// Under EnvironmentSensorData
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.TemperatureSensorData","firstrespondermodel",  "temperaturesensordata",   "temperatureSensorDataID"  , "temperatureSensorDataID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.HumiditySensorData","firstrespondermodel",  "humiditysensordata",   "humiditySensorDataID"  , "humiditySensorDataID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.InfraredCameraData","firstrespondermodel",  "infraredcameradata",   "infraredCameraDataID"  , "infraredCameraDataID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.AtmosphericPressureSensorData","firstrespondermodel",  "atmosphericpressuresensordata",   "atmosphericPressureSensorDataID"  , "atmosphericPressureSensorDataID");
				
				// Under GasSensorData
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.PoisonousGasData","firstrespondermodel",  "poisonousgasdata",   "poisonousGasDataID"  , "poisonousGasDataID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.CombustibleGasData","firstrespondermodel",  "combustiblegasdata",   "combustibleGasDataID"  , "combustibleGasDataID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.VolatileOrganicCompoundSensorData","firstrespondermodel",  "volatileorganiccompoundsensordata",   "volatileOrganicCompoundSensorDataID"  , "volatileOrganicCompoundSensorDataID");
				
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.FlammableGasData","firstrespondermodel",  "flammablegasdata",   "flammableGasDataID"  , "flammableGasDataID");
				
				// Under MotionSensorData
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.GyroscopeData","firstrespondermodel",  "gyroscopedata",   "gyroscopeDataID"  , "gyroscopeDataID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.AccelerometerData","firstrespondermodel",  "accelerometerdata",   "accelerometerDataID"  , "accelerometerDataID");
				
				//Under BiometricSensorData
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.HeartRateData","firstrespondermodel",  "heartratedata",   "heartRateDataID"  , "heartRateDataID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.HydrationData","firstrespondermodel",  "hydrationdata",   "hydrationDataID"  , "hydrationDataID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.PulseOximeterData","firstrespondermodel",  "pulseoximeterdata",   "pulseOximeterDataID"  , "pulseOximeterDataID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.ECGData","firstrespondermodel",  "ecgdata",   "ecgDataID"  , "ecgDataID");
				
				//ProximitySensor
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.ProximitySensor","firstrespondermodel",  "proximitysensor",   "proximitySensorID"  , "proximitySensorID");
				
				//OperationalStatus
				
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.GatewayOperationalStatus","firstResponderModel",  "gatewayoperationalstatus",   "gatewayOperationalStatusID"  , "gatewayOperationalStatusID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.Gateway","firstResponderModel",  "gateway",   "gatewayID"  , "gatewayID");
				
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.SensorModuleOperationalStatus","firstResponderModel",  "sensormoduleoperationalstatus",   "sensorModuleOperationalStatusID"  , "sensorModuleOperationalStatusID");
				//AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.SensorOperationalStatus","firstResponderModel",  "sensoroperationalstatus",   "sensorOperationalStatusID"  , "sensorOperationalStatusID");
				
				
				//CorporateEntity and related
				
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.CorporateEntity","firstResponderModel",  "corporateentity",   "corporateEntityID"  , "corporateEntityID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.FireStation","firstResponderModel",  "firestation",   "fireStationID"  , "fireStationID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.FireDepartment","firstResponderModel",  "firedepartment",   "fireDepartmentID"  , "fireDepartmentID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.Hospital","firstResponderModel",  "hospital",   "hospitalID"  , "hospitalID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.Refinery","firstResponderModel",  "refinery",   "refineryID"  , "refineryID");
				
				
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.PlantArea","firstResponderModel",  "plantarea",   "plantAreaID"  , "plantAreaID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.PrimaryOperatingUnit","firstResponderModel",  "primaryoperatingunit",   "primaryOperatingUnitID"  , "primaryOperatingUnitID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.SecondaryOperatingUnit","firstResponderModel",  "secondaryoperatingunit",   "secondaryOperatingUnitID"  , "secondaryOperatingUnitID");
				
				//FirstResponderBodySuitGateway and related
				//AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.FirstResponderBodySuitGateway","firstResponderModel",  "firstresponderbodysuitgateway",   "firstResponderBodySuitGatewayID"  , "firstResponderBodySuitGatewayID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.Battery","firstResponderModel",  "battery",   "batteryID"  , "batteryID");
				
				//MobileResponseVehicleGateway
				//AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.MobileResponseVehicleGateway","firstResponderModel",  "mobileresponsevehiclegateway",   "mobileResponseVehicleGatewayID"  , "mobileResponseVehicleGatewayID");
				
				//Mine and related
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.Mine","firstResponderModel",  "mine",   "mineID"  , "mineID");
				//AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.MineType","firstResponderModel",  "minetype",   "mineTypeID"  , "mineTypeID");
				
				// Wearable Device and all its related
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.WearableDevice","firstResponderModel",  "wearabledevice",   "wearableDeviceID"  , "wearableDeviceID");
				//AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.Wristband","firstResponderModel",  "wristband",   "wristbandID"  , "wristbandID");
				AddRunTimeAnnotation.addClassLevelAnnotationRdbms("firstResponderModel.Wristband", "firstResponderModel@cassandra_pu", "wristband");
				
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.LEDNotificationLights","firstResponderModel",  "lednotificationlights",   "ledNotificationLightsID"  , "ledNotificationLightsID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.Screen","firstResponderModel",  "screen",   "screenID"  , "screenID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.Speaker","firstResponderModel",  "speaker",   "speakerID"  , "speakerID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.VibrationGenerator","firstResponderModel",  "vibrationgenerator",   "vibrationGeneratorID"  , "vibrationGeneratorID");
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.Processor","firstResponderModel",  "processor",   "processorID"  , "processorID");
				
				//NetworkInterface and related
				
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.NetworkInterface","firstResponderModel",  "networkinterface",   "networkInterfaceID"  , "networkInterfaceID");
				
				//UE
				
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.UnmanagedEquipment","firstResponderModel",  "unmanagedequipment",   "equipmentTagID"  , "equipmentTagID");
				AddRunTimeAnnotation.addClassLevelAnnotationRdbms("firstResponderModel.MobileResponseVehicle", "firstResponderModel@cassandra_pu", "mobileresponsevehicle");
				
				//NotificationAlertMessage and related
				
				AddRunTimeAnnotation.addAnnotationForRdbms("firstResponderModel.NotificationAlertMessage","firstResponderModel",  "notificationalertmessage",   "alertID"  , "alertID");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		
		else if(dataStore.equalsIgnoreCase("cassandra_pu"))
		{
		     System.out.println(dataStore);
			
			try {
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.GeographicLocation","firstrespondermodel@cassandra_pu",  "geographiclocation",   "geographicLocationID"  , "geographicLocation_ID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.FirstResponder","firstrespondermodel@cassandra_pu",  "firstresponder",   "firstResponderID"  , "firstResponderID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.Incident","firstrespondermodel@cassandra_pu",  "incident",   "incidentID"  , "incidentID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.OxygenSensorData","firstrespondermodel@cassandra_pu",  "oxygensensordata",   "oxygenSensorDataID"  , "oxygenSensorDataID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.SensorModule","firstrespondermodel@cassandra_pu",  "sensormodule",   "sensorModuleID"  , "sensorModuleID");
				
				//WorkingStaff
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.WorkingStaff","firstrespondermodel@cassandra_pu",  "workingstaff",   "workingStaffID"  , "workingStaffID");
				
				
				// Under EnvironmentSensorData
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.TemperatureSensorData","firstrespondermodel@cassandra_pu",  "temperaturesensordata",   "temperatureSensorDataID"  , "temperatureSensorDataID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.HumiditySensorData","firstrespondermodel@cassandra_pu",  "humiditysensordata",   "humiditySensorDataID"  , "humiditySensorDataID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.InfraredCameraData","firstrespondermodel@cassandra_pu",  "infraredcameradata",   "infraredCameraDataID"  , "infraredCameraDataID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.AtmosphericPressureSensorData","firstrespondermodel@cassandra_pu",  "atmosphericpressuresensordata",   "atmosphericPressureSensorDataID"  , "atmosphericPressureSensorDataID");
				
				// Under GasSensorData
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.PoisonousGasData","firstrespondermodel@cassandra_pu",  "poisonousgasdata",   "poisonousGasDataID"  , "poisonousGasDataID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.CombustibleGasData","firstrespondermodel@cassandra_pu",  "combustiblegasdata",   "combustibleGasDataID"  , "combustiblegasdataID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.VolatileOrganicCompoundSensorData","firstrespondermodel@cassandra_pu",  "volatileorganiccompoundsensordata",   "volatileOrganicCompoundSensorDataID"  , "volatileOrganicCompoundSensorDataID");
				
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.FlammableGasData","firstrespondermodel@cassandra_pu",  "flammablegasdata",   "flammableGasDataID"  , "flammableGasDataID");
				
				// Under MotionSensorData
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.GyroscopeData","firstrespondermodel@cassandra_pu",  "gyroscopedata",   "gyroscopeDataID"  , "gyroscopeDataID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.AccelerometerData","firstrespondermodel@cassandra_pu",  "accelerometerdata",   "accelerometerDataID"  , "accelerometerDataID");
				
				//Under BiometricSensorData
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.HeartRateData","firstrespondermodel@cassandra_pu",  "heartratedata",   "heartRateDataID"  , "heartRateDataID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.HydrationData","firstrespondermodel@cassandra_pu",  "hydrationdata",   "hydrationDataID"  , "hydrationDataID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.PulseOximeterData","firstrespondermodel@cassandra_pu",  "pulseoximeterdata",   "pulseOximeterDataID"  , "pulseOximeterDataID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.ECGData","firstrespondermodel@cassandra_pu",  "ecgdata",   "ecgDataID"  , "ecgDataID");
				
				//ProximitySensor
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.ProximitySensor","firstrespondermodel@cassandra_pu",  "proximitysensor",   "proximitySensorID"  , "proximitySensorID");
				
				//OperationalStatus
				
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.GatewayOperationalStatus","firstResponderModel@cassandra_pu",  "gatewayoperationalstatus",   "gatewayOperationalStatusID"  , "gatewayOperationalStatusID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.Gateway","firstResponderModel@cassandra_pu",  "gateway",   "gatewayID"  , "gatewayID");
				
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.SensorModuleOperationalStatus","firstResponderModel@cassandra_pu",  "sensormoduleoperationalstatus",   "sensorModuleOperationalStatusID"  , "sensorModuleOperationalStatusID");
				//AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.SensorOperationalStatus","firstResponderModel@cassandra_pu",  "sensoroperationalstatus",   "sensorOperationalStatusID"  , "sensorOperationalStatusID");
				
				//CorporateEntity and related
				
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.CorporateEntity","firstResponderModel@cassandra_pu",  "corporateentity",   "corporateEntityID"  , "corporateEntityID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.FireStation","firstResponderModel@cassandra_pu",  "firestation",   "fireStationID"  , "fireStationID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.FireDepartment","firstResponderModel@cassandra_pu",  "firedepartment",   "fireDepartmentID"  , "fireDepartmentID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.Hospital","firstResponderModel@cassandra_pu",  "hospital",   "hospitalID"  , "hospitalID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.Refinery","firstResponderModel@cassandra_pu",  "refinery",   "refineryID"  , "refineryID");
				
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.PlantArea","firstResponderModel@cassandra_pu",  "plantarea",   "plantAreaID"  , "plantAreaID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.PrimaryOperatingUnit","firstResponderModel@cassandra_pu",  "primaryoperatingunit",   "primaryOperatingUnitID"  , "primaryOperatingUnitID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.SecondaryOperatingUnit","firstResponderModel@cassandra_pu",  "secondaryoperatingunit",   "secondaryOperatingUnitID"  , "secondaryOperatingUnitID");
				
				//FirstResponderBodySuitGateway and related
				//AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.FirstResponderBodySuitGateway","firstResponderModel@cassandra_pu",  "firstresponderbodysuitgateway",   "firstResponderBodySuitGatewayID"  , "firstResponderBodySuitGatewayID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.Battery","firstResponderModel@cassandra_pu",  "battery",   "batteryID"  , "batteryID");
				
				//MobileResponseVehicleGateway
				//AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.MobileResponseVehicleGateway","firstResponderModel@cassandra_pu",  "mobileresponsevehiclegateway",   "mobileResponseVehicleGatewayID"  , "mobileResponseVehicleGatewayID");
				
				//Mine and related
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.Mine","firstResponderModel@cassandra_pu",  "mine",   "mineID"  , "mineID");
				//AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.MineType","firstResponderModel@cassandra_pu",  "minetype",   "mineTypeID"  , "mineTypeID");
				
				
				// Wearable Device and all its related
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.WearableDevice","firstResponderModel@cassandra_pu",  "wearabledevice",   "wearableDeviceID"  , "wearableDeviceID");
				//AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.Wristband","firstResponderModel@cassandra_pu",  "wristband",   "wristbandID"  , "wristbandID");
				AddRunTimeAnnotation.addClassLevelAnnotationCassandra("firstResponderModel.Wristband", "firstResponderModel@cassandra_pu", "wristband");
				
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.LEDNotificationLights","firstResponderModel@cassandra_pu",  "lednotificationlights",   "ledNotificationLightsID"  , "ledNotificationLightsID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.Screen","firstResponderModel@cassandra_pu",  "screen",   "screenID"  , "screenID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.Speaker","firstResponderModel@cassandra_pu",  "speaker",   "speakerID"  , "speakerID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.VibrationGenerator","firstResponderModel@cassandra_pu",  "vibrationgenerator",   "vibrationGeneratorID"  , "vibrationGeneratorID");
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.Processor","firstResponderModel@cassandra_pu",  "processor",   "processorID"  , "processorID");
				
				//Building and its related
				//AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.Building","firstResponderModel@cassandra_pu",  "building",   "buildingID"  , "buildingID");
				
				//NetworkInterface and related
				
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.NetworkInterface","firstResponderModel@cassandra_pu",  "networkinterface",   "networkInterfaceID"  , "networkInterfaceID");
				
				//UE
				
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.UnmanagedEquipment","firstResponderModel@cassandra_pu",  "unmanagedequipment",   "equipmentTagID"  , "equipmentTagID");
				AddRunTimeAnnotation.addClassLevelAnnotationCassandra("firstResponderModel.MobileResponseVehicle", "firstResponderModel@cassandra_pu", "mobileresponsevehicle");
				
				//NotificationAlertMessage and related
				
				AddRunTimeAnnotation.addAnnotationForCassandra("firstResponderModel.NotificationAlertMessage","firstResponderModel@cassandra_pu",  "notificationalertmessage",   "alertID"  , "alertID");
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		else
		{
			System.out.println("Data store not configured");
			return;
		}
	}
	
	
	
	public static void addAnnotationForCassandra(String className,String schema,String tableName,String primaryField,String primaryKey) throws Exception{
		ClassPool pool = ClassPool.getDefault();
		
		//for loading class path, when used from command line.
		//pool.insertClassPath("C:/Users/acratchx/EclipseIOTG/grs-rest-service-base-version/target/classes");
		
		CtClass cc = pool.getCtClass(className);
		ClassFile cf = cc.getClassFile();
		ConstPool cp = cf.getConstPool();
		AnnotationsAttribute attr = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
		System.out.println("Adding run time annotations for Cassandra");
		/*********************Annotations at class level(for Entity class)********************************************/ 

		/**@Table(name = "geographiclocation",schema = "firstrespondermodel@cassandra_pu")**/ 
		Annotation a = new Annotation("javax.persistence.Table", cp);
		a.addMemberValue("name", new StringMemberValue(tableName, cp));
		a.addMemberValue("schema", new StringMemberValue(schema, cp));
		attr.setAnnotation(a);
		
		
		/**@Entity**/ 
		Annotation b = new Annotation("javax.persistence.Entity", cp);  
		attr.setAnnotation(b);
		cf.addAttribute(attr);
		
		
		/*********************Annotations at field level(for primary key field)**************************************/ 
		
		CtField field = cc.getDeclaredField(primaryField);
		
		/**@TableGenerator(name = "yourTableGenerator", allocationSize = 1, initialValue = 1)**/
		
		AnnotationsAttribute attr1 = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
		
		//Annotation f = new Annotation(cp, ClassPool.getDefault().get("javax.persistence.TableGenerator"));
		Annotation f =  new Annotation("javax.persistence.TableGenerator", cp);
		f.addMemberValue("name", new StringMemberValue("yourTableGenerator", cp));
		
		f.addMemberValue("allocationSize",new IntegerMemberValue(cp,(Integer)1));
		f.addMemberValue("initialValue", new IntegerMemberValue(cp,(Integer)1));
		
		
		/**@GeneratedValue(strategy = GenerationType.TABLE,generator="yourTableGenerator")**/
		//Annotation c = new Annotation(cp, ClassPool.getDefault().get("javax.persistence.GeneratedValue"));
		Annotation c =  new Annotation("javax.persistence.GeneratedValue", cp);
		EnumMemberValue gt = new EnumMemberValue(cp);
		gt.setValue(GenerationType.TABLE.toString());
		gt.setType("javax.persistence.GenerationType");
		c.addMemberValue("strategy",   gt);
		c.addMemberValue("generator",   new StringMemberValue("yourTableGenerator", cp));
		
		/**@Id**/
		Annotation d = new Annotation("javax.persistence.Id", cp);
		/**@Column(name="geographicLocation_ID")**/
		Annotation e = new Annotation("javax.persistence.Column", cp);
		e.addMemberValue("name", new StringMemberValue(primaryKey, cp));
		
		
        attr1.addAnnotation(c);
        attr1.addAnnotation(d);
        attr1.addAnnotation(e);
        attr1.addAnnotation(f);
		field.getFieldInfo().addAttribute(attr1);
	    
		
		
		
		Class<?> cl = cc.toClass();
		
		
		
	}

	
	
	
	
	public static void addAnnotationForRdbms(String className,String schema,String tableName,String primaryField,String primaryKey) throws Exception{
		ClassPool pool = ClassPool.getDefault();
		
		//for loading class path, when used from command line.
		//pool.insertClassPath("C:/Users/acratchx/EclipseIOTG/grs-rest-service-base-version/target/classes");
		
		CtClass cc = pool.getCtClass(className);
		ClassFile cf = cc.getClassFile();
		ConstPool cp = cf.getConstPool();
		AnnotationsAttribute attr = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
		
		/*********************Annotations at class level(for Entity class)********************************************/ 

		/**@Table(name = "geographiclocation",schema = "firstrespondermodel")**/ 
		Annotation a = new Annotation("javax.persistence.Table", cp);
		a.addMemberValue("name", new StringMemberValue(tableName, cp));
		a.addMemberValue("schema", new StringMemberValue(schema, cp));
		attr.setAnnotation(a);
		
		
		/**@Entity**/ 
		Annotation b = new Annotation("javax.persistence.Entity", cp);  
		attr.setAnnotation(b);
		cf.addAttribute(attr);
		
		
		/*********************Annotations at field level(for primary key field)**************************************/ 
		
		CtField field = cc.getDeclaredField(primaryField);
		
		
		/**@GeneratedValue(strategy = GenerationType.IDENTITY)**/
		
		AnnotationsAttribute attr1 = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
		//Annotation c = new Annotation(cp, ClassPool.getDefault().get("javax.persistence.GeneratedValue"));
		Annotation c = new Annotation("javax.persistence.GeneratedValue", cp);
		EnumMemberValue gt = new EnumMemberValue(cp);
		gt.setValue(GenerationType.IDENTITY.toString());
		gt.setType("javax.persistence.GenerationType");
		c.addMemberValue("strategy",   gt);
		
		/**@Id**/
		Annotation d = new Annotation("javax.persistence.Id", cp);
		/**@Column(name="geographicLocation_ID")**/
		Annotation e = new Annotation("javax.persistence.Column", cp);
		e.addMemberValue("name", new StringMemberValue(primaryKey, cp));
		
        attr1.addAnnotation(c);
        attr1.addAnnotation(d);
        attr1.addAnnotation(e);
		field.getFieldInfo().addAttribute(attr1);
	    
		
		
		
		Class<?> cl = cc.toClass();
		System.out.println(cl.getDeclaredAnnotations().length);
		
		
	}

	
	public static void addClassLevelAnnotationRdbms (String className,String schema,String tableName) throws Exception {
		
       ClassPool pool = ClassPool.getDefault();
		
		//for loading class path, when used from command line.
		//pool.insertClassPath("C:/Users/acratchx/EclipseIOTG/grs-rest-service-base-version/target/classes");
		
		CtClass cc = pool.getCtClass(className);
		ClassFile cf = cc.getClassFile();
		ConstPool cp = cf.getConstPool();
		AnnotationsAttribute attr = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
		
		/*********************Annotations at class level(for Entity class)********************************************/ 

		/**@Table(name = "geographiclocation",schema = "firstrespondermodel")**/ 
		Annotation a = new Annotation("javax.persistence.Table", cp);
		a.addMemberValue("name", new StringMemberValue(tableName, cp));
		a.addMemberValue("schema", new StringMemberValue(schema, cp));
		attr.setAnnotation(a);
		
		
		/**@Entity**/ 
		Annotation b = new Annotation("javax.persistence.Entity", cp);  
		attr.setAnnotation(b);
		cf.addAttribute(attr);
		
	}
	
	public static void addClassLevelAnnotationCassandra(String className,String schema,String tableName) throws Exception{
		
        ClassPool pool = ClassPool.getDefault();
		
		//for loading class path, when used from command line.
		//pool.insertClassPath("C:/Users/acratchx/EclipseIOTG/grs-rest-service-base-version/target/classes");
		
		CtClass cc = pool.getCtClass(className);
		ClassFile cf = cc.getClassFile();
		ConstPool cp = cf.getConstPool();
		AnnotationsAttribute attr = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
		System.out.println("Adding run time annotations for Cassandra");
		/*********************Annotations at class level(for Entity class)********************************************/ 

		/**@Table(name = "geographiclocation",schema = "firstrespondermodel@cassandra_pu")**/ 
		Annotation a = new Annotation("javax.persistence.Table", cp);
		a.addMemberValue("name", new StringMemberValue(tableName, cp));
		a.addMemberValue("schema", new StringMemberValue(schema, cp));
		attr.setAnnotation(a);
		
		
		/**@Entity**/ 
		Annotation b = new Annotation("javax.persistence.Entity", cp);  
		attr.setAnnotation(b);
		cf.addAttribute(attr);
		
	}
}
