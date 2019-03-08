package com.chainsys.movieapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.movieapplication.dao.RegisterDAO;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Register register = new Register();
		register.setEmail(email);
		register.setPassword(password);
		RegisterDAO registerDAO = new RegisterDAO();
		try {
			Register register2 = new Register();
			LoginValidation validator = new LoginValidation();
			validator.loginValidator(register);
			Boolean isActive = registerDAO.checkByEmailPassword(
					register.getEmail(), register.getPassword());
			Boolean isActiveEmailPassword = registerDAO.checkByEmailorPassword(
					register.getEmail(), register.getPassword());
			if (isActive) {
				register2 = registerDAO.checkLogin(register);
				if (register2.getStatus() == 0) {
					HttpSession session = request.getSession();
					session.setAttribute("NAME", register2);
					RequestDispatcher req = request
							.getRequestDispatcher("UserHome.jsp");
					req.forward(request, response);
				}
				else if (register2.getStatus() == 1) {
					HttpSession session = request.getSession();
					session.setAttribute("NAME", register2);
					RequestDispatcher req = request
							.getRequestDispatcher("Home.jsp");
					req.forward(request, response);
				}
			}
			else if(isActiveEmailPassword)
			{
				String msg = "Wrong Email or Password ";
				request.setAttribute("MESSAGE", msg);
				RequestDispatcher req = request
						.getRequestDispatcher("Login.jsp");
				req.forward(request, response);
			}
			else {
				 String msg = "You must Register";
				 request.setAttribute("MESSAGE", msg);
				 RequestDispatcher req = request
						.getRequestDispatcher("Login.jsp");
				req.forward(request, response);
			}
		} catch (Exception ex) {
			ex.getMessage();
			RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
			req.forward(request, response);

		}
	}
}
