package com.chainsys.movieapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.MovieInTheater;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.util.ConnectionUtil;

public class MovieTheaterDAO {
	public void addMovieTheater(MovieInTheater movieintheater) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into movieintheater(id,theaterid,movieid,show,showdate,total)values(seq_movietheater_id.NEXTVAL,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			Theater theater=new Theater();
			Movie movie=new Movie();
			preparedStatement.setInt(1, theater.getId());
			preparedStatement.setInt(2, movie.getId());
			System.out.println(theater.getId());
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
