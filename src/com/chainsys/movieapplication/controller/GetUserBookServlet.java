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
import com.chainsys.movieapplication.dao.TheaterDAO;
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.MovieInTheater;
import com.chainsys.movieapplication.model.Theater;

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
		String movieid = request.getParameter("movie");
		String theaterid=request.getParameter("theater");
		Movie movie=new Movie();
		MovieInTheater movieInTheater=new MovieInTheater();
		MovieTheaterDAO movieTheaterDAO=new MovieTheaterDAO();
		TheaterDAO theaterDAO=new TheaterDAO();
		Theater theater=new Theater();
		movie.setId(Integer.parseInt(movieid));
		theater.setId(Integer.parseInt(theaterid));
		movieInTheater.setMovie(movie);
		movieInTheater.setTheater(theater);
		ArrayList<MovieInTheater> list=new ArrayList<MovieInTheater>();
		StringBuilder stringBuilder=new StringBuilder();
		StringBuilder stringBuilder2=new StringBuilder();
		StringBuilder stringBuilder3=new StringBuilder();
		try {
			System.out.println(Integer.parseInt(theaterid));
			System.out.println(Integer.parseInt(movieid));
			list.addAll(movieTheaterDAO.findbyshow(Integer.parseInt(theaterid),Integer.parseInt(movieid)));
			System.out.println(list);
			for (MovieInTheater movieInTheater2 : list) {
				System.out.println(stringBuilder.append(movieInTheater2.getShow()));
				System.out.println(stringBuilder2.append(movieInTheater2.getDate()));
				if(list.size()>1) {
					stringBuilder.append(',');
					stringBuilder2.append(',');
				}
			}
			stringBuilder3.append(stringBuilder+":"+stringBuilder2);
			System.out.println(stringBuilder3.toString());
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("Unable to choose Movie");
		}
		response.setContentType("text/plain");
		response.getWriter().write(stringBuilder3.toString());
	}

}
