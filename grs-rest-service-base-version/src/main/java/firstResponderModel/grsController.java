package firstResponderModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;;
import org.springframework.stereotype.Controller;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;




//import operationalStatusAndRelated.Gateway;
//import operationalStatusAndRelated.GatewayOperationalStatus;

/*import after_12_04_meet.Gateway;
import after_12_04_meet.GatewayOperationalStatus;
import after_12_04_meet.SensorModuleOperationalStatus;
*/

//@EnableAutoConfiguration
@Controller
public class grsController extends WebMvcConfigurerAdapter {

    
    private final AtomicLong counter = new AtomicLong();
    private final  AtomicLong activePersonnelcounter  = new AtomicLong();
	private final AtomicLong atomicLongFirstResponderId = new AtomicLong();
	
	/*private String persistentUnit = Application.ARGS[0];
   
    
     * 
     * 
     * Creating EntityManagerFactory and EntityManager for the specific persistence unit
     * 
     * 
     
	//HashMap propertyMap = new HashMap();
	//propertyMap.put(CassandraConstants.CQL_VERSION, CassandraConstants.CQL_VERSION_3_0);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistentUnit);*/
    EntityManager em = Application.em;
    

    /*
     * 
     * ***************************GeographicLocation***************************************************
     * 
     */
    
