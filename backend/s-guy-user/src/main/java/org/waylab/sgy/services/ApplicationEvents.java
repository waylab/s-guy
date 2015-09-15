package org.waylab.sgy.services;

import org.waylab.sgy.domain.RegisteredUser;

public interface ApplicationEvents {

	void userRegistered(RegisteredUser registeredUser);
}
