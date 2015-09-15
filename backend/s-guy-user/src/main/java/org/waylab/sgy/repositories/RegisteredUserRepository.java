package org.waylab.sgy.repositories;

import java.util.List;

import org.waylab.sgy.domain.RegisteredUser;


public interface RegisteredUserRepository {
	
	RegisteredUser findByEmailAddress(String emailAddress);
	
	List<RegisteredUser> findByRole(String role);
}
