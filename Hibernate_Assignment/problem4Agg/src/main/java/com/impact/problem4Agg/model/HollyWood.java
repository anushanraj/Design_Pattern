package com.impact.problem4Agg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HollyWood {

	@Id
	@Column(name = "MOVIEID")
	private String movieId;

	@Column(name = "MOVIENAME")
	private String movieName;

	@Column(name = "LANGUAGE")
	private String language;

	@Column(name = "RELEASEDIN")
	private Integer releasedIn;

	@Column(name = "REVENUEINDOLLARS")
	private Integer revenueInDollars;

	public HollyWood() {
	}

	public HollyWood(String movieId, String movieName, String language, Integer releasedIn, Integer revenueInDollars) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.language = language;
		this.releasedIn = releasedIn;
		this.revenueInDollars = revenueInDollars;
	}

	public HollyWood(Movie movie) {
		this.movieId = movie.getMovieId();
		this.movieName = movie.getMovieName();
		this.language = movie.getLanguage();
		this.releasedIn = movie.getReleasedIn();
		this.revenueInDollars = movie.getRevenueInDollars();
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

	public Integer getReleasedIn() {
		return releasedIn;
	}

	public void setReleasedIn(Integer releasedIn) {
		this.releasedIn = releasedIn;
	}

	public Integer getRevenueInDollars() {
		return revenueInDollars;
	}

	public void setRevenueInDollars(Integer revenueInDollars) {
		this.revenueInDollars = revenueInDollars;
	}

	@Override
	public String toString() {
		return "HollyWood [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", releasedIn="
				+ releasedIn + ", revenueInDollars=" + revenueInDollars + "]";
	}

}
