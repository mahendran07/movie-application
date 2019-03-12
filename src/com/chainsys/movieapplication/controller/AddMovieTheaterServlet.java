package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapplication.dao.MovieTheaterDAO;
import com.chainsys.movieapplication.dao.TheaterDAO;
import com.chainsys.movieapplication.dao.TheaterScreenDAO;
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.MovieInTheater;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.model.TheaterScreen;

/**
 * Servlet implementation class AddMovieTheaterServlet
 */
@WebServlet("/AddMovieTheaterServlet")
public class AddMovieTheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovieTheaterServlet() {
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
		MovieInTheater movieintheater=new MovieInTheater();
		Theater theater=new Theater();
		Movie movie=new Movie();
		TheaterScreen theaterScreen=new TheaterScreen();
		TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
		int theaterid=Integer.parseInt(request.getParameter("theatername"));
		theater.setId(theaterid);
		int movieid=Integer.parseInt(request.getParameter("moviename"));
		movie.setId(movieid);
		movieintheater.setTheater(theater);
		movieintheater.setMovie(movie);
		movieintheater.setShow(request.getParameter("show"));
		LocalDate date=LocalDate.parse(request.getParameter("date"));
		movieintheater.setDate(date);
		try {
			TheaterScreen theaterScreen2=theaterScreenDAO.findByScreen(request.getParameter("screen"));
			theaterScreen.setId(theaterScreen2.getId());
			movieintheater.setTheaterscreen(theaterScreen);
			movieintheater.setAmount(Integer.parseInt(request.getParameter("amount")));
			MovieTheaterDAO movieTheaterDAO=new MovieTheaterDAO();
			try {
					movieTheaterDAO.addMovieTheater(movieintheater);
					ArrayList<MovieInTheater> viewlist=new ArrayList<MovieInTheater>();
					viewlist.addAll(movieTheaterDAO.joinviewList());
					request.setAttribute("MOVIEINTHEATER", viewlist);
					RequestDispatcher rd=request.getRequestDispatcher("viewMovieinTheater.jsp");
					rd.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
