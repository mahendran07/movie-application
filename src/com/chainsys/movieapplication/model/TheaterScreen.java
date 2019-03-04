package com.chainsys.movieapplication.model;

public class TheaterScreen {
	private int id;
	private Theater theater;
	private String screen;
	private int totalTicket;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public int getTotalTicket() {
		return totalTicket;
	}
	public void setTotalTicket(int totalTicket) {
		this.totalTicket = totalTicket;
	}
}
