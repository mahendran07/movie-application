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
import com.chainsys.movieapplication.dao.RegisterDAO;
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.Register;
import com.chainsys.movieapplication.validation.LoginValidation;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServletmovie")
public class HomeServletmovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServletmovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Movie movie = new Movie();
		MovieDAO movieDAO = new MovieDAO();
		try {
			movieDAO.addMovie(movie);
			ArrayList<Movie> movielist = new ArrayList<>();
			movielist.addAll(movieDAO.findAll());
			request.setAttribute("MOVIE", movielist);
			RequestDispatcher req = request.getRequestDispatcher("MovieHome.jsp");
			req.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}