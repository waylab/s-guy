package org.waylab.sgy.web.facade.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.waylab.sgy.domain.RegisteredUser;
import org.waylab.sgy.services.LoginService;
import org.waylab.sgy.services.ManagementService;
import org.waylab.sgy.services.RegistrationService;
import org.waylab.sgy.web.facade.UserServiceFacade;
import org.waylab.sgy.web.facade.dto.IsRegistered;
import org.waylab.sgy.web.facade.dto.RegistrationRequest;
import org.waylab.sgy.web.facade.dto.UserAccountRequest;
import org.waylab.sgy.web.facade.dto.UserResponse;
import org.waylab.sgy.web.facade.dto.UsersResponse;
import org.waylab.sgy.web.facade.internal.assembler.RegistrationDtoAssembler;

@Service
public class DefaultRegisterServiceFacade implements UserServiceFacade{

	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private ManagementService managementService;
	
	@Autowired
	private LoginService loginService;
	
//	@Autowired
//	private ApplicationEvents applicationEvents;

	@Override
	public UserResponse registerNewUser(RegistrationRequest request){
		
		RegisteredUser registeredUser = new RegistrationDtoAssembler().fromDto(null, request);
		
		registrationService.registerNewUser(registeredUser);
		
		// AMQP Message Publish
//		applicationEvents.userRegistered(registeredUser);
		
		return new RegistrationDtoAssembler().toDto(registeredUser); 
	}

	@Override
	public void withdrawalUser(UserAccountRequest request) {

		registrationService.withdrawalUser(new RegistrationDtoAssembler().fromDtoUserAccount(request));
	}

	@Override
	public IsRegistered isRegistered(String emailAddress) {
		
		RegisteredUser registeredUser = registrationService.isRegistered(emailAddress);
		
		IsRegistered isRegistered = new RegistrationDtoAssembler().toDtoIsRegistered(registeredUser);
		
		return isRegistered;
	}

	@Override
	public UserResponse getUserByEmail(String emailAddress) {
		
		RegisteredUser registeredUser = managementService.getUserByEmailAddress(emailAddress);
		
		return new RegistrationDtoAssembler().toDto(registeredUser);
	}

	@Override
	public UsersResponse getUsers() {
		
		List<RegisteredUser> registeredUserList = managementService.getUserList();
		
		return new RegistrationDtoAssembler().listToDto(registeredUserList);
	}

	@Override
	public UsersResponse getUsersByRole(String role) {
		return null;
		
	}

	@Override
	public UserResponse login(UserAccountRequest request) {

		RegisteredUser registeredUser = loginService.login(new RegistrationDtoAssembler().fromDtoUserAccount(request));
		return new RegistrationDtoAssembler().toDto(registeredUser);
	}

	@Override
	public void logout(UserAccountRequest request) {

		loginService.logout(new RegistrationDtoAssembler().fromDtoUserAccount(request));
		
	}

	@Override
	public UserResponse modifyUser(RegistrationRequest request) {
		
		RegisteredUser registeredUser = new RegistrationDtoAssembler().fromDto(null, request);
	
		managementService.modifyUser(registeredUser);
	
		
		return new RegistrationDtoAssembler().toDto(registeredUser);
	}

	@Override
	public void changePassword(UserAccountRequest request) {
		
		RegisteredUser registeredUser = new RegistrationDtoAssembler().fromDtoUserAccount(request);
	
		managementService.changePassword(registeredUser);
	}
}
