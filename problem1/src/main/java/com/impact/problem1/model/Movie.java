package com.impact.problem1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	private String movieId;

	private String movieName;

	private String language;

	private int realeasedIn;

	private int revenueInDollar;

	public Movie() {

	}

	public Movie(String movieId, String movieName, String language, int realeasedIn, int revenueInDollar) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.language = language;
		this.realeasedIn = realeasedIn;
		this.revenueInDollar = revenueInDollar;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getrealeasedIn() {
		return realeasedIn;
	}

	public void setrealeasedIn(int realeasedIn) {
		this.realeasedIn = realeasedIn;
	}

	public int getRevenueInDollar() {
		return revenueInDollar;
	}

	public void setRevenueInDollar(int revenueInDollar) {
		this.revenueInDollar = revenueInDollar;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", realeasedIn="
				+ realeasedIn + ", revenueInDollar=" + revenueInDollar + "]";
	}

}
