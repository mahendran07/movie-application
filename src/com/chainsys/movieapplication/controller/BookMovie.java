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
		try {
			ArrayList<Movie> movielist = new ArrayList<>();
			movielist.addAll(movieDAO.findAll());
			request.setAttribute("MOVIE", movielist);
			RequestDispatcher rd = request.getRequestDispatcher("BookingMovie.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
