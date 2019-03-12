package com.chainsys.movieapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.util.ConnectionUtil;

public class MovieDAO {
	/** this method used to add movie name
	 * @param movie
	 * @throws Exception
	 */
	public void addMovie(Movie movie) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into moviedetail(id,name)values(seq_movie_id.NEXTVAL,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, movie.getName());
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/** this method used to view all movies
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Movie> findAll() throws SQLException {
		ArrayList<Movie> movieList = new ArrayList<>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name FROM moviedetail order by id";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		movieList = new ArrayList<>();
		while (resultset.next()) {
			Movie movie = new Movie();
			movie.setId(resultset.getInt("id"));
			movie.setName(resultset.getString("name"));
			movieList.add(movie);
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return movieList;
	}
	/** this method used delete particular movie
	 * @param name
	 * @throws SQLException
	 */
	public void deleteMovie(String name) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sqldelete = "Delete from moviedetail where name=?";
		PreparedStatement preparedstatement = connection
				.prepareStatement(sqldelete);
		preparedstatement.setString(1, name);
		int row = preparedstatement.executeUpdate();
		System.out.println("Delete record sucessfully :" + row);
		ConnectionUtil.close(connection, preparedstatement, null);
	}
	/** this method used to update a particular movie name
	 * @param movie
	 * @param movienew
	 * @throws SQLException
	 */
	public void updateMovie(Movie movie,Movie movienew) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "UPDATE moviedetail set name=? where name=?";
		PreparedStatement preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setString(1, movienew.getName());
		preparedstatement.setString(2, movie.getName());
		int row = preparedstatement.executeUpdate();
		System.out.println("Update :" + row);
		ConnectionUtil.close(connection, preparedstatement, null);
	}
	/** this method used to find movie with their id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Movie findById(int id) throws SQLException {
		Movie movie = null;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT id,name FROM moviedetail where id=?";
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
	/** this method used to the particular movie name already exists or not
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public Boolean findByName(String name) throws SQLException {
		Boolean isBoolean=false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT name FROM moviedetail where name=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		ResultSet resultset = preparedStatement.executeQuery();
		if (resultset.next()) {
			isBoolean=true;
		}
		ConnectionUtil.close(connection, preparedStatement, null);
		return isBoolean;
	}
}
