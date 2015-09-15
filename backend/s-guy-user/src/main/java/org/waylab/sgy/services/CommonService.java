package org.waylab.sgy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.waylab.sgy.domain.RegisteredUser;
import org.waylab.sgy.repositories.mongo.RegisteredUserMongoDbRepository;
import org.waylab.sgy.services.exception.ContentsNotExistException;

public abstract class CommonService {

	@Autowired
	protected RegisteredUserMongoDbRepository registeredUserRepository;

	public boolean isValidPassword(String emailAddress, String password){
		RegisteredUser target = registeredUserRepository.findByEmailAddress(emailAddress);
		if(target == null){
			throw new ContentsNotExistException("User is not existed", null);
		}else if(password.equals(target.getPassword())){
			return true;
		}else{
			return false;
		}
	}

}
