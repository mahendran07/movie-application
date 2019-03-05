package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class GetUserTheaterServlet
 */
@WebServlet("/GetUserTheaterServlet")
public class GetUserTheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserTheaterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theaterName = request.getParameter("theater");
		int length=theaterName.length();
		int pos=theaterName.indexOf('-');
		int id=Integer.parseInt(theaterName.substring(0, pos));
		Theater theater=new Theater();
		TheaterDAO theaterDAO=new TheaterDAO();
		theater.setId(id);
		StringBuilder stringBuilder=new StringBuilder();
		
		try {
			ArrayList<Theater> list=theaterDAO.findByIdList(theater.getId());
			for(int i=0;i<list.size();i++)
			{
				for (Theater theater2 : list) {
					stringBuilder.append(theater2.getOwnername());
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
