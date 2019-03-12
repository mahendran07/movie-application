package com.chainsys.movieapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.util.ConnectionUtil;

public class TheaterDAO {
	/** this method used to add theater details
	 * @param theater
	 * @throws Exception
	 */
	public void addTheater(Theater theater) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into theaterdetail(id,name,place,ownername)values(seq_theater_id.NEXTVAL,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, theater.getName());
			preparedStatement.setString(2, theater.getPlace());
			preparedStatement.setString(3, theater.getOwnername());
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** this method used to view the theater details
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Theater> findAll() throws SQLException {
		ArrayList<Theater> theaterList = new ArrayList<>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name,place,ownername FROM theaterdetail";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		theaterList = new ArrayList<>();
		while (resultset.next()) {
			Theater theater = new Theater();
			theater.setId(resultset.getInt("id"));
			theater.setName(resultset.getString("name"));
			theater.setPlace(resultset.getString("place"));
			theater.setOwnername(resultset.getString("ownername"));
			theaterList.add(theater);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return theaterList;
	}
	/** this method used to delete particular theater details
	 * @param name
	 * @param place
	 * @throws SQLException
	 */
	public void deleteTheater(String name,String place) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sqldelete = "Delete from theaterdetail where name=? and place=?";
		PreparedStatement preparedstatement = connection
				.prepareStatement(sqldelete);
		preparedstatement.setString(1, name);
		preparedstatement.setString(2, place);
		int row = preparedstatement.executeUpdate();
		System.out.println("Delete record sucessfully :" + row);
		ConnectionUtil.close(connection, preparedstatement, null);
	}
	/** this method used to update theater owner name
	 * @param theater
	 * @throws SQLException
	 */
	public void updateTheater(Theater theater) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "UPDATE theaterdetail set ownername=? where name=? and ownername=?";
		PreparedStatement preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setString(1, theater.getOwnername());
		preparedstatement.setString(2, theater.getName());
		preparedstatement.setString(3, theater.getOwnername());
		int row = preparedstatement.executeUpdate();
		System.out.println("Update :" + row);
		ConnectionUtil.close(connection, preparedstatement, null);
	}
	/** this method used to find the theater details in object
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Theater findById(int id) throws SQLException {
		Theater theater = null;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name,place,ownername FROM theaterdetail where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			theater = new Theater();
			theater.setId(resultset.getInt("id"));
			theater.setName(resultset.getString("name"));
			theater.setPlace(resultset.getString("place"));
			theater.setOwnername(resultset.getString("ownername"));
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return theater;
	}	
	/** this method used to find the theater details in list
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Theater> findByIdList(int id) throws SQLException {
		ArrayList<Theater> list=new ArrayList<Theater>();
		Theater theater = null;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name,place,ownername FROM theaterdetail where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			theater = new Theater();
			theater.setId(resultset.getInt("id"));
			theater.setName(resultset.getString("name"));
			theater.setPlace(resultset.getString("place"));
			theater.setOwnername(resultset.getString("ownername"));
			list.add(theater);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return list;
	}
}
