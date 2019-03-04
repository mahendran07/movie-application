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
import com.chainsys.movieapplication.dao.TheaterScreenDAO;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.model.TheaterScreen;

/**
 * Servlet implementation class UpdateScreen
 */
@WebServlet("/UpdateScreen")
public class UpdateScreen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateScreen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TheaterDAO theaterDAO=new TheaterDAO();
		TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
		try {
			ArrayList<Theater> theaterlist = new ArrayList<>();
			ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
			theaterlist.addAll(theaterDAO.findAll());
			theaterscreenlist.addAll(theaterScreenDAO.findAll());
			request.setAttribute("THEATER", theaterlist);
			request.setAttribute("SCREEN", theaterscreenlist);
			RequestDispatcher req = request.getRequestDispatcher("UpdateScreen.jsp");
			req.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
