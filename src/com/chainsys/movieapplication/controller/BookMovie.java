package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.runtime.ListAdapter;

import com.chainsys.movieapplication.dao.MovieDAO;
import com.chainsys.movieapplication.dao.TheaterDAO;
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.Theater;

/**
 * Servlet implementation class BookMovie
 */
@WebServlet("/BookMovie")
public class BookMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO movieDAO = new MovieDAO();
		TheaterDAO theaterDAO=new TheaterDAO();
		try {
			List<Movie> movielist = new ArrayList<>();
			List<Theater> theaterlist=new ArrayList<Theater>();
			movielist.addAll(movieDAO.findAll());
			theaterlist.addAll(theaterDAO.findAll());
			request.setAttribute("MOVIE", movielist);
			request.setAttribute("THEATER", theaterlist);
			RequestDispatcher rd = request.getRequestDispatcher("BookingMovie.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
