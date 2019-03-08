package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.movieapplication.dao.MovieDAO;
import com.chainsys.movieapplication.dao.MovieTheaterDAO;
import com.chainsys.movieapplication.dao.TheaterDAO;
import com.chainsys.movieapplication.dao.TheaterScreenDAO;
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.Theater;
import com.chainsys.movieapplication.model.TheaterScreen;

/**
 * Servlet implementation class MovieApplicationServlet
 */
@WebServlet("/MovieApplicationServlet")
public class MovieApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = "";
		if (request.getParameter("updatemovie") != null) {
			name = request.getParameter("updatemovie");
		}
		else if(request.getParameter("deletemovie") != null) {
			name = request.getParameter("deletemovie");
		}
		else if(request.getParameter("updatetheater") != null) {
			name = request.getParameter("updatetheater");
		}
		else if(request.getParameter("deletetheater") != null) {
			name = request.getParameter("deletetheater");
		}
		else if(request.getParameter("addscreen") != null) {
			name = request.getParameter("addscreen");
		}
		else if(request.getParameter("updatescreen") != null) {
			name = request.getParameter("updatescreen");
		}
		else if(request.getParameter("deletescreen") != null) {
			name = request.getParameter("deletescreen");
		}
		else if(request.getParameter("addmovieintheater")!=null) {
			name=request.getParameter("addmovieintheater");
		}
		else if(request.getParameter("updatemovieintheater")!=null) {
			name=request.getParameter("updatemovieintheater");
		}
		else if(request.getParameter("deletemovieintheater")!=null) {
			name=request.getParameter("deletemovieintheater");
		}
		else if(request.getParameter("findbytheater")!=null) {
			name=request.getParameter("findbytheater");
		}
		else if(request.getParameter("findbymovie")!=null) {
			name=request.getParameter("findbymovie");
		}
		else if(request.getParameter("bookmovie")!=null) {
			name=request.getParameter("bookmovie");
		}
		else if(request.getParameter("changepassword")!=null) {
			name=request.getParameter("changepassword");
		}
		if (name.equals("updatemovie")) {
			MovieDAO movieDAO = new MovieDAO();
			ArrayList<Movie> movielist = new ArrayList<>();
			try {
				movielist.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movielist);
				RequestDispatcher req = request
						.getRequestDispatcher("UpdateMovie.jsp");
				req.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("deletemovie"))
		{
			MovieDAO movieDAO = new MovieDAO();
			try {
				ArrayList<Movie> movielist = new ArrayList<>();
				movielist.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movielist);
				RequestDispatcher req = request.getRequestDispatcher("DeleteMovie.jsp");
				req.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(name.equals("updatetheater"))
		{
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				ArrayList<Theater> theaterList = new ArrayList<>();
				theaterList.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterList);
				RequestDispatcher req = request.getRequestDispatcher("UpdateTheater.jsp");
				req.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(name.equals("deletetheater"))
		{
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				ArrayList<Theater> theaterList = new ArrayList<>();
				theaterList.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterList);
				RequestDispatcher req = request.getRequestDispatcher("DeleteTheater.jsp");
				req.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(name.equals("addscreen"))
		{
			TheaterDAO theaterDAO=new TheaterDAO();
			try {
				ArrayList<Theater> theaterlist = new ArrayList<>();
				theaterlist.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterlist);
				RequestDispatcher req = request.getRequestDispatcher("AddScreen.jsp");
				req.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(name.equals("updatescreen"))
		{
			TheaterDAO theaterDAO=new TheaterDAO();
			TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
			try {
				ArrayList<Theater> theaterlist = new ArrayList<>();
				ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
				theaterlist.addAll(theaterDAO.findAll());
				theaterscreenlist.addAll(theaterScreenDAO.findAll());
				request.setAttribute("THEATER", theaterlist);
				request.setAttribute("SCREEN", theaterscreenlist);
				RequestDispatcher req = request.getRequestDispatcher("UpdateScreen.jsp");
				req.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(name.equals("deletescreen"))
		{
			TheaterDAO theaterDAO=new TheaterDAO();
			TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
			try {
				ArrayList<Theater> theaterlist = new ArrayList<>();
				ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
				theaterlist.addAll(theaterDAO.findAll());
				theaterscreenlist.addAll(theaterScreenDAO.findAll());
				request.setAttribute("THEATER", theaterlist);
				request.setAttribute("SCREEN", theaterscreenlist);
				RequestDispatcher req = request.getRequestDispatcher("DeleteScreen.jsp");
				req.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(name.equals("addmovieintheater")) {
			TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
			MovieDAO movieDAO=new MovieDAO();
			TheaterDAO theaterDAO=new TheaterDAO();
			try {
				ArrayList<Theater> theaterList = new ArrayList<>();
				theaterList.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterList);
				ArrayList<Movie> movieList = new ArrayList<>();
				movieList.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movieList);
				ArrayList<TheaterScreen> theaterscreenList = new ArrayList<>();
				theaterscreenList.addAll(theaterScreenDAO.findAll());
				request.setAttribute("SCREEN", theaterscreenList);
				RequestDispatcher req = request.getRequestDispatcher("AddMovieinTheater.jsp");
				req.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(name.equals("updatemovieintheater")) {
			TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
			MovieDAO movieDAO=new MovieDAO();
			TheaterDAO theaterDAO=new TheaterDAO();
			try {
				ArrayList<Theater> theaterList = new ArrayList<>();
				theaterList.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterList);
				ArrayList<Movie> movieList = new ArrayList<>();
				movieList.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movieList);
				ArrayList<TheaterScreen> theaterscreenList = new ArrayList<>();
				theaterscreenList.addAll(theaterScreenDAO.findAll());
				request.setAttribute("SCREEN", theaterscreenList);
				RequestDispatcher req = request.getRequestDispatcher("UpdateMovieTheater.jsp");
				req.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(name.equals("deletemovieintheater"))
		{
			MovieDAO movieDAO=new MovieDAO();
			TheaterDAO theaterDAO=new TheaterDAO();
			try {
				ArrayList<Theater> theaterList = new ArrayList<>();
				theaterList.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterList);
				ArrayList<Movie> movieList = new ArrayList<>();
				movieList.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movieList);
				RequestDispatcher req = request.getRequestDispatcher("DeleteMovieinTheater.jsp");
				req.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(name.equals("findbytheater"))
		{
			MovieDAO movieDAO = new MovieDAO();
			try {
				ArrayList<Movie> movielist = new ArrayList<>();
				movielist.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movielist);
				RequestDispatcher rd = request.getRequestDispatcher("FindbyTheater.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("findbymovie")) {
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				ArrayList<Theater> theaterlist = new ArrayList<>();
				theaterlist.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterlist);
				RequestDispatcher rd = request.getRequestDispatcher("FindbyMovie.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("bookmovie")) {
			MovieDAO movieDAO = new MovieDAO();
			TheaterDAO theaterDAO=new TheaterDAO();
			try {
				List<Movie> movielist = new ArrayList<>();
				List<Theater> theaterlist=new ArrayList<Theater>();
				movielist.addAll(movieDAO.findAll());
				theaterlist.addAll(theaterDAO.findAll());
				request.setAttribute("MOVIE", movielist);
				request.setAttribute("THEATER", theaterlist);
				RequestDispatcher rd = request.getRequestDispatcher("BookingMovie.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("changepassword")) {
			HttpSession session=request.getSession(false);
			session.getAttribute("NAME");
			RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
			rd.forward(request, response);
		}
	}
}
