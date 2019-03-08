package com.chainsys.movieapplication.validation;

import com.chainsys.movieapplication.exception.InvalidRegisterException;
import com.chainsys.movieapplication.model.Register;

public class RegisterValidation {
	public void RegisterValidator(Register register) throws Exception{
		if (register.getName()==null || register.getName().equalsIgnoreCase("null") || 
				register.getName().trim().isEmpty()) {
			throw new InvalidRegisterException("Invalid Name");
		}
		if (register.getEmail()==null || register.getEmail().equalsIgnoreCase("null") || 
				register.getEmail().trim().isEmpty()) {
			throw new InvalidRegisterException("Invalid Email");
		}
		if (register.getPassword()== null || register.getPassword().equalsIgnoreCase("null") ||
				register.getPassword().trim().isEmpty()) {
			throw new InvalidRegisterException("Invalid Password");
		}
		if (register.getPhonenumber()==null) {
			throw new InvalidRegisterException("Invalid Phone number");
		}
	}
}
