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
import com.chainsys.movieapplication.model.TheaterScreen;
import com.chainsys.movieapplication.util.ConnectionUtil;

public class MovieTheaterDAO {
	public void addMovieTheater(MovieInTheater movieintheater) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into movieintheater(id,theaterid,movieid,show,showdate,screen_no,amount)values(seq_movietheater_id.NEXTVAL,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, movieintheater.getTheater().getId());
			preparedStatement.setInt(2, movieintheater.getMovie().getId());
			preparedStatement.setString(3, movieintheater.getShow());
			preparedStatement.setDate(4,Date.valueOf(movieintheater.getDate()));
			System.out.println(movieintheater.getTheaterscreen().getScreen());
			preparedStatement.setString(5, movieintheater.getTheaterscreen().getScreen());
			preparedStatement.setInt(6, movieintheater.getAmount());
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
		String sql="select id,theaterid,movieid,show,showdate,screen_no,amount from movieintheater";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			MovieInTheater movieintheater=new MovieInTheater();
			TheaterDAO theaterDAO=new TheaterDAO();
			MovieDAO movieDAO=new MovieDAO();
			TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
			TheaterScreen theaterScreen=new TheaterScreen();
			System.out.println(resultSet.getInt("theaterid"));
			theaterScreen=theaterScreenDAO.findById(resultSet.getInt("theaterid"));
			System.out.println(resultSet.getInt("theaterid"));
			Theater theater=theaterDAO.findById(resultSet.getInt("theaterid"));
			movieintheater.setTheater(theater);
			Movie movie=movieDAO.findById(resultSet.getInt("movieid"));
			movieintheater.setMovie(movie);
			movieintheater.setShow(resultSet.getString("show"));
			movieintheater.setDate(resultSet.getDate("showdate").toLocalDate());
			System.out.println(resultSet.getInt("theaterid"));
			theaterScreen=theaterScreenDAO.findById(resultSet.getInt("theaterid"));
			movieintheater.setTheaterscreen(theaterScreen);
			movieintheater.setAmount(resultSet.getInt("amount"));
			movietheaterlist.add(movieintheater);
		}
		return movietheaterlist;
	}
	
	public ArrayList<MovieInTheater> findbyTheater(int id) throws SQLException
	{
		ArrayList<MovieInTheater> movietheaterlist=new ArrayList<MovieInTheater>();
		Connection connection=ConnectionUtil.getConnection();
		String sql="select id,theaterid,show,showdate,screen_no,amount from movieintheater where movieid=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();
		Theater theater=new Theater();
		while(resultSet.next())
		{
			MovieInTheater movieintheater=new MovieInTheater();
			TheaterDAO theaterDAO=new TheaterDAO();
			TheaterScreen theaterScreen=new TheaterScreen();
			TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
			theater=theaterDAO.findById(resultSet.getInt("theaterid"));
			movieintheater.setTheater(theater);
			movieintheater.setShow(resultSet.getString("show"));
			movieintheater.setDate(resultSet.getDate("showdate").toLocalDate());
			theaterScreen.setScreen(resultSet.getString("screen_no"));
			theaterScreen=theaterScreenDAO.findById(resultSet.getInt("theaterid"));
			movieintheater.setTheaterscreen(theaterScreen);
			movieintheater.setAmount(resultSet.getInt("amount"));
			movietheaterlist.add(movieintheater);
		}
		return movietheaterlist;
	}
	
	public ArrayList<MovieInTheater> findbyMovie(int id) throws SQLException
	{
		ArrayList<MovieInTheater> movietheaterlist=new ArrayList<MovieInTheater>();
		Connection connection=ConnectionUtil.getConnection();
		String sql="select id,movieid,show,showdate,screen_no,amount from movieintheater where theaterid=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			MovieInTheater movieintheater=new MovieInTheater();
			MovieDAO movieDAO=new MovieDAO();
			TheaterScreen theaterScreen=new TheaterScreen();
			Movie movie=movieDAO.findById(resultSet.getInt("movieid"));
			movieintheater.setMovie(movie);
			movieintheater.setShow(resultSet.getString("show"));
			movieintheater.setDate(resultSet.getDate("showdate").toLocalDate());
			theaterScreen.setScreen(resultSet.getString("screen_no"));
			TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
			theaterScreen=theaterScreenDAO.findById(id);
			movieintheater.setTheaterscreen(theaterScreen);
			movieintheater.setAmount(resultSet.getInt("amount"));
			movietheaterlist.add(movieintheater);
		}
		return movietheaterlist;
	}
}
