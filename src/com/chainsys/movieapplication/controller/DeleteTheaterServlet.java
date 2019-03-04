package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapplication.dao.TheaterDAO;
import com.chainsys.movieapplication.model.Theater;

/**
 * Servlet implementation class DeleteTheaterServlet
 */
@WebServlet("/DeleteTheaterServlet")
public class DeleteTheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTheaterServlet() {
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
		String theaterplace=request.getParameter("theatername");
		int length=theaterplace.length();
		int pos=theaterplace.indexOf('-');
		String theatername = theaterplace.substring(0, pos);
		String place=theaterplace.substring(pos+1,length);
		TheaterDAO theaterDAO = new TheaterDAO();
		try {
			theaterDAO.deleteTheater(theatername,place);
			ArrayList<Theater> theaterList = new ArrayList<>();
			theaterList.addAll(theaterDAO.findAll());
			request.setAttribute("THEATER", theaterList);
			RequestDispatcher rd = request.getRequestDispatcher("viewTheater.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
