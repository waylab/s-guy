package org.waylab.sgy.web.controllers.cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.waylab.sgy.web.facade.UserServiceFacade;
import org.waylab.sgy.web.facade.dto.UserCargo;

@RestController
@RequestMapping(value="/cargo")
public class UserCargoController {

	@Autowired
	private UserServiceFacade userServiceFacade;
	
	@RequestMapping(value = {"/accepted"}, method = {RequestMethod.POST})
	@ResponseStatus(HttpStatus.CREATED)
	public void cargoAccepted(@RequestBody UserCargo userCargo){
		
	}
	
	@RequestMapping(value = {"/routed"}, method = {RequestMethod.POST})
	@ResponseStatus(HttpStatus.CREATED)
	public void cargoRouted(@RequestBody UserCargo userCargo){
		
	}
	
	@RequestMapping(value = {"/misrouted"}, method = {RequestMethod.POST})
	@ResponseStatus(HttpStatus.CREATED)
	public void cargoMisrouted(@RequestBody UserCargo userCargo){
		
	}
	
	@RequestMapping(value = {"/completed"}, method = {RequestMethod.POST})
	@ResponseStatus(HttpStatus.CREATED)
	public void cargoCompleted(@RequestBody UserCargo userCargo){
		
	}

}
