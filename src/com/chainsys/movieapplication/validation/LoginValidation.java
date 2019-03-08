package com.chainsys.movieapplication.validation;

import com.chainsys.movieapplication.exception.InvalidloginException;
import com.chainsys.movieapplication.model.Register;


public class LoginValidation {
	public void loginValidator(Register register) throws Exception {
		if (register.getEmail()==null || register.getEmail().equalsIgnoreCase("null") || 
				register.getEmail().trim().isEmpty()) {
			throw new InvalidloginException("Invalid Email");
		}
		if (register.getPassword()== null || register.getPassword().equalsIgnoreCase("null") ||
				register.getPassword().trim().isEmpty()) {
			throw new InvalidloginException("Invalid Password");
		}
	}
}
