package com.chainsys.movieapplication.model;

import java.time.LocalDate;

public class MovieInTheater {
	private Movie movie;
	private Theater theater;
	private String show;
	private LocalDate date;
	private TheaterScreen theaterscreen;
	private int amount;
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public TheaterScreen getTheaterscreen() {
		return theaterscreen;
	}
	public void setTheaterscreen(TheaterScreen theaterscreen) {
		this.theaterscreen = theaterscreen;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
