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
import com.chainsys.movieapplication.dao.TheaterDAO;
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.Theater;

/**
 * Servlet implementation class FindbyMovieServlet
 */
@WebServlet("/FindbyMovieServlet")
public class FindbyMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindbyMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TheaterDAO theaterDAO = new TheaterDAO();
		try {
			ArrayList<Theater> theaterlist = new ArrayList<>();
			theaterlist.addAll(theaterDAO.findAll());
			request.setAttribute("THEATER", theaterlist);
			RequestDispatcher rd = request.getRequestDispatcher("FindbyMovie.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
