package com.chainsys.movieapplication.model;

import java.time.LocalDate;

public class MovieInTheater {
	private Movie movieid;
	private Theater theaterid;
	private String show;
	private LocalDate date;
	public Movie getMovieid() {
		return movieid;
	}
	public void setMovieid(Movie movieid) {
		this.movieid = movieid;
	}
	public Theater getTheaterid() {
		return theaterid;
	}
	public void setTheaterid(Theater theaterid) {
		this.theaterid = theaterid;
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
}
