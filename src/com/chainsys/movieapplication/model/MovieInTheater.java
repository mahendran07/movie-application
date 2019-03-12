package com.chainsys.movieapplication.model;

import java.time.LocalDate;

public class MovieInTheater {
	private int id;
	private Movie movie;
	private Theater theater;
	private String show;
	private LocalDate date;
	private TheaterScreen theaterScreen;
	private String screen;
	private float amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public TheaterScreen getTheaterScreen() {
		return theaterScreen;
	}
	public void setTheaterScreen(TheaterScreen theaterScreen) {
		this.theaterScreen = theaterScreen;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
}
