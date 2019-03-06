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
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.MovieInTheater;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.model.TheaterScreen;

/**
 * Servlet implementation class GetUserBookServlet
 */
@WebServlet("/GetUserBookServlet")
public class GetUserBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int movieid = Integer.parseInt(request.getParameter("theater"));
		//System.out.println(movieid);
		Movie movie=new Movie();
		MovieInTheater movieInTheater=new MovieInTheater();
		Theater theater=new Theater();
		MovieTheaterDAO movieTheaterDAO=new MovieTheaterDAO();
		theater.setId(movieid);
		movieInTheater.setTheater(theater);
		ArrayList<MovieInTheater> list=new ArrayList<MovieInTheater>();
		StringBuilder stringBuilder=new StringBuilder();
		StringBuilder stringBuilder2=new StringBuilder();
		StringBuilder stringBuilder3=new StringBuilder();
		try {
			list.addAll(movieTheaterDAO.findbyTheater(movieid));
			for(int i=0;i<list.size();i++)
			{
				for (MovieInTheater movieInTheater2: list) {
					stringBuilder.append(movieInTheater2.getTheater().getName()+"-"+movieInTheater2.getTheater().getPlace());
					stringBuilder2.append(movieInTheater2.getShow());
					if(i>list.size())
					{
						stringBuilder.append(',');
						stringBuilder2.append(',');
					}
				}
				stringBuilder3.append(stringBuilder+":"+stringBuilder2);
			}
			System.out.println(stringBuilder3.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(stringBuilder3.toString());
	}

}
