package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapplication.dao.MovieDAO;
import com.chainsys.movieapplication.dao.RegisterDAO;
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.Register;
import com.chainsys.movieapplication.validation.LoginValidation;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		Movie movie = new Movie();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Register register = new Register();
		register.setEmail(email);
		register.setPassword(password);
		RegisterDAO registerDAO = new RegisterDAO();
		MovieDAO movieDAO = new MovieDAO();
		try {
			ArrayList<Movie> movielist = new ArrayList<>();
			movielist.addAll(movieDAO.findAll());
			//LoginValidation validator = new LoginValidation();
			//validator.loginValidator(register);
			Register register2=new Register();
			register2=registerDAO.checkLogin(register);
			if(register2.getStatus()==0)
			{
				request.setAttribute("NAME", register2);
				RequestDispatcher req = request.getRequestDispatcher("UserHome.jsp");
				req.forward(request, response);
			}
			else
			{
				request.setAttribute("MOVIE", movielist);
				RequestDispatcher req = request.getRequestDispatcher("Home.jsp");
				req.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher req = request.getRequestDispatcher("Login.html");
			req.forward(request, response);

		}
	}
}
