package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapplication.dao.MovieDAO;
import com.chainsys.movieapplication.model.Movie;

/**
 * Servlet implementation class UpdateMovieServlet
 */
@WebServlet("/UpdateMovieServlet")
public class UpdateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String moviename = request.getParameter("moviename");
		String newmoviename = request.getParameter("movienamenew");
		Movie movie = new Movie();
		Movie movienew = new Movie();
		movie.setName(moviename);
		movienew.setName(newmoviename);
		MovieDAO movieDAO = new MovieDAO();
		try {
			if (moviename.equals("Invalid") && (newmoviename.isEmpty())) {
				ArrayList<Movie> movielist = new ArrayList<>();
				try {
					movielist.addAll(movieDAO.findAll());
					request.setAttribute("MOVIE", movielist);
					request.setAttribute("MESSAGE",
						"Did not choose Movie and Empty New name");
					RequestDispatcher rd = request
						.getRequestDispatcher("UpdateMovie.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			else if (moviename.equals("Invalid") || (newmoviename.isEmpty())) {
				ArrayList<Movie> movielist = new ArrayList<>();
				try {
					movielist.addAll(movieDAO.findAll());
					request.setAttribute("MOVIE", movielist);
					request.setAttribute("MESSAGE",
						"Did not choose Movie or Empty New name");
					RequestDispatcher rd = request
						.getRequestDispatcher("UpdateMovie.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			else if (moviename.equals("Invalid")) {
				ArrayList<Movie> movielist = new ArrayList<>();
				try {
					movielist.addAll(movieDAO.findAll());
					request.setAttribute("MOVIE", movielist);
					request.setAttribute("MESSAGE", "Did not choose Movie");
					RequestDispatcher req = request
							.getRequestDispatcher("UpdateMovie.jsp");
					req.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			else if (newmoviename.isEmpty()) {
				ArrayList<Movie> movielist = new ArrayList<>();
				try {
					movielist.addAll(movieDAO.findAll());
					request.setAttribute("MOVIE", movielist);
					request.setAttribute("MESSAGE", "Empty New name");
					RequestDispatcher rd = request
						.getRequestDispatcher("UpdateMovie.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			else {
				movieDAO.updateMovie(movie, movienew);
				ArrayList<Movie> movielist = new ArrayList<>();
				movielist.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movielist);
				RequestDispatcher rd = request
						.getRequestDispatcher("ViewMovie.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
