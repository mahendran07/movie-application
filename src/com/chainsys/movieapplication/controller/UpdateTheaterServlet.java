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
		String name = request.getParameter("theatername");
		String oldownername=request.getParameter("oldowner");
		System.out.println(oldownername);
		String newownername=request.getParameter("newownername");
		int length=name.length();
		int find=name.indexOf('-');
		String theatername=name.substring(find+1, length);
		Theater theater = new Theater();
		TheaterDAO theaterDAO = new TheaterDAO();
		try {
			if(newownername.isEmpty()) {
				ArrayList<Theater> theaterList = new ArrayList<>();
				theaterList.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterList);
				request.setAttribute("MESSAGE", "Type New Owner name");
				RequestDispatcher rd = request.getRequestDispatcher("UpdateTheater.jsp");
				rd.forward(request, response);
			}
			else if(theatername.equals("Invalid")) {
				ArrayList<Theater> theaterList = new ArrayList<>();
				theaterList.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterList);
				request.setAttribute("MESSAGE", "choose theater name then view old owner name");
				RequestDispatcher rd = request.getRequestDispatcher("UpdateTheater.jsp");
				rd.forward(request, response);
			}
			else {
				theater.setOwnername(newownername);
				theater.setName(theatername);
				theater.setOwnername(oldownername);
				theaterDAO.updateTheater(theater);
				ArrayList<Theater> theaterList = new ArrayList<>();
				theaterList.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterList);
				RequestDispatcher rd = request.getRequestDispatcher("viewTheater.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
