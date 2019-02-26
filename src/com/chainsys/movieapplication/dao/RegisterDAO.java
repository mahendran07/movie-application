package com.chainsys.movieapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.movieapplication.model.Register;
import com.chainsys.movieapplication.util.ConnectionUtil;

public class RegisterDAO {
	public void addUser(Register register) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into register(id,name,email,phonenumber,password) values(registeration_id_seq.NEXTVAL,?,?,?,?)";
			PreparedStatement preparedstatement = connection
					.prepareStatement(sql);
			preparedstatement.setString(1, register.getName());
			preparedstatement.setString(2, register.getEmail());
			preparedstatement.setLong(3, register.getPhonenumber());
			preparedstatement.setString(4, register.getPassword());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void changePassword(Register register, String newpassword)
			throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "UPDATE register SET password=? WHERE email=? and password=?";
			PreparedStatement preparedstatement = connection
					.prepareStatement(sql);
			preparedstatement.setString(1, newpassword);
			preparedstatement.setString(2, register.getEmail());
			preparedstatement.setString(3, register.getPassword());
			preparedstatement.executeUpdate();
			ConnectionUtil.close(connection, preparedstatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Register checkLogin(Register register) {
		Register registration = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select email,password from register where email=? and password=?";
			PreparedStatement preparedstatement = connection
					.prepareStatement(sql);
			preparedstatement.setString(1, register.getEmail());
			preparedstatement.setString(2, register.getPassword());
			preparedstatement.executeUpdate();
			ConnectionUtil.close(connection, preparedstatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registration;
	}

}
