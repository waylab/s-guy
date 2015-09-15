package org.waylab.sgy.services;

import org.waylab.sgy.domain.RegisteredUser;
import org.waylab.sgy.domain.UserId;
import org.waylab.sgy.web.facade.dto.RegistrationRequest;

/**
 * Cargo Tracker Management Portal's User Resgistration service
 * @author Hahn
 */
public interface RegistrationService {

	String registerNewUser(RegisteredUser registeredUser);

	void withdrawalUser(RegisteredUser registeredUser);

	RegisteredUser isRegistered(String emailAddress);
	
}
