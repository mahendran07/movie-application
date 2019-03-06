package com.chainsys.movieapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.model.TheaterScreen;
import com.chainsys.movieapplication.util.ConnectionUtil;

public class TheaterScreenDAO {
	public void addScreen(TheaterScreen theaterscreen) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into theaterscreen(id,theaterid,screen,totalseats)values(seq_theaterscreen_id.NEXTVAL,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, theaterscreen.getTheater().getId());
			preparedStatement.setString(2, theaterscreen.getScreen());
			preparedStatement.setInt(3, theaterscreen.getTotalTicket());
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<TheaterScreen> findAll() throws SQLException {
		ArrayList<TheaterScreen> theaterscreenList = new ArrayList<>();

		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,theaterid,screen,totalseats FROM theaterscreen";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset=preparedStatement.executeQuery();
		while (resultset.next()) {
			TheaterScreen theaterscreen=new TheaterScreen();
			TheaterDAO theaterDAO=new TheaterDAO();
			Theater theater=theaterDAO.findById(resultset.getInt("theaterid"));
			theaterscreen.setId(resultset.getInt("id"));
			theaterscreen.setTheater(theater);
			theaterscreen.setScreen(resultset.getString("screen"));
			theaterscreen.setTotalTicket(resultset.getInt("totalseats"));
			theaterscreenList.add(theaterscreen);
			
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return theaterscreenList;
	}
	

	public void deleteTheaterScreen(int theaterid,String screen) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sqldelete = "Delete from theaterscreen where theaterid=? and screen=?";
		PreparedStatement preparedstatement = connection
				.prepareStatement(sqldelete);
		preparedstatement.setInt(1, theaterid);
		preparedstatement.setString(2, screen);
		int row = preparedstatement.executeUpdate();
		System.out.println("Delete record sucessfully :" + row);
		ConnectionUtil.close(connection, preparedstatement, null);
	}

	public void updateTheaterScreen(TheaterScreen theaterscreen) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "UPDATE theaterscreen set totalseats=? where theaterid=? and screen=?";
		PreparedStatement preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setInt(1, theaterscreen.getTotalTicket());
		preparedstatement.setInt(2, theaterscreen.getTheater().getId());
		preparedstatement.setString(3, theaterscreen.getScreen());
		int row = preparedstatement.executeUpdate();
		System.out.println("Update :" + row);
		ConnectionUtil.close(connection, preparedstatement, null);

	}

	public TheaterScreen findById(int id) throws SQLException {
		TheaterScreen theaterScreen=new TheaterScreen();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,theaterid,screen,totalseats FROM theaterscreen where theaterid=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			Theater theater=new Theater();
			TheaterDAO theaterDAO=new TheaterDAO();
			theaterScreen=new TheaterScreen();
			theater=theaterDAO.findById(resultset.getInt("theaterid"));
			theaterScreen.setId(resultset.getInt("id"));
			theaterScreen.setTheater(theater);
			theaterScreen.setScreen(resultset.getString("screen"));
			theaterScreen.setTotalTicket(resultset.getInt("totalseats"));
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return theaterScreen;
	}
	
	public ArrayList<TheaterScreen> findByIdList(int id) throws SQLException {
		ArrayList<TheaterScreen> list=new ArrayList<TheaterScreen>();
		TheaterScreen theaterScreen=null;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,theaterid,screen,totalseats FROM theaterscreen where theaterid=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			Theater theater=new Theater();
			TheaterDAO theaterDAO=new TheaterDAO();
			theaterScreen=new TheaterScreen();
			theater=theaterDAO.findById(resultset.getInt("theaterid"));
			theaterScreen.setId(resultset.getInt("id"));
			theaterScreen.setTheater(theater);
			theaterScreen.setScreen(resultset.getString("screen"));
			theaterScreen.setTotalTicket(resultset.getInt("totalseats"));
			list.add(theaterScreen);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return list;
	}

}
