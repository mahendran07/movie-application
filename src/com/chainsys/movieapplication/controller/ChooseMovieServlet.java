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
import com.chainsys.movieapplication.dao.MovieTheaterDAO;
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.MovieInTheater;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Servlet implementation class ChooseMovieServlet
 */
@WebServlet("/ChooseMovieServlet")
public class ChooseMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseMovieServlet() {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		int movieid=Integer.parseInt(request.getParameter("moviename"));
		MovieTheaterDAO movieTheaterDAO=new MovieTheaterDAO();
		ArrayList<MovieInTheater> listtheater=new ArrayList<MovieInTheater>();
		try {
			listtheater.addAll(movieTheaterDAO.findbyTheater(movieid));
			request.setAttribute("THEATERLIST", listtheater);
			RequestDispatcher rd=request.getRequestDispatcher("FindbyTheater.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
