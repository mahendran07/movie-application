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
 * Servlet implementation class UpdateTheaterServlet
 */
@WebServlet("/UpdateTheaterServlet")
public class UpdateTheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTheaterServlet() {
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
		String theatername = request.getParameter("theatername");
		String place=request.getParameter("place");
		int amount=Integer.parseInt(request.getParameter("amount"));
		Theater theater = new Theater();
		theater.setAmount(amount);
		theater.setName(theatername);
		theater.setPlace(place);
		TheaterDAO theaterDAO = new TheaterDAO();
		try {
			theaterDAO.updateTheater(theater);
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