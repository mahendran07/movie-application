package com.chainsys.movieapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapplication.dao.RegisterDAO;
import com.chainsys.movieapplication.model.Register;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		long phone = Long.parseLong(request.getParameter("phonenumber"));
		String password = request.getParameter("password");
		
		Register register = new Register();
		register.setName(username);
		register.setEmail(email);
		register.setPassword(password);
		register.setPhonenumber(phone);
		RegisterDAO registerdao = new RegisterDAO();
		try {
			registerdao.addUser(register);
			RequestDispatcher rd = request
					.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("Register.html");
			rd.forward(request, response);
		}
	}
}
