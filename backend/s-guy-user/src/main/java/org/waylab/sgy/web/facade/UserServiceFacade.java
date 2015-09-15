package org.waylab.sgy.web.facade;

import org.waylab.sgy.web.facade.dto.IsRegistered;
import org.waylab.sgy.web.facade.dto.RegistrationRequest;
import org.waylab.sgy.web.facade.dto.UserAccountRequest;
import org.waylab.sgy.web.facade.dto.UserResponse;
import org.waylab.sgy.web.facade.dto.UsersResponse;


public interface UserServiceFacade {

	UserResponse registerNewUser(RegistrationRequest request);

	void withdrawalUser(UserAccountRequest request);

	IsRegistered isRegistered(String emailAddress);

	UserResponse getUserByEmail(String emailAddress);

	UsersResponse getUsers();

	UsersResponse getUsersByRole(String role);

	UserResponse login(UserAccountRequest request);

	void logout(UserAccountRequest request);

	UserResponse modifyUser(RegistrationRequest request);

	void changePassword(UserAccountRequest request);

}
