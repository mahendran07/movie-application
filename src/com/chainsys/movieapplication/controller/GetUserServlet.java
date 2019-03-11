package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.chainsys.movieapplication.dao.TheaterScreenDAO;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.model.TheaterScreen;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theaterName = request.getParameter("theater");
		//System.out.println(theaterName);
		Theater theater=new Theater();
		TheaterScreen theaterScreen=new TheaterScreen();
		TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
		theater.setId(Integer.parseInt(theaterName));
		theaterScreen.setTheater(theater);
		StringBuilder stringBuilder=new StringBuilder();
		try {
			ArrayList<TheaterScreen> list=theaterScreenDAO.findByIdList(theaterScreen.getTheater().getId());
			for(int i=1;i<list.size();i++)
			{
				for (TheaterScreen theaterScreen2 : list) {
					stringBuilder.append(theaterScreen2.getScreen());
					if(i>list.size())
					{
						stringBuilder.append(',');
					}
				}
			}
			System.out.println(stringBuilder.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(stringBuilder.toString());
	}

}
