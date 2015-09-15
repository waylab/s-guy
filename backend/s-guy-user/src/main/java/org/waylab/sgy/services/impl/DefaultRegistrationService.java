package org.waylab.sgy.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.waylab.sgy.domain.RegisteredUser;
import org.waylab.sgy.repositories.mongo.CompanyMongoDbRepository;
import org.waylab.sgy.services.CommonService;
import org.waylab.sgy.services.RegistrationService;
import org.waylab.sgy.services.exception.PasswordNotValid;

@Service
public class DefaultRegistrationService extends CommonService implements RegistrationService {

	@Autowired
	protected CompanyMongoDbRepository companyRepository;

	@Override
	public String registerNewUser(RegisteredUser registeredUser) {

		String random = UUID.randomUUID().toString().toUpperCase();
		
//		registeredUser.setUserId(new UserId(random.substring(0, random.indexOf("-"))));
		
		companyRepository.save(registeredUser.getCompany());
		
		registeredUserRepository.save(registeredUser);

		return registeredUser.getId();
	}

	public boolean isValidPassword(String emailAddress, String password){
		RegisteredUser target = registeredUserRepository.findByEmailAddress(emailAddress);
		if(target.getPassword().equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public void withdrawalUser(RegisteredUser registeredUser) {
		
		if(isValidPassword(registeredUser.getEmailAddress(), registeredUser.getPassword())){
			RegisteredUser target = registeredUserRepository.findByEmailAddress(registeredUser.getEmailAddress());
			registeredUserRepository.delete(target.getId());
		}else{
			throw new PasswordNotValid("Password is wrong", null);
		}
		
	}

	@Override
	public RegisteredUser isRegistered(String emailAddress) {
		
		RegisteredUser target = registeredUserRepository.findByEmailAddress(emailAddress);
		
		return target;
	}

}
