package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapplication.dao.RegisterDAO;
import com.chainsys.movieapplication.model.Register;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String email=request.getParameter("email");
		Long phone=Long.parseLong(request.getParameter("phonenumber"));
		Register register=new Register();
		RegisterDAO registerDAO=new RegisterDAO();
		register.setName(name);
		register.setEmail(email);
		register.setPhonenumber(phone);
		Boolean isActive=registerDAO.checkForgetPassword(register);
		if(isActive)
		{
			//System.out.println("Inside");
			try {
				Register register2=new Register();
				register2=registerDAO.findByEmail(email);
				request.setAttribute("USERS", register2);
				RequestDispatcher rd=request.getRequestDispatcher("ForgetPassword.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Failed");
		}
	}

}
