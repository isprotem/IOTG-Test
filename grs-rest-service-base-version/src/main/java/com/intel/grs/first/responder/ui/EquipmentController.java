/**
 * 
 */
package com.intel.grs.first.responder.ui;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.intel.grs.first.responder.ui.model.EquipmentModel;

import firstResponderModel.Application;
import firstResponderModel.FirstResponder;
import firstResponderModel.SensorModule;

/**
 * @author yschauhx
 *
 */
@RestController
public class EquipmentController {

	//private String persistentUnit = Application.ARGS[0];
	   
    /*
     * Creating EntityManagerFactory and EntityManager for the specific persistence unit
     */

	//EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistentUnit);
    EntityManager em = Application.em;
	
	//List all FirstResponders
    @RequestMapping(value="/getEquipments",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public  List<EquipmentModel> getEquipments() {
       // results.add(arg0)
    	Query q = em.createQuery("Select s from SensorModule s");
        List<SensorModule> results = q.getResultList();
        return getEquipmentsModel(results);
    }
    
    private List<EquipmentModel> getEquipmentsModel(List<SensorModule> sensorModules){
    	List<EquipmentModel> results=new ArrayList<EquipmentModel>();
    	for (SensorModule sensorModule : sensorModules) {
    		EquipmentModel model= new EquipmentModel(sensorModule.getSensorModuleID(),
    				sensorModule.getDeviceName(), sensorModule.getMcuType(),
    				sensorModule.getDeviceModel(), 
    				"1/14/2018", sensorModule.isActive() ? "Active" : "Incative" ); //TODO lastDeployedDate is not available in SensorMudule
    		
            results.add(model);
		}
    	
        return results;
    }

}
