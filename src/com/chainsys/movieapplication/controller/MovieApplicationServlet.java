package com.chainsys.movieapplication.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
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
import com.chainsys.movieapplication.dao.RegisterDAO;
import com.chainsys.movieapplication.dao.TheaterDAO;
import com.chainsys.movieapplication.dao.TheaterScreenDAO;
import com.chainsys.movieapplication.model.Movie;
import com.chainsys.movieapplication.model.MovieInTheater;
import com.chainsys.movieapplication.model.Register;
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
		} else if (request.getParameter("deletemovie") != null) {
			name = request.getParameter("deletemovie");
		} else if (request.getParameter("updatetheater") != null) {
			name = request.getParameter("updatetheater");
		} else if (request.getParameter("deletetheater") != null) {
			name = request.getParameter("deletetheater");
		} else if (request.getParameter("addscreen") != null) {
			name = request.getParameter("addscreen");
		} else if (request.getParameter("updatescreen") != null) {
			name = request.getParameter("updatescreen");
		} else if (request.getParameter("deletescreen") != null) {
			name = request.getParameter("deletescreen");
		} else if (request.getParameter("addmovieintheater") != null) {
			name = request.getParameter("addmovieintheater");
		} else if (request.getParameter("updatemovieintheater") != null) {
			name = request.getParameter("updatemovieintheater");
		} else if (request.getParameter("deletemovieintheater") != null) {
			name = request.getParameter("deletemovieintheater");
		} else if (request.getParameter("findbytheater") != null) {
			name = request.getParameter("findbytheater");
		} else if (request.getParameter("findbymovie") != null) {
			name = request.getParameter("findbymovie");
		} else if (request.getParameter("bookmovie") != null) {
			name = request.getParameter("bookmovie");
		} else if (request.getParameter("changepassword") != null) {
			name = request.getParameter("changepassword");
		} 
		else if (request.getParameter("addmovieservlet") != null) {
			name = request.getParameter("addmovieservlet");
		}
		else if(request.getParameter("updatemovieservlet")!=null) {
			name = request.getParameter("updatemovieservlet");
		}
		else if(request.getParameter("deletemovieservlet")!=null) {
			name = request.getParameter("deletemovieservlet");
		}
		else if(request.getParameter("addtheaterservlet")!=null) {
			name=request.getParameter("addtheaterservlet");
		}
		else if(request.getParameter("updatetheaterservlet")!=null) {
			name=request.getParameter("updatetheaterservlet");
		}
		else if(request.getParameter("deletetheaterservlet")!=null) {
			name=request.getParameter("deletetheaterservlet");
		}
		else if(request.getParameter("addscreenservlet")!=null) {
			name=request.getParameter("addscreenservlet");
		}
		else if(request.getParameter("updatescreenservlet")!=null) {
			name=request.getParameter("updatescreenservlet");
		}
		else if(request.getParameter("deletescreenservlet")!=null) {
			name=request.getParameter("deletescreenservlet");
		}
		else if(request.getParameter("addmovieintheaterservlet")!=null) {
			name=request.getParameter("addmovieintheaterservlet");
		}
		else if(request.getParameter("updatemovieintheaterservlet")!=null) {
			name=request.getParameter("updatemovieintheaterservlet");
		}
		else if(request.getParameter("deletemovieintheaterservlet")!=null) {
			name=request.getParameter("deletemovieintheaterservlet");
		}
		else if(request.getParameter("forgetpasswordservlet")!=null) {
			name=request.getParameter("forgetpasswordservlet");
		}
		else if(request.getParameter("changepasswordservlet")!=null) {
			name=request.getParameter("changepasswordservlet");
		}
		else if(request.getParameter("findbymovieservlet")!=null) {
			name=request.getParameter("findbymovieservlet");
		}
		else if(request.getParameter("findbytheaterservlet")!=null) {
			name=request.getParameter("findbytheaterservlet");
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
		} else if (name.equals("deletemovie")) {
			MovieDAO movieDAO = new MovieDAO();
			try {
				ArrayList<Movie> movielist = new ArrayList<>();
				movielist.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movielist);
				RequestDispatcher req = request
						.getRequestDispatcher("DeleteMovie.jsp");
				req.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("updatetheater")) {
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				ArrayList<Theater> theaterList = new ArrayList<>();
				theaterList.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterList);
				RequestDispatcher req = request
						.getRequestDispatcher("UpdateTheater.jsp");
				req.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("deletetheater")) {
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				ArrayList<Theater> theaterList = new ArrayList<>();
				theaterList.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterList);
				RequestDispatcher req = request
						.getRequestDispatcher("DeleteTheater.jsp");
				req.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("addscreen")) {
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				ArrayList<Theater> theaterlist = new ArrayList<>();
				theaterlist.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterlist);
				RequestDispatcher req = request
						.getRequestDispatcher("AddScreen.jsp");
				req.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("updatescreen")) {
			TheaterDAO theaterDAO = new TheaterDAO();
			TheaterScreenDAO theaterScreenDAO = new TheaterScreenDAO();
			try {
				ArrayList<Theater> theaterlist = new ArrayList<>();
				ArrayList<TheaterScreen> theaterscreenlist = new ArrayList<TheaterScreen>();
				theaterlist.addAll(theaterDAO.findAll());
				theaterscreenlist.addAll(theaterScreenDAO.findAll());
				request.setAttribute("THEATER", theaterlist);
				request.setAttribute("SCREEN", theaterscreenlist);
				RequestDispatcher req = request
						.getRequestDispatcher("UpdateScreen.jsp");
				req.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("deletescreen")) {
			TheaterDAO theaterDAO = new TheaterDAO();
			TheaterScreenDAO theaterScreenDAO = new TheaterScreenDAO();
			try {
				ArrayList<Theater> theaterlist = new ArrayList<>();
				ArrayList<TheaterScreen> theaterscreenlist = new ArrayList<TheaterScreen>();
				theaterlist.addAll(theaterDAO.findAll());
				theaterscreenlist.addAll(theaterScreenDAO.findAll());
				request.setAttribute("THEATER", theaterlist);
				request.setAttribute("SCREEN", theaterscreenlist);
				RequestDispatcher req = request
						.getRequestDispatcher("DeleteScreen.jsp");
				req.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("addmovieintheater")) {
			TheaterScreenDAO theaterScreenDAO = new TheaterScreenDAO();
			MovieDAO movieDAO = new MovieDAO();
			TheaterDAO theaterDAO = new TheaterDAO();
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
				RequestDispatcher req = request
						.getRequestDispatcher("AddMovieinTheater.jsp");
				req.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("updatemovieintheater")) {
			TheaterScreenDAO theaterScreenDAO = new TheaterScreenDAO();
			MovieDAO movieDAO = new MovieDAO();
			TheaterDAO theaterDAO = new TheaterDAO();
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
				RequestDispatcher req = request
						.getRequestDispatcher("UpdateMovieTheater.jsp");
				req.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("deletemovieintheater")) {
			MovieDAO movieDAO = new MovieDAO();
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				ArrayList<Theater> theaterList = new ArrayList<>();
				theaterList.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterList);
				ArrayList<Movie> movieList = new ArrayList<>();
				movieList.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movieList);
				RequestDispatcher req = request
						.getRequestDispatcher("DeleteMovieinTheater.jsp");
				req.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("findbytheater")) {
			MovieDAO movieDAO = new MovieDAO();
			try {
				ArrayList<Movie> movielist = new ArrayList<>();
				movielist.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movielist);
				RequestDispatcher rd = request
						.getRequestDispatcher("FindbyTheater.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("findbymovie")) {
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				ArrayList<Theater> theaterlist = new ArrayList<>();
				theaterlist.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterlist);
				RequestDispatcher rd = request
						.getRequestDispatcher("FindbyMovie.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("bookmovie")) {
			MovieDAO movieDAO = new MovieDAO();
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				List<Movie> movielist = new ArrayList<>();
				List<Theater> theaterlist = new ArrayList<Theater>();
				movielist.addAll(movieDAO.findAll());
				theaterlist.addAll(theaterDAO.findAll());
				request.setAttribute("MOVIE", movielist);
				request.setAttribute("THEATER", theaterlist);
				RequestDispatcher rd = request
						.getRequestDispatcher("BookingMovie.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (name.equals("changepassword")) {
			HttpSession session = request.getSession(false);
			session.getAttribute("NAME");
			RequestDispatcher rd = request
					.getRequestDispatcher("ChangePassword.jsp");
			rd.forward(request, response);
		}
		else if (name.equals("addmovieservlet")) {
			String moviename = request.getParameter("moviename");
			Movie movie = new Movie();
			movie.setName(moviename);
			MovieDAO movieDAO = new MovieDAO();
			try {
				if (moviename.isEmpty()) {
					request.setAttribute("MESSAGE", "Type Movie Name");
					RequestDispatcher rd = request
							.getRequestDispatcher("AddMovie.jsp");
					rd.forward(request, response);
				} else {
					Boolean isActive = movieDAO.findByName(moviename);
					if (isActive) {
						request.setAttribute("MESSAGE",
								"Already Added this Movie");
						RequestDispatcher rd = request
								.getRequestDispatcher("AddMovie.jsp");
						rd.forward(request, response);
					} else {
						movieDAO.addMovie(movie);
						ArrayList<Movie> movielist = new ArrayList<>();
						movielist.addAll(movieDAO.findAll());
						request.setAttribute("MOVIE", movielist);
						RequestDispatcher rd = request
								.getRequestDispatcher("ViewMovie.jsp");
						rd.forward(request, response);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("updatemovieservlet")) {
			String moviename = request.getParameter("moviename");
			String newmoviename = request.getParameter("movienamenew");
			Movie movie = new Movie();
			Movie movienew = new Movie();
			movie.setName(moviename);
			movienew.setName(newmoviename);
			MovieDAO movieDAO = new MovieDAO();
			try {
				if (moviename.equals("Invalid") && (newmoviename.isEmpty())) {
					ArrayList<Movie> movielist = new ArrayList<>();
					try {
						movielist.addAll(movieDAO.findAll());
						request.setAttribute("MOVIE", movielist);
						request.setAttribute("MESSAGE",
							"Did not choose Movie and Empty New name");
						RequestDispatcher rd = request
							.getRequestDispatcher("UpdateMovie.jsp");
						rd.forward(request, response);
					} catch (SQLException e) {
						e.printStackTrace();
					}	
				}
				else if (moviename.equals("Invalid") || (newmoviename.isEmpty())) {
					ArrayList<Movie> movielist = new ArrayList<>();
					try {
						movielist.addAll(movieDAO.findAll());
						request.setAttribute("MOVIE", movielist);
						request.setAttribute("MESSAGE",
							"Did not choose Movie or Empty New name");
						RequestDispatcher rd = request
							.getRequestDispatcher("UpdateMovie.jsp");
						rd.forward(request, response);
					} catch (SQLException e) {
						e.printStackTrace();
					}	
				}
				else if (moviename.equals("Invalid")) {
					ArrayList<Movie> movielist = new ArrayList<>();
					try {
						movielist.addAll(movieDAO.findAll());
						request.setAttribute("MOVIE", movielist);
						request.setAttribute("MESSAGE", "Did not choose Movie");
						RequestDispatcher req = request
								.getRequestDispatcher("UpdateMovie.jsp");
						req.forward(request, response);
					} catch (SQLException e) {
						e.printStackTrace();
					}	
				}
				else if (newmoviename.isEmpty()) {
					ArrayList<Movie> movielist = new ArrayList<>();
					try {
						movielist.addAll(movieDAO.findAll());
						request.setAttribute("MOVIE", movielist);
						request.setAttribute("MESSAGE", "Empty New name");
						RequestDispatcher rd = request
							.getRequestDispatcher("UpdateMovie.jsp");
						rd.forward(request, response);
					} catch (SQLException e) {
						e.printStackTrace();
					}	
				}
				else {
					movieDAO.updateMovie(movie, movienew);
					ArrayList<Movie> movielist = new ArrayList<>();
					movielist.addAll(movieDAO.findAll());
					request.setAttribute("MOVIE", movielist);
					RequestDispatcher rd = request
							.getRequestDispatcher("ViewMovie.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("deletemovieservlet")) {
			String moviename = request.getParameter("deletename");
			MovieDAO movieDAO = new MovieDAO();
			try {
				if (moviename.equals("Invalid")) {
					ArrayList<Movie> movielist = new ArrayList<>();
					movielist.addAll(movieDAO.findAll());
					request.setAttribute("MOVIE", movielist);
					request.setAttribute("MESSAGE", "Did not choose Movie name");
					RequestDispatcher rd = request
							.getRequestDispatcher("DeleteMovie.jsp");
					rd.forward(request, response);
				} else {
					movieDAO.deleteMovie(moviename);
					ArrayList<Movie> movielist = new ArrayList<>();
					movielist.addAll(movieDAO.findAll());
					request.setAttribute("MOVIE", movielist);
					RequestDispatcher rd = request
							.getRequestDispatcher("ViewMovie.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("addtheaterservlet")) {
			String theatername = request.getParameter("theatername");
			String place=request.getParameter("place");
			String ownername=request.getParameter("ownername");
			Theater theater = new Theater();
			theater.setName(theatername);
			theater.setPlace(place);
			theater.setOwnername(ownername);
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				if(theatername.isEmpty()) {
					request.setAttribute("MESSAGE", "Type Theater name");
					RequestDispatcher rd = request.getRequestDispatcher("AddTheater.jsp");
					rd.forward(request, response);
				}
				else if(place.isEmpty()) {
					request.setAttribute("MESSAGE", "Type Place name");
					RequestDispatcher rd = request.getRequestDispatcher("AddTheater.jsp");
					rd.forward(request, response);
				}
				else if(ownername.isEmpty()) {
					request.setAttribute("MESSAGE", "Type Owner name");
					RequestDispatcher rd = request.getRequestDispatcher("AddTheater.jsp");
					rd.forward(request, response);
				}
				else {
					theaterDAO.addTheater(theater);
					ArrayList<Theater> theaterList = new ArrayList<>();
					theaterList.addAll(theaterDAO.findAll());
					request.setAttribute("THEATER", theaterList);
					RequestDispatcher rd = request.getRequestDispatcher("viewTheater.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("updatetheaterservlet")) {
			String names = request.getParameter("theatername");
			String oldownername=request.getParameter("oldowner");
			System.out.println(oldownername);
			String newownername=request.getParameter("newownername");
			int length=names.length();
			int find=names.indexOf('-');
			String theatername=names.substring(find+1, length);
			Theater theater = new Theater();
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				if(newownername.isEmpty()) {
					ArrayList<Theater> theaterList = new ArrayList<>();
					theaterList.addAll(theaterDAO.findAll());
					request.setAttribute("THEATER", theaterList);
					request.setAttribute("MESSAGE", "Type New Owner name");
					RequestDispatcher rd = request.getRequestDispatcher("UpdateTheater.jsp");
					rd.forward(request, response);
				}
				else if(theatername.equals("Invalid")) {
					ArrayList<Theater> theaterList = new ArrayList<>();
					theaterList.addAll(theaterDAO.findAll());
					request.setAttribute("THEATER", theaterList);
					request.setAttribute("MESSAGE", "choose theater name then view old owner name");
					RequestDispatcher rd = request.getRequestDispatcher("UpdateTheater.jsp");
					rd.forward(request, response);
				}
				else {
					theater.setOwnername(newownername);
					theater.setName(theatername);
					theater.setOwnername(oldownername);
					theaterDAO.updateTheater(theater);
					ArrayList<Theater> theaterList = new ArrayList<>();
					theaterList.addAll(theaterDAO.findAll());
					request.setAttribute("THEATER", theaterList);
					RequestDispatcher rd = request.getRequestDispatcher("viewTheater.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("deletetheaterservlet")) {
			String theaterplace=request.getParameter("theatername");
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				if(theaterplace.equals("Invalid")) {
					ArrayList<Theater> theaterList = new ArrayList<>();
					theaterList.addAll(theaterDAO.findAll());
					request.setAttribute("THEATER", theaterList);
					request.setAttribute("MESSAGE", "Choose Theater Name");
					RequestDispatcher rd = request.getRequestDispatcher("DeleteTheater.jsp");
					rd.forward(request, response);
				}
				else {
					int length=theaterplace.length();
					int pos=theaterplace.indexOf('-');
					String theatername = theaterplace.substring(0, pos);
					String place=theaterplace.substring(pos+1,length);
					theaterDAO.deleteTheater(theatername,place);
					ArrayList<Theater> theaterList = new ArrayList<>();
					theaterList.addAll(theaterDAO.findAll());
					request.setAttribute("THEATER", theaterList);
					RequestDispatcher rd = request.getRequestDispatcher("viewTheater.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("addscreenservlet")) {
			Theater theater=new Theater();
			int theaterid=Integer.parseInt(request.getParameter("theatername"));
			String screen=request.getParameter("screen");
			int seats=Integer.parseInt(request.getParameter("total"));
			TheaterScreen theaterScreen=new TheaterScreen();
			theater.setId(theaterid);
			theaterScreen.setTheater(theater);
			theaterScreen.setScreen(screen);
			theaterScreen.setTotalTicket(seats);
			TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
			try {
				if(theaterid==-1) {
					ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
					theaterscreenlist.addAll(theaterScreenDAO.findAll());
					request.setAttribute("MESSAGE", "Choose Theater name");
					request.setAttribute("THEATERSCREEN", theaterscreenlist);
					RequestDispatcher rd=request.getRequestDispatcher("AddScreen.jsp");
					rd.forward(request, response);
				}
				else if(screen.isEmpty()) {
					ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
					theaterscreenlist.addAll(theaterScreenDAO.findAll());
					request.setAttribute("MESSAGE", "Type Screen");
					request.setAttribute("THEATERSCREEN", theaterscreenlist);
					RequestDispatcher rd=request.getRequestDispatcher("AddScreen.jsp");
					rd.forward(request, response);
				}
				else if(seats<0) {
					ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
					theaterscreenlist.addAll(theaterScreenDAO.findAll());
					request.setAttribute("MESSAGE", "Negative Not Allowed");
					request.setAttribute("THEATERSCREEN", theaterscreenlist);
					RequestDispatcher rd=request.getRequestDispatcher("AddScreen.jsp");
					rd.forward(request, response);
				}
				else {
					theaterScreenDAO.addScreen(theaterScreen);
					ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
					theaterscreenlist.addAll(theaterScreenDAO.findAll());
					request.setAttribute("THEATERSCREEN", theaterscreenlist);
					RequestDispatcher rd=request.getRequestDispatcher("viewTheaterScreen.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("updatescreenservlet")) {
			Theater theater=new Theater();
			String theaterid=request.getParameter("theatername");
			String screen=request.getParameter("screen");
			int total=Integer.parseInt(request.getParameter("total"));
			theater.setId(Integer.parseInt(theaterid));
			TheaterScreen theaterScreen=new TheaterScreen();
			theaterScreen.setTheater(theater);
			theaterScreen.setScreen(screen);
			theaterScreen.setTotalTicket(total);
			TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
			try {
				theaterScreenDAO.updateTheaterScreen(theaterScreen);
				ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
				theaterscreenlist.addAll(theaterScreenDAO.findAll());
				request.setAttribute("THEATERSCREEN", theaterscreenlist);
				RequestDispatcher rd=request.getRequestDispatcher("viewTheaterScreen.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("deletescreenservlet")) {
			Theater theater=new Theater();
			String theaterid=request.getParameter("theatername");
			String screen=request.getParameter("screen");
			theater.setId(Integer.parseInt(theaterid));
			TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
			try {
				if(theaterid.isEmpty()) {
					
				}
				theaterScreenDAO.deleteTheaterScreen(theater.getId(),screen);
				ArrayList<TheaterScreen> theaterscreenlist=new ArrayList<TheaterScreen>();
				theaterscreenlist.addAll(theaterScreenDAO.findAll());
				request.setAttribute("THEATERSCREEN", theaterscreenlist);
				RequestDispatcher rd=request.getRequestDispatcher("viewTheaterScreen.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("addmovieintheaterservlet")) {
			MovieInTheater movieintheater=new MovieInTheater();
			Theater theater=new Theater();
			Movie movie=new Movie();
			TheaterScreen theaterScreen=new TheaterScreen();
			TheaterScreenDAO theaterScreenDAO=new TheaterScreenDAO();
			int theaterid=Integer.parseInt(request.getParameter("theatername"));
			theater.setId(theaterid);
			int movieid=Integer.parseInt(request.getParameter("moviename"));
			movie.setId(movieid);
			movieintheater.setTheater(theater);
			movieintheater.setMovie(movie);
			movieintheater.setShow(request.getParameter("show"));
			LocalDate date=LocalDate.parse(request.getParameter("date"));
			movieintheater.setDate(date);
			try {
				TheaterScreen theaterScreen2=theaterScreenDAO.findByScreen(request.getParameter("screen"));
				theaterScreen.setId(theaterScreen2.getId());
				movieintheater.setTheaterscreen(theaterScreen);
				movieintheater.setAmount(Integer.parseInt(request.getParameter("amount")));
				MovieTheaterDAO movieTheaterDAO=new MovieTheaterDAO();
				try {
						movieTheaterDAO.addMovieTheater(movieintheater);
						ArrayList<MovieInTheater> viewlist=new ArrayList<MovieInTheater>();
						viewlist.addAll(movieTheaterDAO.joinviewList());
						request.setAttribute("MOVIEINTHEATER", viewlist);
						RequestDispatcher rd=request.getRequestDispatcher("viewMovieinTheater.jsp");
						rd.forward(request, response);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(name.equals("updatemovieintheaterservlet")) {
			
		}
		else if(name.equals("deletemovieintheaterservlet")) {
			
		}
		else if(name.equals("forgetpasswordservlet")) {
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			Long phone=Long.parseLong(request.getParameter("phonenumber"));
			Register register=new Register();
			RegisterDAO registerDAO=new RegisterDAO();
			register.setName(username);
			register.setEmail(email);
			register.setPhonenumber(phone);
			Boolean isActive=registerDAO.checkForgetPassword(register);
			if(isActive)
			{
				try {
					Register register2=new Register();
					register2=registerDAO.findByEmail(email);
					String password="Your Password is "+register2.getPassword();
					request.setAttribute("USERS", password);
					RequestDispatcher rd=request.getRequestDispatcher("ForgetPassword.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Failed");
			}
		}
		else if(name.equals("changepasswordservlet")) {
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
		else if(name.equals("findbymovieservlet")) {
			TheaterDAO theaterDAO = new TheaterDAO();
			try {
				ArrayList<Theater> theaterlist = new ArrayList<>();
				theaterlist.addAll(theaterDAO.findAll());
				request.setAttribute("THEATER", theaterlist);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String names=request.getParameter("theatername");
			int length=names.length();
			int pos=names.indexOf('.');
			int poss=names.indexOf('-');
			String theaterid=(names.substring(0, pos));
			String theatername = names.substring(pos+1, poss);
			String place=names.substring(poss+1,length);
			MovieTheaterDAO movieTheaterDAO=new MovieTheaterDAO();
			ArrayList<MovieInTheater> listtheater=new ArrayList<MovieInTheater>();
			try {
				listtheater.addAll(movieTheaterDAO.findbyMovie(Integer.parseInt(theaterid)));
				request.setAttribute("THEATERLIST", listtheater);
				RequestDispatcher rd=request.getRequestDispatcher("FindbyMovie.jsp");
				rd.forward(request, response);
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(name.equals("findbytheaterservlet")) {
			MovieDAO movieDAO = new MovieDAO();
			try {
				ArrayList<Movie> movielist = new ArrayList<>();
				movielist.addAll(movieDAO.findAll());
				request.setAttribute("MOVIE", movielist);
			} catch (Exception e) {
				e.printStackTrace();
			}
			int movieid=Integer.parseInt(request.getParameter("moviename"));
			MovieTheaterDAO movieTheaterDAO=new MovieTheaterDAO();
			ArrayList<MovieInTheater> listtheater=new ArrayList<MovieInTheater>();
			try {
				listtheater.addAll(movieTheaterDAO.findbyTheater(movieid));
				request.setAttribute("THEATERLIST", listtheater);
				RequestDispatcher rd=request.getRequestDispatcher("FindbyTheater.jsp");
				rd.forward(request, response);
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
