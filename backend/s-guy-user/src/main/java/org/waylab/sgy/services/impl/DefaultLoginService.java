package org.waylab.sgy.services.impl;

import org.springframework.stereotype.Service;
import org.waylab.sgy.domain.RegisteredUser;
import org.waylab.sgy.services.CommonService;
import org.waylab.sgy.services.LoginService;
import org.waylab.sgy.services.exception.PasswordNotValid;

@Service
public class DefaultLoginService extends CommonService implements LoginService{

	@Override
	public RegisteredUser login(RegisteredUser userAccount) {
		RegisteredUser registeredUser = null;
		if(isValidPassword(userAccount.getEmailAddress(), userAccount.getPassword())){
			registeredUser = registeredUserRepository.findByEmailAddress(userAccount.getEmailAddress());
			// lastLogedin Time Update
			registeredUserRepository.save(registeredUser);
		}else{
			throw new PasswordNotValid("Password is wrong", null);
		}
		return registeredUser;
	}

	@Override
	public void logout(RegisteredUser userAccount) {
		//Token 만료
	}

}
