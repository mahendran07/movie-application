package com.chainsys.movieapplication.validation;

import com.chainsys.movieapplication.model.Register;


public class LoginValidation {
	public void loginValidator(Register register) throws Exception {
		if (register.getEmail() !=null) {
			throw new Exception("Invalid Email");
		}
		if (register.getPassword() != null) {
			throw new Exception("Invalid Password");
		}
	}
}
