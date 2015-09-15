package org.waylab.sgy.services;

import org.waylab.sgy.domain.RegisteredUser;


/**
 * Cargo Tracker Management Portal's User Login service
 * @author Hahn
 */
public interface LoginService {

	RegisteredUser login(RegisteredUser userAccount);

	void logout(RegisteredUser userAccount);
	
}
