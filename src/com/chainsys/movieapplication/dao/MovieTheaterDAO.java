package com.chainsys.movieapplication.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.MovieInTheater;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.util.ConnectionUtil;

public class MovieTheaterDAO {
	public void addMovieTheater(MovieInTheater movieintheater) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into movieintheater(id,theaterid,movieid,show,showdate,total_ticket)values(seq_movietheater_id.NEXTVAL,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, movieintheater.getTheater().getId());
			preparedStatement.setInt(2, movieintheater.getMovie().getId());
			preparedStatement.setString(3, movieintheater.getShow());
			preparedStatement.setDate(4,Date.valueOf(movieintheater.getDate()));
			preparedStatement.setInt(5, movieintheater.getTotal());
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MovieInTheater> findAll() throws SQLException
	{
		ArrayList<MovieInTheater> movietheaterlist=new ArrayList<MovieInTheater>();
		Connection connection=ConnectionUtil.getConnection();
		String sql="select id,theaterid,movieid,show,showdate,total_ticket from movieintheater";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			MovieInTheater movieintheater=new MovieInTheater();
			TheaterDAO theaterDAO=new TheaterDAO();
			MovieDAO movieDAO=new MovieDAO();
			Theater theater=theaterDAO.findById(resultSet.getInt("theaterid"));
			movieintheater.setTheater(theater);
			Movie movie=movieDAO.findById(resultSet.getInt("movieid"));
			movieintheater.setMovie(movie);
			movieintheater.setShow(resultSet.getString("show"));
			movieintheater.setDate(resultSet.getDate("showdate").toLocalDate());
			movieintheater.setTotal(resultSet.getInt("total_ticket"));
			movietheaterlist.add(movieintheater);
		}
		return movietheaterlist;
	}
}
