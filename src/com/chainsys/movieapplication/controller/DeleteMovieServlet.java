package com.chainsys.movieapplication.controller;

import java.io.IOException;
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
 * Servlet implementation class DeleteMovieServlet
 */
@WebServlet("/DeleteMovieServlet")
public class DeleteMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMovieServlet() {
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
		String moviename = request.getParameter("deletename");
		MovieDAO movieDAO = new MovieDAO();
		try {
			if (moviename.equals("Invalid")) {
				ArrayList<Movie> movielist = new ArrayList<>();
				movielist.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movielist);
				request.setAttribute("MESSAGE", "Did not choose Movie name");
				RequestDispatcher rd = request
						.getRequestDispatcher("DeleteMovie.jsp");
				rd.forward(request, response);
			} else {
				movieDAO.deleteMovie(moviename);
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
