package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapplication.dao.MovieBookDAO;
import com.chainsys.movieapplication.dao.MovieDAO;
import com.chainsys.movieapplication.dao.MovieTheaterDAO;
import com.chainsys.movieapplication.dao.TheaterDAO;
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.MovieInTheater;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.model.TheaterScreen;

/**
 * Servlet implementation class BookMovieServlet
 */
@WebServlet("/BookMovieServlet")
public class BookMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int movieid = Integer.parseInt(request.getParameter("moviename"));
		int theaterid = Integer.parseInt(request.getParameter("theatername"));
		String show = request.getParameter("show");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		int seats = Integer.parseInt(request.getParameter("noofticket"));
		MovieTheaterDAO movieTheaterDAO = new MovieTheaterDAO();
		ArrayList<MovieInTheater> list = new ArrayList<MovieInTheater>();
		try {
			list = movieTheaterDAO.findbydate(theaterid, movieid, show);
			LocalDate availabledate = LocalDate.now();
			for (MovieInTheater movieInTheater : list) {
				availabledate = movieInTheater.getDate();
			}
			if (availabledate.equals(date)) {
				list = movieTheaterDAO.findbydate(theaterid, movieid, show);
				float amount = 0.0f;
				for (MovieInTheater movieInTheater2 : list) {
					amount = movieInTheater2.getAmount();
				}
				MovieInTheater movieInTheater = new MovieInTheater();
				Movie movie = new Movie();
				Theater theater = new Theater();
				TheaterScreen theaterScreen = new TheaterScreen();
				movie.setId(movieid);
				theater.setId(theaterid);
				movieInTheater.setMovie(movie);
				movieInTheater.setTheater(theater);
				movieInTheater.setShow(show);
				movieInTheater.setDate(date);
				theaterScreen.setTotalTicket(seats);
				movieInTheater.setTheaterscreen(theaterScreen);
				float totalamount = seats * amount;
				movieInTheater.setAmount(totalamount);
				MovieBookDAO movieBookDAO = new MovieBookDAO();
				try {
					movieBookDAO.addMovieBook(movieInTheater);
					request.setAttribute("MESSAGE", "Ticket Book is Success");
					RequestDispatcher rd = request
							.getRequestDispatcher("ViewBookingMovie.jsp");
					rd.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				MovieDAO movieDAO = new MovieDAO();
				TheaterDAO theaterDAO = new TheaterDAO();
				try {
					List<Movie> movielist = new ArrayList<>();
					List<Theater> theaterlist = new ArrayList<Theater>();
					movielist.addAll(movieDAO.findAll());
					theaterlist.addAll(theaterDAO.findAll());
					request.setAttribute("MOVIE", movielist);
					request.setAttribute("THEATER", theaterlist);
					request.setAttribute("MESSAGE",
							"On That date Movie is Not Running");
					RequestDispatcher rd = request
							.getRequestDispatcher("BookingMovie.jsp");
					rd.forward(request, response);
				} catch (Exception ex) {
					ex.getMessage();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
