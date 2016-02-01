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

import com.intel.grs.first.responder.ui.model.FirstResponderModel;

import firstResponderModel.Application;
import firstResponderModel.FirstResponder;

/**
 * @author yschauhx
 *
 */
@RestController
public class FirstResponderCntroller{

	   

	EntityManager em = Application.em;
	/*@Autowired
	FirstResponderRepository  firstResponderRepository;*/
	
	//List all FirstResponders
    @RequestMapping(value="/firstResponders",method = RequestMethod.GET,  produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public  List<FirstResponderModel> getAllFirstResponders() {
       // results.add(arg0)
    	Query q = em.createQuery("Select f from FirstResponder f");
        List<FirstResponder> results=q.getResultList();
		/*try {
			results = firstResponderRepository.fetchAllFirstResponder();
		} catch (FirstResponderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        return getResponders(results);
    }
    
    private List<FirstResponderModel> getResponders(List<FirstResponder> firstResponders){
    	List<FirstResponderModel> results=new ArrayList<FirstResponderModel>();
    	if(firstResponders!=null){
    		for (FirstResponder firstResponder : firstResponders) {
    			FirstResponderModel model= new FirstResponderModel();
        		model.setId(firstResponder.getFirstResponderID());
        		model.setName(firstResponder.getPersonnelName());
        		model.setGender(firstResponder.getPersonnelGender());
        		model.setPosition(firstResponder.getGlocation().getLocationName());
        		model.setType(firstResponder.getProfessionalSpeciality()); //TODO
        		model.setFireDepartment(firstResponder.getGlocation().getLocationName()); //TODO
        		model.setStatus(firstResponder.isActive()?"Active":"Inactive");
                model.setAge(firstResponder.getPersonnelAge());
                results.add(model);
			}
    	}
        return results;
    }
}
