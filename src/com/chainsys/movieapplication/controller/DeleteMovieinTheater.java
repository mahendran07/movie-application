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
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.Theater;

/**
 * Servlet implementation class DeleteMovieinTheater
 */
@WebServlet("/DeleteMovieinTheater")
public class DeleteMovieinTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMovieinTheater() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Movie movie=new Movie();
		Theater theater = new Theater();
		MovieTheaterDAO movietheaterDAO = new MovieTheaterDAO();
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
//			ArrayList<MovieInTheater> movietheaterList = new ArrayList<>();
//			movietheaterList.addAll(movietheaterDAO.findAll());
//			request.setAttribute("MOVIEINTHEATER", movietheaterList);
			RequestDispatcher req = request.getRequestDispatcher("DeleteMovieinTheater.jsp");
			req.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
