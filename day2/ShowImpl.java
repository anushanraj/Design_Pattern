package com.impact.day2;

import java.util.List;

public class ShowImpl implements ShowDisplay {

	@Override
	public void displayAllShows(List<Show> shows) {
		shows.forEach(System.out::println);

	}

}
