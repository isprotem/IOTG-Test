/**
 * 
 */
package com.intel.grs.first.responder.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.intel.grs.first.responder.ui.model.IncidentModel;
import com.intel.grs.first.responder.ui.model.LifeCycleManagementModel;
import com.intel.grs.first.responder.ui.model.LocationModel;

import firstResponderModel.Application;
import firstResponderModel.GeographicLocation;
import firstResponderModel.Incident;

/**
 * @author yschauhx
 *
 */
@RestController
public class LifeCycleManagementController {

	/**
	 * 
	 */
	public LifeCycleManagementController() {
		// TODO Auto-generated constructor stub
	}

	EntityManager em = Application.em;
	/*@Autowired
	FirstResponderRepository  firstResponderRepository;*/
	
	//List all FirstResponders
    @RequestMapping(value="/getLifeCycleManagementInfo",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public  LifeCycleManagementModel getLifeCycleManagementInfo() {
        return getLifeCycleManagementModel();
    }
    
   
    
    private LifeCycleManagementModel getLifeCycleManagementModel(){
    	LifeCycleManagementModel lifeCycleManagementModel= new LifeCycleManagementModel();
    	IncidentModel incidentModel=new IncidentModel();
    	LocationModel  locationModel=null;
    	Query q = em.createQuery("Select i from Incident i"); //TODO
        List<Incident> results=q.getResultList();
        if(results!=null && results.size()>0){
        	Incident incident=results.get(0);
        	incidentModel.setStartTime(getTime(incident.getIncidentStartTime()));
        	incidentModel.setEndTime(getTime(incident.getIncidentCloseTime()));
        	incidentModel.setIncidentDate(formetDate(incident.getIncidentStartTime()));
        	incidentModel.setIncidentType(incident.getIncidentClassification());
        	incidentModel.setIncidentCommander(incident.getIncidentCommander()); 
        	
        	GeographicLocation  geographicLocation=incident.getGlocation();
        	
        	if(geographicLocation!=null){
        		locationModel=new LocationModel(geographicLocation.getAddress1(),
        				geographicLocation.getCity(), geographicLocation.getState(),
        				geographicLocation.getPostalCode(), geographicLocation.getCountry(), 
        				""+geographicLocation.getLatitude(), ""+geographicLocation.getLongitude());
        	}
        	lifeCycleManagementModel.setIncident(incidentModel);
        	lifeCycleManagementModel.setLocation(locationModel);
        }
	
        return lifeCycleManagementModel;
    }
    
    private String getTime(Date date){
    	String time=null;
    	DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
    	if(date!=null){
    		time=dateFormat.format(date);
    	}
    	return time;
    }
    private String formetDate(Date date){
    	String dateStr=null;
    	DateFormat dateFormat=new SimpleDateFormat("MM/DD/yyyy");
    	if(date!=null){
    		dateStr=dateFormat.format(date);
    	}
    	return dateStr;
    }
}
