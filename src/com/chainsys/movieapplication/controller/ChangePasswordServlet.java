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

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Register register=new Register();
		HttpSession session=request.getSession(false);
		register=(Register) session.getAttribute("NAME");
		String email=register.getEmail();
		String password=register.getPassword();
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		String confirmnewpassword=request.getParameter("confirmnewpassword");
		RegisterDAO regsiterDAO=new RegisterDAO();
		if(password.equals(oldpassword))
		{
			if(newpassword.equals(confirmnewpassword))
			{
				register.setPassword(newpassword);
				try {
					regsiterDAO.changePassword(register);
					String message="Your Password is Changed";
					request.setAttribute("MESSAGE", message);
					RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
					rd.forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				String message="New and Confirm Password is Not equal";
				request.setAttribute("MESSAGE", message);
				RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			String message="Your old Password is Wrong";
			request.setAttribute("MESSAGE", message);
			RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
			rd.forward(request, response);
		}
	}

}
