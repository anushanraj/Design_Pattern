package com.impact.problem1.dao;

import com.impact.problem1.model.Movie;

public interface IMovie {

	public void addMovie(Movie movie);

	public Movie getMovie(String movieId);

	public void updateMovie(String movieId,Integer revenueInDollar);

	public void deleteMovie(String movieId);

}
