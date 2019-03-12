package com.chainsys.movieapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.movieapplication.model.BookMovie;
import com.chainsys.movieapplication.util.ConnectionUtil;

public class MovieBookDAO {	
	/** this method used to add movie book
	 * @param bookMovie
	 * @throws Exception
	 */
	public void addMovieBook(BookMovie bookMovie) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into booking(id,register_id,movieintheater_id,seats,amount,screen)values(seq_booking_id.NEXTVAL,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, bookMovie.getRegister().getId());
			preparedStatement.setInt(2, bookMovie.getMovieInTheater().getId());
			preparedStatement.setInt(3, bookMovie.getSeats());
			preparedStatement.setFloat(4, bookMovie.getAmount());
			preparedStatement.setString(5, bookMovie.getMovieInTheater().getScreen());
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
