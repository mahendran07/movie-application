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
	/** this method used to add movie in particular theater
	 * @param movieintheater
	 * @throws Exception
	 */
	public void addMovieTheater(MovieInTheater movieintheater) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into movieintheater(id,theaterid,movieid,show,showdate,amount,screen)values(seq_movietheater_id.NEXTVAL,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, movieintheater.getTheater().getId());
			preparedStatement.setInt(2, movieintheater.getMovie().getId());
			preparedStatement.setString(3, movieintheater.getShow());
			preparedStatement.setDate(4, Date.valueOf(movieintheater.getDate()));
			preparedStatement.setFloat(5, movieintheater.getAmount());
			preparedStatement.setString(6, movieintheater.getScreen());
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			throw new Exception("Unable to Add");
		}
	}
	/**this method used to view movie with their theater 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MovieInTheater> findAll() throws SQLException {
		ArrayList<MovieInTheater> movietheaterlist = new ArrayList<MovieInTheater>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select td.name as theatername,md.name as moviename,mt.show as show,mt.showdate as showdate,ts.totalseats as seats,mt.screen as screen,mt.amount as amount from movieintheater mt"
				+ " join theaterdetail td on td.id=theaterid"
				+ " join moviedetail md on md.id=movieid"
				+ " join theaterscreen ts on ts.SCREEN=mt.SCREEN";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			MovieInTheater movieintheater = new MovieInTheater();
			Theater theater=new Theater();
			Movie movie=new Movie();
			theater.setName(resultSet.getString("theatername"));
			movie.setName(resultSet.getString("moviename"));
			movieintheater.setTheater(theater);
			movieintheater.setMovie(movie);
			movieintheater.setShow(resultSet.getString("show"));
			movieintheater.setDate(resultSet.getDate("showdate").toLocalDate());
			TheaterScreen theaterScreen=new TheaterScreen();
			theaterScreen.setTotalTicket(resultSet.getInt("seats"));
			movieintheater.setTheaterScreen(theaterScreen);
			movieintheater.setScreen(resultSet.getString("screen"));
			movieintheater.setAmount(resultSet.getInt("amount"));
			movietheaterlist.add(movieintheater);
		}
		return movietheaterlist;
	}
	/** this method used to find theater by using movie name
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MovieInTheater> findbyTheater(int id) throws SQLException {
		ArrayList<MovieInTheater> movietheaterlist = new ArrayList<MovieInTheater>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select td.id as id,td.name as theatername,td.place as theaterplace,md.name as moviename,mt.show as shows,mt.showdate as showdate,mt.screen as screen,ts.totalseats as seats,mt.amount as amount from movieintheater mt"
				+ " join theaterdetail td on td.id=theaterid"
				+ " join moviedetail md on md.id=movieid"
				+ " join theaterscreen ts on ts.theaterid=mt.THEATERID and ts.screen=mt.screen where movieid=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Theater theater = new Theater();
			Movie movie = new Movie();
			MovieInTheater movieInTheater = new MovieInTheater();
			theater.setId(Integer.parseInt(resultSet.getString("id")));
			theater.setName(resultSet.getString("theatername"));
			theater.setPlace(resultSet.getString("theaterplace"));
			movie.setName(resultSet.getString("moviename"));
			movieInTheater.setTheater(theater);
			movieInTheater.setMovie(movie);
			movieInTheater.setShow(resultSet.getString("shows"));
			movieInTheater.setDate(resultSet.getDate("showdate").toLocalDate());
			TheaterScreen theaterScreen = new TheaterScreen();
			theaterScreen.setTotalTicket(resultSet.getInt("seats"));
			movieInTheater.setTheaterScreen(theaterScreen);
			movieInTheater.setAmount(resultSet.getInt("amount"));
			movieInTheater.setScreen(resultSet.getString("screen"));
			movietheaterlist.add(movieInTheater);
		}
		return movietheaterlist;
	}
	/** this method used to find movie name by using theater name
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MovieInTheater> findbyMovie(int id) throws SQLException {
		ArrayList<MovieInTheater> movietheaterlist = new ArrayList<MovieInTheater>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select md.id as id,md.name as moviename,mt.show as shows,mt.showdate as showdate,mt.screen as screen,ts.totalseats as seats,mt.amount as amount from movieintheater mt"
				+ " join theaterdetail td on td.id=theaterid"
				+ " join moviedetail md on md.id=movieid"
				+ " join theaterscreen ts on ts.theaterid=mt.THEATERID and ts.screen=mt.screen where theaterid=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			MovieInTheater movieintheater = new MovieInTheater();
			MovieDAO movieDAO = new MovieDAO();
			TheaterScreen theaterScreen = new TheaterScreen();
			Movie movie = movieDAO.findById(resultSet.getInt("id"));
			movieintheater.setMovie(movie);
			movieintheater.setShow(resultSet.getString("shows"));
			movieintheater.setDate(resultSet.getDate("showdate").toLocalDate());
			theaterScreen.setTotalTicket(resultSet.getInt("seats"));
			movieintheater.setAmount(resultSet.getInt("amount"));
			movieintheater.setScreen(resultSet.getString("screen"));
			movieintheater.setTheaterScreen(theaterScreen);
			movietheaterlist.add(movieintheater);
		}
		return movietheaterlist;
	}
	/** this method used to find by the show details of movie in theater
	 * @param theaterid
	 * @param movieid
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MovieInTheater> findbyshow(int theaterid, int movieid)
			throws SQLException {
		ArrayList<MovieInTheater> movietheaterlist = new ArrayList<MovieInTheater>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select td.id as id,td.name as theatername,td.place as theaterplace,md.name as moviename,mt.show as shows,mt.showdate as showdate,mt.screen as screen,ts.totalseats as seats,mt.amount as amount from movieintheater mt"
				+ " join theaterdetail td on td.id=theaterid"
				+ " join moviedetail md on md.id=movieid"
				+ " join theaterscreen ts on ts.theaterid=mt.THEATERID and ts.screen=mt.screen where theaterid=? and movieid=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, theaterid);
		preparedStatement.setInt(2, movieid);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Theater theater = new Theater();
			Movie movie = new Movie();
			MovieInTheater movieInTheater = new MovieInTheater();
			TheaterScreen theaterScreen = new TheaterScreen();
			theater.setName(resultSet.getString("theatername"));
			theater.setPlace(resultSet.getString("theaterplace"));
			movie.setName(resultSet.getString("moviename"));
			movieInTheater.setTheater(theater);
			movieInTheater.setMovie(movie);
			movieInTheater.setShow(resultSet.getString("shows"));
			movieInTheater.setDate(resultSet.getDate("showdate").toLocalDate());
			theaterScreen.setTotalTicket(resultSet.getInt("seats"));
			movieInTheater.setAmount(resultSet.getInt("amount"));
			movieInTheater.setScreen(resultSet.getString("screen"));
			movietheaterlist.add(movieInTheater);
		}
		return movietheaterlist;
	}
	/** this method is used to find the date in movie in theater
	 * @param theaterid
	 * @param movieid
	 * @param show
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MovieInTheater> findbydate(int theaterid, int movieid,
			String show) throws SQLException {
		ArrayList<MovieInTheater> movietheaterlist = new ArrayList<MovieInTheater>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select td.id as id,td.name as theatername,td.place as theaterplace,md.name as moviename,mt.show as shows,mt.showdate as showdate,mt.screen as screen,ts.totalseats as seats,mt.amount as amount from movieintheater mt"
				+ " join theaterdetail td on td.id=theaterid"
				+ " join moviedetail md on md.id=movieid"
				+ " join theaterscreen ts on ts.theaterid=mt.THEATERID and ts.screen=mt.screen where theaterid=? and movieid=? and show=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, theaterid);
		preparedStatement.setInt(2, movieid);
		preparedStatement.setString(3, show);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Theater theater = new Theater();
			Movie movie = new Movie();
			MovieInTheater movieInTheater = new MovieInTheater();
			theater.setName(resultSet.getString("theatername"));
			theater.setPlace(resultSet.getString("theaterplace"));
			movie.setName(resultSet.getString("moviename"));
			movieInTheater.setTheater(theater);
			movieInTheater.setMovie(movie);
			movieInTheater.setShow(resultSet.getString("shows"));
			movieInTheater.setDate(resultSet.getDate("showdate").toLocalDate());
			TheaterScreen theaterScreen = new TheaterScreen();
			theaterScreen.setTotalTicket(resultSet.getInt("seats"));
			movieInTheater.setAmount(resultSet.getInt("amount"));
			movieInTheater.setScreen(resultSet.getString("screen"));
			movietheaterlist.add(movieInTheater);
		}
		return movietheaterlist;
	}
	/**this method is used to view movie in theater by the screen
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MovieInTheater> joinviewList() throws SQLException {
		ArrayList<MovieInTheater> listview = new ArrayList<MovieInTheater>();
		Connection connection = ConnectionUtil.getConnection();
		String sql1 = "select td.name as theatername,td.place as theaterplace,md.name as moviename,mt.show as shows,mt.showdate as showdate,mt.screen as screen,ts.totalseats as seats,mt.amount as amount from movieintheater mt"
				+ " join theaterdetail td on td.id=theaterid"
				+ " join moviedetail md on md.id=movieid"
				+ " join theaterscreen ts on ts.theaterid=mt.THEATERID and mt.screen=ts.screen";
		PreparedStatement preparedStatement = connection.prepareStatement(sql1);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Theater theater = new Theater();
			Movie movie = new Movie();
			MovieInTheater movieInTheater = new MovieInTheater();
			theater.setName(resultSet.getString("theatername"));
			theater.setPlace(resultSet.getString("theaterplace"));
			movie.setName(resultSet.getString("moviename"));
			movieInTheater.setTheater(theater);
			movieInTheater.setMovie(movie);
			movieInTheater.setShow(resultSet.getString("shows"));
			movieInTheater.setDate(resultSet.getDate("showdate").toLocalDate());
			TheaterScreen theaterScreen = new TheaterScreen();
			movieInTheater.setAmount(resultSet.getInt("amount"));
			movieInTheater.setScreen(resultSet.getString("screen"));
			theaterScreen.setTotalTicket(resultSet.getInt("seats"));
			movieInTheater.setTheaterScreen(theaterScreen);
			listview.add(movieInTheater);
		}
		return listview;
	}
}