    //Create GeographicLocation
    @RequestMapping(value="/createGeographicLocation",method = RequestMethod.POST, consumes =
    	    "application/json" , produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody

    public GeographicLocation createLocation(@RequestBody @Valid GeographicLocation gLocation) {
     
        
        em.persist(gLocation);
        
        
        return gLocation;
    }
    
   //Find GeographicLocation
    @RequestMapping(value="/getGeographicLocation/{gLoc_id}",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GeographicLocation getLocation(@PathVariable("gLoc_id") Long gLoc_id) {
        

        System.out.println(gLoc_id);
        GeographicLocation gLocation = em.find(GeographicLocation.class, gLoc_id);
        
        
       
        
        return gLocation;
    }
    
    //List all GeographicLocations
    @RequestMapping(value="/getAllGeographicLocations",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<GeographicLocation> getAllGeographicLocations() throws IOException {
        
        Query q = em.createQuery("Select g from GeographicLocation g");
        List<GeographicLocation> results = q.getResultList();
       
        /*PrintWriter pw = resp.getWriter();
        pw.println("Heloooooooooo");*/
        return results;
    }
    
    
    @RequestMapping("/home")
	  public String templates(Model model) {
	    return "home";
	  }
    
    
    
    
   //Delete GeographicLocation
    @RequestMapping(value = "/deleteGeographicLocation/{gLoc_id}",method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteGeographicLocation(@PathVariable("gLoc_id") Long gLoc_id)  {
    	
    	
    	GeographicLocation gLocation = em.find(GeographicLocation.class, gLoc_id);
    	
    	em.remove(gLocation);
    }
    
    
    /*
     * 
     * ***************************FirstResponder***************************************************
     * 
     */
    
    
    
    //Create FirstResponder
    @RequestMapping(value="/createFirstResponder",method = RequestMethod.POST, consumes =
    	    "application/json" , produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody

    public FirstResponder createFirstResponder(@RequestBody @Valid FirstResponder firstResponder) {
	   
	   GeographicLocation gLocation = em.find(GeographicLocation.class, firstResponder.getGlocation().getGeographicLocationID());
	   firstResponder.setGlocation(gLocation);
	   
	   Incident incident =em.find(Incident.class, firstResponder.getRespondsTo().getIncidentID());
	   firstResponder.setRespondsTo(incident);
	  
	   em.persist(firstResponder);
	   
       return firstResponder;
    }
    
    
    //Find a FirstResponder
    @RequestMapping(value="/getFirstResponder/{firstResponder_id}",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public FirstResponder getFirstResponder(@PathVariable("firstResponder_id") Long firstResponder_id) {
        

       
    	FirstResponder firstResponder = em.find(FirstResponder.class, firstResponder_id);
        
      
        return firstResponder;
    }
    
    //List all FirstResponders
    @RequestMapping(value="/getAllFirstResponders",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public  List<FirstResponder> getAllFirstResponders() {
        
        Query q = em.createQuery("Select f from FirstResponder f");
        List<FirstResponder> results = q.getResultList();
       
        return results;
    }
    
    
    
    
    //Delete a FirstResponder
    @RequestMapping(value = "/deleteFirstResponder/{firstResponder_id}",method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteFirstResponder(@PathVariable("firstResponder_id") Long firstResponder_id)  {
    	
    	
    	FirstResponder firstResponder = em.find(FirstResponder.class, firstResponder_id);
    	
    	em.remove(firstResponder);
    }

    /*
     * 
     * ***************************Incident***************************************************
     * 
     */
    
    //Create Incident
    @RequestMapping(value="/createIncident",method = RequestMethod.POST, consumes =
    	    "application/json" , produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Incident createIncident(@RequestBody @Valid Incident incident) {
	   
	   GeographicLocation gLocation = em.find(GeographicLocation.class, incident.getGlocation().getGeographicLocationID());
	   incident.setGlocation(gLocation);
	   
	   
	   em.persist(incident);
	   
       return incident;
    }
    
    //Find a Incident
    @RequestMapping(value="/getIncident/{incident_id}",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Incident getIncident(@PathVariable("incident_id") Long incident_id) {
        

       
    	Incident incident = em.find(Incident.class, incident_id);
        
      
        return incident;
    }
   
    
    //List all Incidents
    @RequestMapping(value="/getAllIncidents",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public  List<Incident> getAllIncidents() {
        
        Query q = em.createQuery("Select i from Incident i");
        List<Incident> results = q.getResultList();
       
        return results;
    }
    
    
    
    //Delete an Incident
    @RequestMapping(value = "/deleteIncident/{incident_id}",method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteIncident(@PathVariable("incident_id") Long incident_id)  {
    	
    	
    	Incident incident = em.find(Incident.class, incident_id);
    	
    	em.remove(incident);
    }
    
    
    /*
     * 
     * ***************************Sensor Module***************************************************
     * 
     */

    //Create OxygenSensorData
    @RequestMapping(value="/createSensorModule",method = RequestMethod.POST, consumes =
    	    "application/json" , produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SensorModule createSensorModule(@RequestBody @Valid SensorModule sensorModule) {
	   
       FirstResponder wornBy = em.find(FirstResponder.class, sensorModule.getWornBy().getFirstResponderID());
       sensorModule.setWornBy(wornBy);
    	
	   em.persist(sensorModule);
	   
       return sensorModule;
    }
    
    
    //Find a SensorModule
    @RequestMapping(value="/getSensorModule/{sensorModuleID}",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SensorModule getSensorModule(@PathVariable("sensorModuleID") Long sensorModuleID) {
        

       
    	SensorModule sensorModule = em.find(SensorModule.class, sensorModuleID);
        
      
        return sensorModule;
    }
    
    
    //List all SensorModules
    @RequestMapping(value="/getAllSensorModules",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public  List<SensorModule> getAllSensorModules() {
        
        Query q = em.createQuery("Select sm from SensorModule sm");
        List<SensorModule> results = q.getResultList();
       
        return results;
    }
    
   //Delete a SensorModule
    @RequestMapping(value = "/deleteSensorModule/{sensorModuleID}",method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteSensorModule(@PathVariable("sensorModuleID") Long sensorModuleID)  {
    	
    	
    	SensorModule sensorModule = em.find(SensorModule.class, sensorModuleID);
    	
    	em.remove(sensorModule);
    }
    
    
    
    /*
     * 
     * ***************************OxygenSensorData***************************************************
     * 
     */

    //Create OxygenSensorData
    @RequestMapping(value="/createOxygenSensorData",method = RequestMethod.POST, consumes =
    	    "application/json" , produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public OxygenSensorData createOxygenSensorData(@RequestBody @Valid OxygenSensorData oxygenSensorData) {
	   
	   GeographicLocation gLocation = em.find(GeographicLocation.class, oxygenSensorData.getLocationOfDevice().getGeographicLocationID());
	   oxygenSensorData.setLocationOfDevice(gLocation);
	   
	   SensorModule parentSensorModule = em.find(SensorModule.class, oxygenSensorData.getParentSensorModule().getSensorModuleID());
	   oxygenSensorData.setParentSensorModule(parentSensorModule);
	  
	   em.persist(oxygenSensorData);
	   
       return oxygenSensorData;
    }
    
    
    //Find Sensor Data
    @RequestMapping(value="/getOxygenSensorData/{oxygenSensorDataID}",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public OxygenSensorData getOxygenSensorData(@PathVariable("oxygenSensorDataID") Long oxygenSensorDataID) {
        

       
    	OxygenSensorData oxygenSensorData = em.find(OxygenSensorData.class, oxygenSensorDataID);
        
      
        return oxygenSensorData;
    }
    
    
    
    
    //List all SensorData
    @RequestMapping(value="/getAllOxygenSensorData",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public  List<OxygenSensorData> getAllOxygenSensorData() {
        
        Query q = em.createQuery("Select s from OxygenSensorData s");
        List<OxygenSensorData> results = q.getResultList();
       
        return results;
    }
    
    
    //Delete Sensor Data
    @RequestMapping(value = "/deleteOxygenSensorData/{oxygenSensorDataID}",method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteOxygenSensorData(@PathVariable("oxygenSensorDataID") Long oxygenSensorDataID)  {
    	
    	
    	OxygenSensorData oxygenSensorData = em.find(OxygenSensorData.class, oxygenSensorDataID);
    	
    	em.remove(oxygenSensorData);
    }
    
    
    
    
    
    
    
    //*** @AR *********Poisonous Gas Data***************************************************************************************
    
    
    
    @RequestMapping(value = "/createPoisonousGasData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus (HttpStatus.CREATED)
    @ResponseBody
    public PoisonousGasData createPoisonousGasData(@RequestBody @Valid PoisonousGasData poisonousGasData) {
    	
       GeographicLocation gLocation = em.find(GeographicLocation.class, poisonousGasData.getLocationOfDevice().getGeographicLocationID());
       poisonousGasData.setLocationOfDevice(gLocation);
  	   
  	   SensorModule parentSensorModule = em.find(SensorModule.class, poisonousGasData.getParentSensorModule().getSensorModuleID());
  	    poisonousGasData.setParentSensorModule(parentSensorModule);
    	
    	em.persist(poisonousGasData);
    	
    	return poisonousGasData;
    }
    
    @RequestMapping(value="/getPoisonousGasData/{poisonousGasDataID}",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PoisonousGasData getPoisonousGasData (@PathVariable("poisonousGasDataID") Long poisonousGasDataID) {
        

       
    	PoisonousGasData poisonousGasData = em.find(PoisonousGasData.class, poisonousGasDataID);
        
      
        return poisonousGasData;
    }
    
    @RequestMapping(value = "/deletePoisonousGasData/{poisonousGasDataID}",method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deletePoisonousGasData(@PathVariable("poisonousGasDataID") Long poisonousGasDataID)  {
    	
    	
    	PoisonousGasData poisonousGasData = em.find(PoisonousGasData.class, poisonousGasDataID);
    	
    	em.remove(poisonousGasData);
    }
    
    
   
    @RequestMapping(value="/getAllPoisonousGasData",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public  List<PoisonousGasData> getAllPoisonousGasData() {
        
        Query q = em.createQuery("Select p from PoisonousGasData p");
        List<PoisonousGasData> results = q.getResultList();
       
        return results;
    }
    

    
    



//********* @AR ********Combustible Gas Data*****************************************************************************


	@RequestMapping(value = "/createCombustibleGasData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseStatus (HttpStatus.CREATED)
	@ResponseBody
	public CombustibleGasData createCombustibleGasData(@RequestBody @Valid CombustibleGasData combustibleGasData) {
		
		GeographicLocation gLocation = em.find(GeographicLocation.class, combustibleGasData.getLocationOfDevice().getGeographicLocationID());
		combustibleGasData.setLocationOfDevice(gLocation);
		   
	    SensorModule parentSensorModule = em.find(SensorModule.class, combustibleGasData.getParentSensorModule().getSensorModuleID());
		combustibleGasData.setParentSensorModule(parentSensorModule);
		
		
		em.persist(combustibleGasData);
		
		return combustibleGasData;
	}
	
	
	@RequestMapping(value="/getCombustibleGasData/{combustibleGasDataID}",method = RequestMethod.GET,  produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public CombustibleGasData getCombustibleGasData (@PathVariable("combustibleGasDataID") Long combustibleGasDataID) {
	    
	
	   
		CombustibleGasData combustibleGasData = em.find(CombustibleGasData.class, combustibleGasDataID);
	    
	  
	    return combustibleGasData;
	}


	  @RequestMapping(value = "/deleteCombustibleGasData/{combustibleGasDataID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deleteCombustibleGasData(@PathVariable("combustibleGasDataID") Long combustibleGasDataID)  {
	    	
	    	
		  CombustibleGasData combustibleGasData = em.find(CombustibleGasData.class, combustibleGasDataID);
	    	
	    	em.remove(combustibleGasData);
	    }
	    
	    
	   
	    @RequestMapping(value="/getAllCombustibleGasData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<CombustibleGasData> getAllCombustibleGasData() {
	        
	        Query q = em.createQuery("Select c from CombustibleGasData c");
	        List<CombustibleGasData> results = q.getResultList();
	       
	        return results;
	    }
	
	    
	    
	    
	
//********@AR*****Volatile Organic Compound Sensor Data******************************************************************
	    
	    @RequestMapping(value = "/createVocSensorData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public VolatileOrganicCompoundSensorData createVolatileOrganicCompoundSensorData(@RequestBody @Valid VolatileOrganicCompoundSensorData volatileOrganicCompoundSensorData) {
			
	       GeographicLocation gLocation = em.find(GeographicLocation.class, volatileOrganicCompoundSensorData.getLocationOfDevice().getGeographicLocationID());
	       volatileOrganicCompoundSensorData.setLocationOfDevice(gLocation);
	 	   
	 	   SensorModule parentSensorModule = em.find(SensorModule.class, volatileOrganicCompoundSensorData.getParentSensorModule().getSensorModuleID());
	 	  volatileOrganicCompoundSensorData.setParentSensorModule(parentSensorModule);
	    	
			em.persist(volatileOrganicCompoundSensorData);
			
			return volatileOrganicCompoundSensorData;
		}

	    
		@RequestMapping(value="/getVocSensorData/{volatileOrganicCompoundSensorDataID}",method = RequestMethod.GET,  produces = "application/json")
		@ResponseStatus(HttpStatus.OK)
		@ResponseBody
		public VolatileOrganicCompoundSensorData getVolatileOrganicCompoundSensorData (@PathVariable("volatileOrganicCompoundSensorDataID") Long volatileOrganicCompoundSensorDataID) {
		    
		
		   
			VolatileOrganicCompoundSensorData volatileOrganicCompoundSensorData = em.find(VolatileOrganicCompoundSensorData.class, volatileOrganicCompoundSensorDataID);
		    
		  
		    return volatileOrganicCompoundSensorData;
		}
	    
		
	    @RequestMapping(value = "/deleteVocSensorData/{volatileOrganicCompoundSensorDataID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deleteVolatileOrganicCompoundSensorData(@PathVariable("volatileOrganicCompoundSensorDataID") Long volatileOrganicCompoundSensorDataID)  {
	    	
	    	
	    	VolatileOrganicCompoundSensorData volatileOrganicCompoundSensorData = em.find(VolatileOrganicCompoundSensorData.class, volatileOrganicCompoundSensorDataID);
	    	
	    	em.remove(volatileOrganicCompoundSensorData);
	    }
		
		
	    @RequestMapping(value="/getAllVocSensorData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<VolatileOrganicCompoundSensorData> getAllVolatileOrganicCompoundSensorData() {
	        
	        Query q = em.createQuery("Select v from VolatileOrganicCompoundSensorData v");
	        List<VolatileOrganicCompoundSensorData> results = q.getResultList();
	       
	        return results;
	    }
		
		
	  //*******@AR*******FlammableGasData under GasSensorData**********************************************************************
	    
	    @RequestMapping(value = "/createFlammableGasData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public FlammableGasData createFlammableGasData(@RequestBody @Valid FlammableGasData flammableGasData) {
			

	    	
			em.persist(flammableGasData);
			
			return flammableGasData;
		
	    }
			
	    
	    //----need to add get and delete methods
	    
	    
	    
//*******@AR*******TemperatureSensorData under EnvironmentSensorData**********************************************************************
	    
	    @RequestMapping(value = "/createTemperatureSensorData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public TemperatureSensorData createTemperatureSensorData(@RequestBody @Valid TemperatureSensorData temperatureSensorData) {
			
	    	GeographicLocation gLocation = em.find(GeographicLocation.class, temperatureSensorData.getLocationOfDevice().getGeographicLocationID());
	    	temperatureSensorData.setLocationOfDevice(gLocation);
		 	   
		 	   SensorModule parentSensorModule = em.find(SensorModule.class, temperatureSensorData.getParentSensorModule().getSensorModuleID());
		 	  temperatureSensorData.setParentSensorModule(parentSensorModule);
		    	
	    	
			em.persist(temperatureSensorData);
			
			return temperatureSensorData;
		
	    }
			
	    
	    //Find Sensor Data
	    @RequestMapping(value="/getTemperatureSensorData/{temperatureSensorDataID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public TemperatureSensorData getTemperatureSensorData(@PathVariable("temperatureSensorDataID") Long temperatureSensorDataID) {
	        
	    	
	    	TemperatureSensorData temperatureSensorData = em.find(TemperatureSensorData.class, temperatureSensorDataID);
	        
	      
	        return temperatureSensorData;
	    }
	    
	    
	    //Delete Sensor Data
	    @RequestMapping(value = "/deleteTemperatureSensorData/{temperatureSensorDataID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deleteTemperatureSensorData(@PathVariable("temperatureSensorDataID") Long temperatureSensorDataID)  {
	    	
	    	
	    	TemperatureSensorData temperatureSensorData = em.find(TemperatureSensorData.class, temperatureSensorDataID);
	    	
	    	em.remove(temperatureSensorData);
	    }
	    
	    
	    //List all SensorData
	    @RequestMapping(value="/getAllTemperatureSensorData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<TemperatureSensorData> getAllTemperatureSensorData() {
	        
	        Query q = em.createQuery("Select t from TemperatureSensorData t");
	        List<TemperatureSensorData> results = q.getResultList();
	       
	        return results;
	    }

	
	    //List current SensorData
	    @RequestMapping(value="/getCurrentTemperatureSensorData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<Integer> getCurrentTemperatureSensorData() {
	        
	        Query q = em.createQuery("select t from TemperatureSensorData t");
	        
	        q.setMaxResults(3);
	        
	        List<TemperatureSensorData> results = q.getResultList();
	        
	        List<Integer> ct = new ArrayList<Integer>();
	        
	        for (TemperatureSensorData rs: results) {
	        	
	        	//rs.getAmbientTemperature();
	        	ct.add(rs.getAmbientTemperature());
	        	
	        	
	        }
	        
	        return ct;
	      
	        
	    }

	    
	    
	    
	    
	    
//*******@AR*******HumiditySensorData under EnvironmentSensorData*************************************************************************************

	    
	    @RequestMapping(value = "/createHumiditySensorData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public HumiditySensorData createHumiditySensorData(@RequestBody @Valid HumiditySensorData humiditySensorData) {
			
	    	GeographicLocation gLocation = em.find(GeographicLocation.class, humiditySensorData.getLocationOfDevice().getGeographicLocationID());
	    	humiditySensorData.setLocationOfDevice(gLocation);
		 	   
		 	   SensorModule parentSensorModule = em.find(SensorModule.class, humiditySensorData.getParentSensorModule().getSensorModuleID());
		 	  humiditySensorData.setParentSensorModule(parentSensorModule);
	    	
			em.persist(humiditySensorData);
			
			return humiditySensorData;
		
	    }
	    
	    
	    //Find Sensor Data
	    @RequestMapping(value="/getHumiditySensorData/{humiditySensorDataID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public HumiditySensorData getHumiditySensorData(@PathVariable("humiditySensorDataID") Long humiditySensorDataID) {
	        
	    	
	    	HumiditySensorData humiditySensorData = em.find(HumiditySensorData.class, humiditySensorDataID);
	        
	      
	        return humiditySensorData;
	    }
	    
	    
	    
	    
	    //Delete Sensor Data
	    @RequestMapping(value = "/deleteHumiditySensorData/{humiditySensorDataID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deleteHumiditySensorData(@PathVariable("humiditySensorDataID") Long humiditySensorDataID)  {
	    	
	    	
	    	HumiditySensorData humiditySensorData = em.find(HumiditySensorData.class, humiditySensorDataID);
	    	
	    	em.remove(humiditySensorData);
	    }
	    
	    
	    
	    
	    //List all SensorData
	    @RequestMapping(value="/getAllHumiditySensorData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<HumiditySensorData> getAllHumiditySensorData() {
	        
	        Query q = em.createQuery("Select h from HumiditySensorData h");
	        List<HumiditySensorData> results = q.getResultList();
	       
	        return results;
	    }
	    
	    
	    
	    
			
	    
//*******@AR*******AtmosphericPressureSensorData under EnvironmentSensorData***********************************************************************  
	    
	    
	    @RequestMapping(value = "/createAtmosphericPressureSensorData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public AtmosphericPressureSensorData createAtmosphericPressureSensorData(@RequestBody @Valid AtmosphericPressureSensorData atmosphericPressureSensorData) {
				
	    	GeographicLocation gLocation = em.find(GeographicLocation.class, atmosphericPressureSensorData.getLocationOfDevice().getGeographicLocationID());
	    	atmosphericPressureSensorData.setLocationOfDevice(gLocation);
		 	   
		 	SensorModule parentSensorModule = em.find(SensorModule.class, atmosphericPressureSensorData.getParentSensorModule().getSensorModuleID());
		 	atmosphericPressureSensorData.setParentSensorModule(parentSensorModule);
	    	
	    	em.persist(atmosphericPressureSensorData);
				
			return atmosphericPressureSensorData;
			
		 }
	    
	    
	    
	    //Find Sensor Data
	    @RequestMapping(value="/getAtmosphericPressureSensorData/{atmosphericPressureSensorDataID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public AtmosphericPressureSensorData getAtmosphericPressureSensorData(@PathVariable("atmosphericPressureSensorDataID") Long atmosphericPressureSensorDataID) {
	        
	    	
	    	AtmosphericPressureSensorData atmosphericPressureSensorData = em.find(AtmosphericPressureSensorData.class, atmosphericPressureSensorDataID);
	        
	      
	        return atmosphericPressureSensorData;
	    }
	    
	    
	    
	    //Delete Sensor Data
	    @RequestMapping(value = "/deleteAtmosphericPressureSensorData/{atmosphericPressureSensorDataID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deleteAtmosphericPressureSensorData(@PathVariable("atmosphericPressureSensorDataID") Long atmosphericPressureSensorDataID)  {
	    	
	    	
	    	AtmosphericPressureSensorData atmosphericPressureSensorData = em.find(AtmosphericPressureSensorData.class, atmosphericPressureSensorDataID);
	    	
	    	em.remove(atmosphericPressureSensorData);
	    }
	    
	    
	    //List all SensorData
	    @RequestMapping(value="/getAllAtmosphericPressureSensorData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<AtmosphericPressureSensorData> getAllAtmosphericPressureSensorData() {
	        
	        Query q = em.createQuery("Select a from AtmosphericPressureSensorData a");
	        List<AtmosphericPressureSensorData> results = q.getResultList();
	       
	        return results;
	    }
	    
	    
	    
	    
	    
//*******@AR*******Infrared Camera Data under EnvironmentSensorData*****************************************************************************************
	    
	    @RequestMapping(value = "/createInfraredCameraData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public InfraredCameraData createInfraredCameraData(@RequestBody @Valid InfraredCameraData infraredCameraData) {
				
	    	GeographicLocation gLocation = em.find(GeographicLocation.class, infraredCameraData.getLocationOfDevice().getGeographicLocationID());
	    	infraredCameraData.setLocationOfDevice(gLocation);
		 	   
		 	SensorModule parentSensorModule = em.find(SensorModule.class, infraredCameraData.getParentSensorModule().getSensorModuleID());
		 	infraredCameraData.setParentSensorModule(parentSensorModule);
	    	
	    	em.persist(infraredCameraData);
				
			return infraredCameraData;
			
		 }
	    
	    

	    //Find Sensor Data
	    @RequestMapping(value="/getInfraredCameraData/{infraredCameraDataID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public InfraredCameraData getInfraredCameraData(@PathVariable("infraredCameraDataID") Long infraredCameraDataID) {
	        
	    	
	    	InfraredCameraData infraredCameraData = em.find(InfraredCameraData.class, infraredCameraDataID);
	        
	      
	        return infraredCameraData;
	    }
	    
	    
	  //Delete Sensor Data
	    @RequestMapping(value = "/deleteInfraredCameraData/{infraredCameraDataID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deleteInfraredCameraData(@PathVariable("infraredCameraDataID") Long infraredCameraDataID)  {
	    	
	    	
	    	InfraredCameraData infraredCameraData = em.find(InfraredCameraData.class, infraredCameraDataID);
	    	
	    	em.remove(infraredCameraData);
	    }
	    
	    
	    //List all SensorData
	    @RequestMapping(value="/getAllInfraredCameraData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<InfraredCameraData> getAllInfraredCameraData() {
	        
	        Query q = em.createQuery("Select i from InfraredCameraData i");
	        List<InfraredCameraData> results = q.getResultList();
	       
	        return results;
	    }
	    
	    
	    
	    
	    
	    
//*******@AR*******GyroscopeData under MotionSensorData*******************************************************************************************************
	    
	    @RequestMapping(value = "/createGyroscopeData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public GyroscopeData createGyroscopeData(@RequestBody @Valid GyroscopeData gyroscopeData) {
				
	    	GeographicLocation gLocation = em.find(GeographicLocation.class, gyroscopeData.getLocationOfDevice().getGeographicLocationID());
	    	gyroscopeData.setLocationOfDevice(gLocation);
		 	   
		 	SensorModule parentSensorModule = em.find(SensorModule.class, gyroscopeData.getParentSensorModule().getSensorModuleID());
		 	gyroscopeData.setParentSensorModule(parentSensorModule);
	    	
	    	em.persist(gyroscopeData);
				
			return gyroscopeData;
			
		 }
	    
	    
	    //Find Sensor Data
	    @RequestMapping(value="/getGyroscopeData/{gyroscopeDataID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public GyroscopeData getGyroscopeData(@PathVariable("gyroscopeDataID") Long gyroscopeDataID) {
	        
	    	
	    	GyroscopeData gyroscopeData = em.find(GyroscopeData.class, gyroscopeDataID);
	        
	      
	        return gyroscopeData;
	    }
	    
	    
		  //Delete Sensor Data
	    @RequestMapping(value = "/deleteGyroscopeData/{gyroscopeDataID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deleteGyroscopeData(@PathVariable("gyroscopeDataID") Long gyroscopeDataID)  {
	    	
	    	
	    	GyroscopeData gyroscopeData = em.find(GyroscopeData.class, gyroscopeDataID);
	    	
	    	em.remove(gyroscopeData);
	    }
	    
	    

	    //List all SensorData
	    @RequestMapping(value="/getAllGyroscopeData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<GyroscopeData> getAllGyroscopeData() {
	        
	        Query q = em.createQuery("Select g from GyroscopeData g");
	        List<GyroscopeData> results = q.getResultList();
	       
	        return results;
	    }
	    
	    

	    
	    
	
//*******@AR*******AccelerometerData under MotionSensorData*************************************************************************************************
	    
	    @RequestMapping(value = "/createAccelerometerData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public AccelerometerData createAccelerometerData(@RequestBody @Valid AccelerometerData accelerometerData) {
				
	    	GeographicLocation gLocation = em.find(GeographicLocation.class, accelerometerData.getLocationOfDevice().getGeographicLocationID());
	    	accelerometerData.setLocationOfDevice(gLocation);
		 	   
		 	SensorModule parentSensorModule = em.find(SensorModule.class, accelerometerData.getParentSensorModule().getSensorModuleID());
		 	accelerometerData.setParentSensorModule(parentSensorModule);
	    	
	    	em.persist(accelerometerData);
	    	
	    	em.persist(accelerometerData);
				
			return accelerometerData;
			
		 }
	    
	    
	    //Find Sensor Data
	    @RequestMapping(value="/getAccelerometerData/{accelerometerDataID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public AccelerometerData getAccelerometerData(@PathVariable("accelerometerDataID") Long accelerometerDataID) {
	        
	    	
	    	
	    	AccelerometerData accelerometerData = em.find(AccelerometerData.class, accelerometerDataID);
	        
	      
	        return accelerometerData;
	    }
	    
		  //Delete Sensor Data
	    @RequestMapping(value = "/deleteAccelerometerData/{accelerometerDataID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deleteAccelerometerData(@PathVariable("accelerometerDataID") Long accelerometerDataID)  {
	    	
	    	
	    	AccelerometerData accelerometerData = em.find(AccelerometerData.class, accelerometerDataID);
	    	
	    	em.remove(accelerometerData);
	    }

	    
	    //List all SensorData
	    @RequestMapping(value="/getAllAccelerometerData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<AccelerometerData> getAllAccelerometerData() {
	        
	        Query q = em.createQuery("Select a from AccelerometerData a");
	        List<AccelerometerData> results = q.getResultList();
	       
	        return results;
	    }
	    
	    
//*********@AR****HeartRateData Under BiometricSensorData*************************************
	    
	    @RequestMapping(value = "/createHeartRateData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public HeartRateData createHeartRateData(@RequestBody @Valid HeartRateData heartRateData) {
				
	    	GeographicLocation gLocation = em.find(GeographicLocation.class, heartRateData.getLocationOfDevice().getGeographicLocationID());
	    	heartRateData.setLocationOfDevice(gLocation);
		 	   
		 	SensorModule parentSensorModule = em.find(SensorModule.class, heartRateData.getParentSensorModule().getSensorModuleID());
		 	heartRateData.setParentSensorModule(parentSensorModule);
	    	
	    	em.persist(heartRateData);
				
			return heartRateData;
			
		 }
	    
	    //Find Sensor Data
	    @RequestMapping(value="/getHeartRateData/{heartRateDataID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public HeartRateData getHeartRateData(@PathVariable("heartRateDataID") Long heartRateDataID) {
	        
	    	
	    	HeartRateData heartRateData = em.find(HeartRateData.class, heartRateDataID);
	        
	      
	        return heartRateData;
	    }
	    
	    //List all SensorData
	    @RequestMapping(value="/getAllHeartRateData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<HeartRateData> getAllHeartRateData() {
	        
	        Query q = em.createQuery("Select h from HeartRateData h");
	        List<HeartRateData> results = q.getResultList();
	       
	        return results;
	    }
	   
	  //Delete Sensor Data
	    @RequestMapping(value = "/deleteHeartRateData/{heartRateDataID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deleteHeartRateData(@PathVariable("heartRateDataID") Long heartRateDataID)  {
	    	
	    	
	    	HeartRateData heartRateData = em.find(HeartRateData.class, heartRateDataID);
	    	
	    	em.remove(heartRateData);
	    }
	    
	   
	    
	    
//*********@AR****HydrationData Under BiometricSensorData*************************************
	    
	    @RequestMapping(value = "/createHydrationData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public HydrationData createHydrationData(@RequestBody @Valid HydrationData hydrationData) {
				
	    	GeographicLocation gLocation = em.find(GeographicLocation.class, hydrationData.getLocationOfDevice().getGeographicLocationID());
	    	hydrationData.setLocationOfDevice(gLocation);
		 	   
		 	SensorModule parentSensorModule = em.find(SensorModule.class, hydrationData.getParentSensorModule().getSensorModuleID());
		 	hydrationData.setParentSensorModule(parentSensorModule);
	    	
	    	em.persist(hydrationData);
				
			return hydrationData;
			
		 }
	    
	    //Find Sensor Data
	    @RequestMapping(value="/getHydrationData/{hydrationDataID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public HydrationData getHydrationData(@PathVariable("hydrationDataID") Long hydrationDataID) {
	        
	    	
	    	HydrationData hydrationData = em.find(HydrationData.class, hydrationDataID);
	        
	      
	        return hydrationData;
	    }
	    
	    
	    //List all SensorData
	    @RequestMapping(value="/getAllHydrationData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<HydrationData> getAllHydrationData() {
	        
	        Query q = em.createQuery("Select h from HydrationData h");
	        List<HydrationData> results = q.getResultList();
	       
	        return results;
	    }
	   
	    
		 //Delete Sensor Data
		    @RequestMapping(value = "/deleteHydrationData/{hydrationDataID}",method = RequestMethod.DELETE, produces = "application/json")
		    @ResponseStatus(HttpStatus.NO_CONTENT)
		    @ResponseBody
		    public void deleteHydrationData(@PathVariable("hydrationDataID") Long hydrationDataID)  {
		    	
		    	
		    	HydrationData hydrationData = em.find(HydrationData.class, hydrationDataID);
		    	
		    	em.remove(hydrationData);
		    }
	 
	    
	    
	    
	    
//*********@AR****PulseOximeterData Under BiometricSensorData*************************************
	    
	    @RequestMapping(value = "/createPulseOximeterData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public PulseOximeterData createPulseOximeterData(@RequestBody @Valid PulseOximeterData pulseOximeterData) {
				
	    	GeographicLocation gLocation = em.find(GeographicLocation.class, pulseOximeterData.getLocationOfDevice().getGeographicLocationID());
	    	pulseOximeterData.setLocationOfDevice(gLocation);
		 	   
		 	SensorModule parentSensorModule = em.find(SensorModule.class, pulseOximeterData.getParentSensorModule().getSensorModuleID());
		 	pulseOximeterData.setParentSensorModule(parentSensorModule);
	    	
	    	em.persist(pulseOximeterData);
				
			return pulseOximeterData;
			
		 }
	    
	  //Find Sensor Data
	    @RequestMapping(value="/getPulseOximeterData/{pulseOximeterDataID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public PulseOximeterData getPulseOximeterData(@PathVariable("pulseOximeterDataID") Long pulseOximeterDataID) {
	        
	    	
	    	PulseOximeterData pulseOximeterData = em.find(PulseOximeterData.class, pulseOximeterDataID);
	        
	      
	        return pulseOximeterData;
	    }
	    
	    
	  //List all SensorData
	    @RequestMapping(value="/getAllPulseOximeterData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<PulseOximeterData> getAllPulseOximeterData() {
	        
	        Query q = em.createQuery("Select p from PulseOximeterData p");
	        List<PulseOximeterData> results = q.getResultList();
	       
	        return results;
	    }
	    
	  //Delete Sensor Data
	    @RequestMapping(value = "/deletePulseOximeterData/{pulseOximeterDataID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deletePulseOximeterData(@PathVariable("pulseOximeterDataID") Long pulseOximeterDataID)  {
	    	
	    	
	    	PulseOximeterData pulseOximeterData = em.find(PulseOximeterData.class, pulseOximeterDataID);
	    	
	    	em.remove(pulseOximeterData);
	    }
	 
	    
	    
//*********@AR****ECGData Under BiometricSensorData*************************************
	    
	    @RequestMapping(value = "/createECGData", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public ECGData createECGData(@RequestBody @Valid ECGData ecgData) {
				
	    	GeographicLocation gLocation = em.find(GeographicLocation.class, ecgData.getLocationOfDevice().getGeographicLocationID());
	    	ecgData.setLocationOfDevice(gLocation);
		 	   
		 	SensorModule parentSensorModule = em.find(SensorModule.class, ecgData.getParentSensorModule().getSensorModuleID());
		 	ecgData.setParentSensorModule(parentSensorModule);
	    	
	    	em.persist(ecgData);
				
			return ecgData;
			
		 }
	    
	  //Find Sensor Data
	    @RequestMapping(value="/getECGData/{ecgDataID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public ECGData getECGData(@PathVariable("ecgDataID") Long ecgDataID) {
	        
	    	
	    	ECGData ecgData = em.find(ECGData.class, ecgDataID);
	        
	      
	        return ecgData;
	    }
	    
	    
		 //List all SensorData
	    @RequestMapping(value="/getAllECGData",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<ECGData> getAllECGData() {
	        
	        Query q = em.createQuery("Select e from ECGData e");
	        List<ECGData> results = q.getResultList();
	       
	        return results;
	    }
	    
	    
		 //Delete Sensor Data
	    @RequestMapping(value = "/deleteECGData/{ecgDataID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deleteECGData(@PathVariable("ecgDataID") Long ecgDataID)  {
	    	
	    	
	    	ECGData ecgData = em.find(ECGData.class, ecgDataID);
	    	
	    	em.remove(ecgData);
	    }
	    
	    
//*********@AR****ProximitySensor*************************************    
	    
	    @RequestMapping(value = "/createProximitySensor", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public ProximitySensor createProximitySensor(@RequestBody @Valid ProximitySensor proximitySensor) {
			 	   
		 	SensorModule parentSensorModule = em.find(SensorModule.class, proximitySensor.getParentSensorModule().getSensorModuleID());
		 	proximitySensor.setParentSensorModule(parentSensorModule);
		 	
			em.persist(proximitySensor);
			
			return proximitySensor;
		
	    }
	    
		 //Find Sensor Data
	    @RequestMapping(value="/getProximitySensor/{proximitySensorID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public ProximitySensor getProximitySensor(@PathVariable("proximitySensorID") Long proximitySensorID) {
	        
	    	
	    	ProximitySensor proximitySensor = em.find(ProximitySensor.class, proximitySensorID);
	        
	      
	        return proximitySensor;
	    }
	    
		 //List all SensorData
	    @RequestMapping(value="/getAllProximitySensor",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<ProximitySensor> getProximitySensor() {
	        
	        Query q = em.createQuery("Select p from ECGData p");
	        List<ProximitySensor> results = q.getResultList();
	       
	        return results;
	    }
	    
	  //Delete Sensor Data
	    @RequestMapping(value = "/deleteProximitySensor/{proximitySensorID}",method = RequestMethod.DELETE, produces = "application/json")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @ResponseBody
	    public void deleteProximitySensor(@PathVariable("proximitySensorID") Long proximitySensorID)  {
	    	
	    	
	    	ProximitySensor proximitySensor = em.find(ProximitySensor.class, proximitySensorID);
	    	
	    	em.remove(proximitySensor);
	    }
	

//*****@AR****Gateway***********************************************************************
	   	    
	   	    
	    @RequestMapping(value = "/createGateway", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	   	@ResponseStatus (HttpStatus.CREATED)
	   	@ResponseBody
	   	public Gateway createGateway(@RequestBody @Valid Gateway gateway) {
	   				
	       	em.persist(gateway);
	   				
	   		return gateway;
	   			
	   	 }
	    
	    
	    //-- needed to add get and delete methods.

 //*****@AR****GatewayOperationalStatus***********************************************************************
	    
	    
	    @RequestMapping(value = "/createGatewayOperationalStatus", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public GatewayOperationalStatus createGatewayOperationalStatus(@RequestBody @Valid GatewayOperationalStatus gatewayOperationalStatus) {
				
	    	em.persist(gatewayOperationalStatus);
				
			return gatewayOperationalStatus;
			
		 }
	    
	    @RequestMapping(value="/getAllGatewayOperationalStatus",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<GatewayOperationalStatus> getAllGatewayOperationalStatus() {
	        
	        Query q = em.createQuery("Select g from GatewayOperationalStatus g");
	        List<GatewayOperationalStatus> results = q.getResultList();
	       
	        return results;
	    }

	    
	    //-- needed to add get and delete methods.
	    
	    
	  //*****@AR****SensorModuleOperationalStatus***********************************************************************
	    
	    @RequestMapping(value = "/createSensorModuleOperationalStatus", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public SensorModuleOperationalStatus createSensorModuleOperationalStatus(@RequestBody @Valid SensorModuleOperationalStatus sensorModuleOperationalStatus) {
				
	    	em.persist(sensorModuleOperationalStatus);
				
			return sensorModuleOperationalStatus;
			
	    }
	    
	    @RequestMapping(value="/getSensorModuleOperationalStatus/{sensorModuleOperationalStatusID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public SensorModuleOperationalStatus getSensorModuleOperationalStatus(@PathVariable("sensorModuleOperationalStatusID") Long sensorModuleOperationalStatusID) {
	        
	    	
	    	SensorModuleOperationalStatus sensorModuleOperationalStatus = em.find(SensorModuleOperationalStatus.class, sensorModuleOperationalStatusID);
	        
	      
	        return sensorModuleOperationalStatus;
	    }
	    
	    @RequestMapping(value="/getAllSensorModuleOperationalStatus",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<SensorModuleOperationalStatus> getSensorModuleOperationalStatus() {
	        
	        Query q = em.createQuery("Select s from SensorModuleOperationalStatus s");
	        List<SensorModuleOperationalStatus> results = q.getResultList();
	       
	        return results;
	    }
	    
	    
	     //-- needed to add get and delete methods.
	    
	    
	    
	  //******@AR*****SensorOperationalStatus****************************************
	    
	   /* @RequestMapping(value = "/createSensorOperationalStatus", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public SensorOperationalStatus createSensorOperationalStatuss(@RequestBody @Valid SensorOperationalStatus sensorOperationalStatus) {
				
	    	em.persist(sensorOperationalStatus);
				
			return sensorOperationalStatus;
			
	    }
	    
	    */
	    
	    //-- need to add all methods
	    
	    
	    
	  //******@AR*****CorporateEntity****************************************
	    
	    
	    @RequestMapping(value = "/createCorporateEntity", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public CorporateEntity createCorporateEntity(@RequestBody @Valid CorporateEntity corporateEntity) {
			
	    	em.persist(corporateEntity);
				
			return corporateEntity;
			
	    }
	    
	
	    @RequestMapping(value="/getCorporateEntity/{corporateEntityID}",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public CorporateEntity getCorporateEntity(@PathVariable("corporateEntityID") Long corporateEntityID) {
	        
	    	
	    	CorporateEntity corporateEntity = em.find(CorporateEntity.class, corporateEntityID);
	        
	      
	        return corporateEntity;
	    }
	    
	    
	    @RequestMapping(value="/getAllCorporateEntity",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<CorporateEntity> getAllCorporateEntity() {
	        
	        Query q = em.createQuery("Select c from CorporateEntity c");
	        List<CorporateEntity> results = q.getResultList();
	       
	        return results;
	    }
	    
	   //********@AR******FireDepartment of CorporateEntity**************************************************
	    
	    @RequestMapping(value = "/createFireDepartment", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public FireDepartment createFireDepartment(@RequestBody @Valid FireDepartment fireDepartment) {
				
	    	CorporateEntity corporateEntity = em.find(CorporateEntity.class, fireDepartment.getBelongsTo().getCorporateEntityID());
	    	fireDepartment.setBelongsTo(corporateEntity);
	    	
	    	em.persist(fireDepartment);
				
			return fireDepartment;
			
	    }
	    

	    @RequestMapping(value="/getAllFireDepartment",method = RequestMethod.GET,  produces = "application/json")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public  List<FireDepartment> getAllFireDepartment() {
	        
	        Query q = em.createQuery("Select f from FireDepartment f");
	        List<FireDepartment> results = q.getResultList();
	       
	        return results;
	    }
	    
	    
	   //----------need get and delete methods.
	    
	    
      //********@AR******FireStation of CorporateEntity**************************************************
	    
	    @RequestMapping(value = "/createFireStation", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public FireStation createFireStation(@RequestBody @Valid FireStation fireStation) {
				
	    	em.persist(fireStation);
				
			return fireStation;
	    
	    }
	 //----------need get and delete methods.

    //********@AR******Hospital of CorporateEntity**************************************************
	    
	    @RequestMapping(value = "/createHospital", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public Hospital createHospital(@RequestBody @Valid Hospital hospital) {
				
	    	em.persist(hospital);
				
			return hospital;
	    
	    }
	 //----------need get and delete methods.

	  //********@AR******Refinery************************************************** 
	    
	    @RequestMapping(value = "/createRefinery", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public Refinery createRefinery(@RequestBody @Valid Refinery refinery) {
				
	    	em.persist(refinery);
				
			return refinery;
	    
	    }
	    
	    
	  //----------need get and delete methods.
	    
	 
	    
	  //********@AR******PlantArea of Refinery************************************************** 
	    
	    @RequestMapping(value = "/createPlantArea", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public PlantArea createPlantArea(@RequestBody @Valid PlantArea plantArea) {
				
	    	em.persist(plantArea);
				
			return plantArea;
	    
	    }
	    
	    
	  //----------need get and delete methods.
	    
	    
	    
	  //********@AR******PrimaryOperatingUnit of Refinery************************************************** 
	    
	    @RequestMapping(value = "/createPrimaryOperatingUnit", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		@ResponseStatus (HttpStatus.CREATED)
		@ResponseBody
		public PrimaryOperatingUnit createPrimaryOperatingUnit(@RequestBody @Valid PrimaryOperatingUnit primaryOperatingUnit) {
				
	    	em.persist(primaryOperatingUnit);
				
			return primaryOperatingUnit;
	    
	    }
	    
	    
	  //----------need get and delete methods.
	    
	    
	    
    //********@AR******SecondaryOperatingUnit of Refinery************************************************** 
		    
		    @RequestMapping(value = "/createSecondaryOperatingUnit", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
			@ResponseStatus (HttpStatus.CREATED)
			@ResponseBody
			public SecondaryOperatingUnit createSecondaryOperatingUnit(@RequestBody @Valid SecondaryOperatingUnit secondaryOperatingUnit) {
					
		    	em.persist(secondaryOperatingUnit);
					
				return secondaryOperatingUnit;
		    
		    }
		    
		    
	//----------need get and delete methods.
		    
   //********@AR*****************FirstResponderBodySuitGateway*************************************** 	    
   
		    @RequestMapping(value = "/createFirstResponderBodySuitGateway", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
			@ResponseStatus (HttpStatus.CREATED)
			@ResponseBody
			public FirstResponderBodySuitGateway createFirstResponderBodySuitGateway(@RequestBody @Valid FirstResponderBodySuitGateway firstResponderBodySuitGateway) {
					
		    	em.persist(firstResponderBodySuitGateway);
					
				return firstResponderBodySuitGateway;
		    
		    }
		    
		    
		    @RequestMapping(value="/getFirstResponderBodySuitGateway/{firstResponderBodySuitGatewayID}",method = RequestMethod.GET,  produces = "application/json")
		    @ResponseStatus(HttpStatus.OK)
		    @ResponseBody
		    public FirstResponderBodySuitGateway getFirstResponderBodySuitGateway(@PathVariable("firstResponderBodySuitGatewayID") Long firstResponderBodySuitGatewayID) {
		        
		    	
		    	FirstResponderBodySuitGateway firstResponderBodySuitGateway = em.find(FirstResponderBodySuitGateway.class, firstResponderBodySuitGatewayID);
		        
		      
		        return firstResponderBodySuitGateway;
		    }
		    
		    @RequestMapping(value="/getAllFirstResponderBodySuitGateway",method = RequestMethod.GET,  produces = "application/json")
		    @ResponseStatus(HttpStatus.OK)
		    @ResponseBody
		    public  List<FirstResponderBodySuitGateway> getAllFirstResponderBodySuitGateway() {
		        
		        Query q = em.createQuery("Select s from FirstResponderBodySuitGateway s");
		        List<FirstResponderBodySuitGateway> results2 = q.getResultList();
		       
		        return results2;
		    }

		  //----------need get and delete methods.    
		    
    //********@AR*****************Battery*************************************** 	    
		    
		  @RequestMapping(value = "/createBattery", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		  @ResponseStatus (HttpStatus.CREATED)
		  @ResponseBody
		  public Battery createBattery(@RequestBody @Valid Battery battery) {
		 					
		      	em.persist(battery);
		 					
		  		return battery;
		 		    
		 		    }
		
		 		    
		 		  //----------need get and delete methods.    
		  
	//********@AR*****************MobileResponseVehicleGateway*************************************** 	    
		   
		    @RequestMapping(value = "/createMobileResponseVehicleGateway", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
			@ResponseStatus (HttpStatus.CREATED)
			@ResponseBody
			public MobileResponseVehicleGateway createMobileResponseVehicleGateway(@RequestBody @Valid MobileResponseVehicleGateway mobileResponseVehicleGateway) {
					
		    	em.persist(mobileResponseVehicleGateway);
					
				return mobileResponseVehicleGateway;
		    
		    }
		 
		    
		    @RequestMapping(value="/getAllMobileResponseVehicleGateway",method = RequestMethod.GET,  produces = "application/json")
		    @ResponseStatus(HttpStatus.OK)
		    @ResponseBody
		    public  List<MobileResponseVehicleGateway> getAllMobileResponseVehicleGateway() {
		        
		        Query q = em.createQuery("Select m from MobileResponseVehicleGateway m");
		        List<MobileResponseVehicleGateway> results = q.getResultList();
		       
		        return results;
		    }

		    
		  //----------need get and delete methods.    
		    
		    
	//********@AR*****************Mine*************************************** 	    
			   
		    @RequestMapping(value = "/createMine", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
			@ResponseStatus (HttpStatus.CREATED)
			@ResponseBody
			public Mine createMine(@RequestBody @Valid Mine mine) {
					
		    	em.persist(mine);
					
				return mine;
		    
		    }
		    
		  //----------need get and delete methods.   
		    
    //********@AR*****************Wristband***************************************
		    
		    @RequestMapping(value = "/createWristband", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
			@ResponseStatus (HttpStatus.CREATED)
			@ResponseBody
			public Wristband createWristband(@RequestBody @Valid Wristband wristband) {
					
		    	em.persist(wristband);
					
				return wristband;
		    
		    }
		    
		  //----------need get and delete methods.
		    
//********@AR*****************UnmanagedEquipment***************************************
		    
		    @RequestMapping(value = "/createEquipment", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
			@ResponseStatus (HttpStatus.CREATED)
			@ResponseBody
			public UnmanagedEquipment createEquipment(@RequestBody @Valid UnmanagedEquipment unmanagedEquipment) {
					
		    	CorporateEntity corporateEntity = em.find(CorporateEntity.class, unmanagedEquipment.getBelongsTo().getCorporateEntityID());
		    	unmanagedEquipment.setBelongsTo(corporateEntity);
		    	
		    	GeographicLocation gLocation = em.find(GeographicLocation.class, unmanagedEquipment.getCurrentlyLocatedAt().getGeographicLocationID());
		        unmanagedEquipment.setCurrentlyLocatedAt(gLocation);
		    	
		    	em.persist(unmanagedEquipment);
			
				return unmanagedEquipment;
		    
		    }
		    
		  //----------need get and delete methods.
//********@AR*****************MobileResponseVehicle***************************************
		    
		    @RequestMapping(value = "/createMobileResponseVehicle", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
			@ResponseStatus (HttpStatus.CREATED)
			@ResponseBody
			public MobileResponseVehicle createMobileResponseVehicle(@RequestBody @Valid MobileResponseVehicle mobileResponseVehicle) {
				
		    	
		    	em.persist(mobileResponseVehicle);
			
				return mobileResponseVehicle;
		    
		    }
		    
		  //----------need get and delete methods.
		    
		    
//********@AR*****************NotificationAlertMessage***************************************
		    
		    @RequestMapping(value = "/createNotificationAlertMessage", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
			@ResponseStatus (HttpStatus.CREATED)
			@ResponseBody
			public NotificationAlertMessage createNotificationAlertMessage(@RequestBody @Valid NotificationAlertMessage notificationAlertMessage) {
				
		    	UnmanagedEquipment unmanagedEquipment = em.find(UnmanagedEquipment.class, notificationAlertMessage.getAlertForUnmanagedEquipment().getEquipmentTagID());
		    	notificationAlertMessage.setAlertForUnmanagedEquipment(unmanagedEquipment);
		    	
		    	Incident incident = em.find(Incident.class, notificationAlertMessage.getAlertForIncident().getIncidentID());
		    	notificationAlertMessage.setAlertForIncident(incident);
		    	
		    	em.persist(notificationAlertMessage);
			
				return notificationAlertMessage;
		    
		    }
		    
		  //----------need get and delete methods.
		    
	//************************@@@@@@@@END MARKING@@@@@@@@****************************
}
