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
import com.chainsys.movieapplication.model.MovieInTheater;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.model.TheaterScreen;

/**
 * Servlet implementation class AddTheaterScreen
 */
@WebServlet("/AddTheaterScreen")
public class AddTheaterScreen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTheaterScreen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Theater theater=new Theater();
		int theaterid=Integer.parseInt(request.getParameter("theatername"));
		String screen=request.getParameter("screen");
		int seats=Integer.parseInt(request.getParameter("total"));
		TheaterScreen theaterScreen=new TheaterScreen();
		theater.setId(theaterid);
		theaterScreen.setTheater(theater);
		theaterScreen.setScreen(screen);
		theaterScreen.setTotalTicket(seats);
		TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
		try {
			if(theaterid==-1) {
				ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
				theaterscreenlist.addAll(theaterScreenDAO.findAll());
				request.setAttribute("MESSAGE", "Choose Theater name");
				request.setAttribute("THEATERSCREEN", theaterscreenlist);
				RequestDispatcher rd=request.getRequestDispatcher("AddScreen.jsp");
				rd.forward(request, response);
			}
			else if(screen.isEmpty()) {
				ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
				theaterscreenlist.addAll(theaterScreenDAO.findAll());
				request.setAttribute("MESSAGE", "Type Screen");
				request.setAttribute("THEATERSCREEN", theaterscreenlist);
				RequestDispatcher rd=request.getRequestDispatcher("AddScreen.jsp");
				rd.forward(request, response);
			}
			else if(seats<0) {
				ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
				theaterscreenlist.addAll(theaterScreenDAO.findAll());
				request.setAttribute("MESSAGE", "Negative Not Allowed");
				request.setAttribute("THEATERSCREEN", theaterscreenlist);
				RequestDispatcher rd=request.getRequestDispatcher("AddScreen.jsp");
				rd.forward(request, response);
			}
			else {
				theaterScreenDAO.addScreen(theaterScreen);
				ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
				theaterscreenlist.addAll(theaterScreenDAO.findAll());
				request.setAttribute("THEATERSCREEN", theaterscreenlist);
				RequestDispatcher rd=request.getRequestDispatcher("viewTheaterScreen.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
