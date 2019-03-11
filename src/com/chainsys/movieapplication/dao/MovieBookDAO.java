package com.chainsys.movieapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.movieapplication.model.MovieInTheater;
import com.chainsys.movieapplication.util.ConnectionUtil;

public class MovieBookDAO {
	public void addMovieBook(MovieInTheater movieintheater) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into booking(id,register_id,movieintheater_id,seats,amount,screen)values(seq_booking_id.NEXTVAL,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
