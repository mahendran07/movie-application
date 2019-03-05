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

import com.chainsys.movieapplication.dao.MovieTheaterDAO;
import com.chainsys.movieapplication.dao.TheaterDAO;
import com.chainsys.movieapplication.model.MovieInTheater;
import com.chainsys.movieapplication.model.Theater;

/**
 * Servlet implementation class ChooseTheaterServlet
 */
@WebServlet("/ChooseTheaterServlet")
public class ChooseTheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseTheaterServlet() {
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
			//RequestDispatcher rd = request.getRequestDispatcher("FindbyTheater.jsp");
			//rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String name=request.getParameter("theatername");
		//System.out.println(name);
		int length=name.length();
		int pos=name.indexOf('.');
		int poss=name.indexOf('-');
		String theaterid=(name.substring(0, pos));
		String theatername = name.substring(pos+1, poss);
		String place=name.substring(poss+1,length);
		MovieTheaterDAO movieTheaterDAO=new MovieTheaterDAO();
		ArrayList<MovieInTheater> listtheater=new ArrayList<MovieInTheater>();
		try {
			listtheater.addAll(movieTheaterDAO.findbyMovie(Integer.parseInt(theaterid)));
			request.setAttribute("THEATERLIST", listtheater);
			RequestDispatcher rd=request.getRequestDispatcher("FindbyMovie.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}

}
