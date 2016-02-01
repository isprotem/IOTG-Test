/**
 * 
 */
package com.intel.grs.first.responder.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yschauhx
 *
 */
@Controller
public class HomeController {

	  @RequestMapping("/index")
	  public String index() {
	    return "index";
	  }
	  
	  @RequestMapping("/myLocation")
	  public String myLocation(Model model) {
	    return "location";
	  }
	  
	  @RequestMapping("/responders")
	  public String listFirstResponders() {
	    return "responders";
	  }
	  
	  @RequestMapping("/equipments")
	  public String equipments() {
	    return "equipments";
	  }
	  
	  @RequestMapping("/lifeCycleManagement")
	  public String lifeCycleManagement() {
	    return "lifeCycleManagement";
	  }
	  
}
