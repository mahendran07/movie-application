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
import com.chainsys.movieapplication.dao.MovieTheaterDAO;
import com.chainsys.movieapplication.dao.TheaterDAO;
import com.chainsys.movieapplication.dao.TheaterScreenDAO;
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.model.TheaterScreen;

/**
 * Servlet implementation class UpdateMovieinTheater
 */
@WebServlet("/UpdateMovieinTheater")
public class UpdateMovieinTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMovieinTheater() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
		MovieDAO movieDAO=new MovieDAO();
		TheaterDAO theaterDAO=new TheaterDAO();
		try {
			//movietheaterDAO.addMovieTheater(theater);
			ArrayList<Theater> theaterList = new ArrayList<>();
			theaterList.addAll(theaterDAO.findAll());
			request.setAttribute("THEATER", theaterList);
			ArrayList<Movie> movieList = new ArrayList<>();
			movieList.addAll(movieDAO.findAll());
			request.setAttribute("MOVIE", movieList);
			ArrayList<TheaterScreen> theaterscreenList = new ArrayList<>();
			theaterscreenList.addAll(theaterScreenDAO.findAll());
			request.setAttribute("SCREEN", theaterscreenList);
			RequestDispatcher req = request.getRequestDispatcher("UpdateMovieTheater.jsp");
			req.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
