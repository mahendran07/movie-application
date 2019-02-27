package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapplication.dao.MovieTheaterDAO;
import com.chainsys.movieapplication.model.MovieInTheater;

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
		String theaterid=request.getParameter("theatername");
		String movieid=request.getParameter("moviename");
		String show=request.getParameter("show");
		String date=request.getParameter("date");
		int total=Integer.parseInt(request.getParameter("total"));
		MovieInTheater movieintheater=new MovieInTheater();
	}

}
