package com.impact.problem3Hql.dao;

import java.util.List;
import java.util.Map;

import com.impact.problem3Hql.model.Movie;

public interface IMovie {

	public List<Movie> getMoviesByLanguage(String language);

	public List<Movie> getMoviesByDirector(String directorName);

	public void addMovie(Movie movie);

	public Movie getMovie(String movieId);

	public void updateRevenue(String movieId);

	public void deleteMovie(String movieName);

	public List<String> getDistinctLanguage();

	public Map<String, String> getMovieDirectorNameMap();

	public List<Movie> getAllMovie();

}
