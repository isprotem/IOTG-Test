/**
 * 
 */
package com.intel.grs.first.responder.ui;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import firstResponderModel.GeographicLocation;

/**
 * @author yschauhx
 *
 */
@RestController
public class LocationController  {

		
	GeographicLocation location;
	@RequestMapping(value="/location", 
            method=RequestMethod.GET,produces={"application/json"}) 
    @ResponseStatus(HttpStatus.OK) 
	public 	GeographicLocation getActivePersonalLocation(){
		GeographicLocation location=new GeographicLocation();
		location.setAddress1("address1");
		return location;
	}
		
}
