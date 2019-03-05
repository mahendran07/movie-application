package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapplication.dao.MovieTheaterDAO;
import com.chainsys.movieapplication.dao.TheaterScreenDAO;
import com.chainsys.movieapplication.model.MovieInTheater;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.model.TheaterScreen;

/**
 * Servlet implementation class GetUserDeleteServlet
 */
@WebServlet("/GetUserDeleteServlet")
public class GetUserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theaterName = request.getParameter("theater");
		System.out.println(theaterName);
		Theater theater=new Theater();
		MovieInTheater movieInTheater=new MovieInTheater();
		MovieTheaterDAO movieTheaterDAO=new MovieTheaterDAO();
		theater.setId(Integer.parseInt(theaterName));
		movieInTheater.setTheater(theater);
		StringBuilder stringBuilder=new StringBuilder();
		
		try {
			ArrayList<MovieInTheater> list=movieTheaterDAO.findbyMovie(movieInTheater.getTheater().getId());
			for(int i=0;i<list.size();i++)
			{
				for (MovieInTheater movieInTheater2 : list) {
					stringBuilder.append(movieInTheater2.getMovie().getName());
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
