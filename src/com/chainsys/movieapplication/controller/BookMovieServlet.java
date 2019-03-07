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
import com.chainsys.movieapplication.model.MovieInTheater;

/**
 * Servlet implementation class BookMovieServlet
 */
@WebServlet("/BookMovieServlet")
public class BookMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int movieid=Integer.parseInt(request.getParameter("moviename"));
		int theaterid=Integer.parseInt(request.getParameter("theatername"));
		String show=request.getParameter("show");
		LocalDate date=LocalDate.parse(request.getParameter("date"));
		MovieTheaterDAO movieTheaterDAO=new MovieTheaterDAO();
		ArrayList<MovieInTheater> list=new ArrayList<MovieInTheater>();
		try {
			list=movieTheaterDAO.findbydate(theaterid, movieid,show);
			LocalDate availabledate=LocalDate.now();
			for (MovieInTheater movieInTheater : list) {
				availabledate=movieInTheater.getDate();
			}
			if(availabledate.equals(date))
			{
				request.setAttribute("MESSAGE", "Ticket Book is Success");
				RequestDispatcher rd=request.getRequestDispatcher("BookingMovie.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("MESSAGE", "On That date Movie is Not Running");
				RequestDispatcher rd=request.getRequestDispatcher("BookingMovie.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
