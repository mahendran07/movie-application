package com.chainsys.movieapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.movieapplication.model.Register;
import com.chainsys.movieapplication.util.ConnectionUtil;

public class RegisterDAO {
	public void addUser(Register register) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into register(id,name,email,phonenumber,password,status) values(seq_register_id.NEXTVAL,?,?,?,?,?)";
			PreparedStatement preparedstatement = connection
					.prepareStatement(sql);
			preparedstatement.setString(1, register.getName());
			preparedstatement.setString(2, register.getEmail());
			preparedstatement.setLong(3, register.getPhonenumber());
			preparedstatement.setString(4, register.getPassword());
			preparedstatement.setInt(5, register.getStatus());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void changePassword(Register register)
			throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "UPDATE register SET password=? WHERE email=?";
			PreparedStatement preparedstatement = connection
					.prepareStatement(sql);
			preparedstatement.setString(1, register.getPassword());
			preparedstatement.setString(2, register.getEmail());
			int rows=preparedstatement.executeUpdate();
			System.out.println(rows);
			ConnectionUtil.close(connection, preparedstatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Register checkLogin(Register register) {
		//int status=0;
		Register registration = new Register();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select id,name,email,phonenumber,password,status from register where email=? and password=?";
			PreparedStatement preparedstatement = connection
					.prepareStatement(sql);
			preparedstatement.setString(1, register.getEmail());
			preparedstatement.setString(2, register.getPassword());
			ResultSet resultSet=preparedstatement.executeQuery();
			if(resultSet.next())
			{
				registration=new Register();
				registration.setName(resultSet.getString("name"));
				registration.setEmail(resultSet.getString("email"));
				registration.setPhonenumber(resultSet.getLong("phonenumber"));
				registration.setPassword(resultSet.getString("password"));
				registration.setStatus(resultSet.getInt("status"));
			}
			ConnectionUtil.close(connection, preparedstatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registration;
	}
	
	public Register findByEmail(String Email) throws SQLException
	{
		Register register=new Register();
		Connection connection=ConnectionUtil.getConnection();
		String sql="select id,name,email,password,phonenumber from register where email=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, Email);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			register=new Register();
			register.setName(resultSet.getString("name"));
			register.setEmail(resultSet.getString("email"));
			register.setPassword(resultSet.getString("password"));
			register.setPhonenumber(resultSet.getLong("phonenumber"));
		}
		return register;
	}
	
	public Boolean checkByEmailorPassword(String Email,String password) throws SQLException
	{
		Boolean isActive=false;
		Connection connection=ConnectionUtil.getConnection();
		String sql="select password from register where email=? or password=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, Email);
		preparedStatement.setString(2, password);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			isActive=true;
		}
		return isActive;
	}
	
	public Boolean checkByEmailPassword(String Email,String password) throws SQLException
	{
		Boolean isActive=false;
		Connection connection=ConnectionUtil.getConnection();
		String sql="select id,name,email,password,phonenumber from register where email=? and password=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, Email);
		preparedStatement.setString(2, password);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			isActive=true;
		}
		return isActive;
	}
	
	public Boolean checkForgetPassword(Register register)
	{
		Boolean isActive=false;
		try {
			Connection connection=ConnectionUtil.getConnection();
			String sql="select name,email,phonenumber from register where name=? and email=? and phonenumber=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, register.getName());
			preparedStatement.setString(2, register.getEmail());
			preparedStatement.setLong(3, register.getPhonenumber());
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				isActive=true;
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isActive;
	}
}
