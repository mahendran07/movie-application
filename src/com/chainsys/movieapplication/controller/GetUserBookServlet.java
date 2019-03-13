package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieid = request.getParameter("movie");
		String theaterid=request.getParameter("theater");
		LocalDate date=LocalDate.parse(request.getParameter("date"));
		Movie movie=new Movie();
		MovieInTheater movieInTheater=new MovieInTheater();
		MovieTheaterDAO movieTheaterDAO=new MovieTheaterDAO();
		Theater theater=new Theater();
		movie.setId(Integer.parseInt(movieid));
		theater.setId(Integer.parseInt(theaterid));
		movieInTheater.setMovie(movie);
		movieInTheater.setTheater(theater);
		movieInTheater.setDate(date);
		ArrayList<MovieInTheater> list=new ArrayList<MovieInTheater>();
		StringBuilder stringBuilder=new StringBuilder();
		try {
			list.addAll(movieTheaterDAO.findbyshow(Integer.parseInt(theaterid),Integer.parseInt(movieid),date));
			System.out.println(list.size());
			//for(int i=0;i<list.size();i++) {
				for (MovieInTheater movieInTheater2 : list) {
					stringBuilder.append(movieInTheater2.getScreen()+"-"+movieInTheater2.getShow());
					stringBuilder.append(',');
				}
			//}
			System.out.println(stringBuilder.toString());
		} catch (SQLException e) {
			throw new RuntimeException("Unable to choose Movie");
		}
		response.setContentType("text/plain");
		response.getWriter().write(stringBuilder.toString());
	}

}
