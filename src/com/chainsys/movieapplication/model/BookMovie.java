package com.chainsys.movieapplication.model;

public class BookMovie {
	private int id;
	private Register register;
	private MovieInTheater movieInTheater;
	private int seats;
	private float amount;
	private TheaterScreen theaterScreen;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	public MovieInTheater getMovieInTheater() {
		return movieInTheater;
	}
	public void setMovieInTheater(MovieInTheater movieInTheater) {
		this.movieInTheater = movieInTheater;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public TheaterScreen getTheaterScreen() {
		return theaterScreen;
	}
	public void setTheaterScreen(TheaterScreen theaterScreen) {
		this.theaterScreen = theaterScreen;
	}
}
