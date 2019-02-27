package com.chainsys.movieapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.util.ConnectionUtil;

public class TheaterDAO {
	public void addTheater(Theater theater) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into theaterdetail(id,name,place,amount)values(seq_movie_id.NEXTVAL,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, theater.getName());
			preparedStatement.setString(2, theater.getPlace());
			preparedStatement.setInt(3, theater.getAmount());
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Theater> findAll() throws SQLException {
		ArrayList<Theater> theaterList = new ArrayList<>();

		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name,place,amount FROM theaterdetail";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		theaterList = new ArrayList<>();
		while (resultset.next()) {
			Theater theater = new Theater();
			theater.setId(resultset.getInt("id"));
			theater.setName(resultset.getString("name"));
			theater.setPlace(resultset.getString("place"));
			theater.setAmount(resultset.getInt("amount"));
			theaterList.add(theater);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return theaterList;
	}

	public void deleteMovie(String name,String place) throws SQLException {
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

	public void updateMovie(Theater theater) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "UPDATE moviedetail set amount=? where name=?";
		PreparedStatement preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setInt(1, theater.getAmount());
		int row = preparedstatement.executeUpdate();
		System.out.println("Update :" + row);
		ConnectionUtil.close(connection, preparedstatement, null);

	}

	public Movie findById(int id) throws SQLException {
		Movie movie = null;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name FROM movie where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			movie = new Movie();
			movie.setId(resultset.getInt("id"));
			movie.setName(resultset.getString("name"));
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return movie;
	}
}
