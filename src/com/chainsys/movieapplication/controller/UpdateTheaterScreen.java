package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapplication.dao.TheaterScreenDAO;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.model.TheaterScreen;

/**
 * Servlet implementation class UpdateTheaterScreen
 */
@WebServlet("/UpdateTheaterScreen")
public class UpdateTheaterScreen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTheaterScreen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Theater theater=new Theater();
		String theaterid=request.getParameter("theatername");
		String screen=request.getParameter("screen");
		int total=Integer.parseInt(request.getParameter("total"));
		theater.setId(Integer.parseInt(theaterid));
		TheaterScreen theaterScreen=new TheaterScreen();
		theaterScreen.setTheater(theater);
		theaterScreen.setScreen(screen);
		theaterScreen.setTotalTicket(total);
		TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
		try {
			theaterScreenDAO.updateTheaterScreen(theaterScreen);
			ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
			theaterscreenlist.addAll(theaterScreenDAO.findAll());
			request.setAttribute("THEATERSCREEN", theaterscreenlist);
			RequestDispatcher rd=request.getRequestDispatcher("viewTheaterScreen.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
