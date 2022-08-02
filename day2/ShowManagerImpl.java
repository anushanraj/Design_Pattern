package com.impact.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShowManagerImpl implements ShowManager {

	@Override
	public List<Show> populate(String fileName) {

		try (Stream<String> lines = Files.lines(Path.of(fileName))) {

			List<Show> shows = lines.map(line -> {
				String[] arr = line.trim().split("\\s*,\\s*");
				return new Show(arr[0], arr[1], Integer.parseInt(arr[2]));
			}).collect(Collectors.toList());

			return shows;
		} catch (IOException e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats)
			throws SeatsNotAvailableException, UnknownShowException, InvalidShowTimeException {
		if (!showList.stream().anyMatch(show -> show.getShowName().equals(showName))) {
			throw new UnknownShowException("Unknown Show name");
		} else {
			Optional<Show> showToBook = showList.stream().filter(show -> show.getShowName().equals(showName))
					.filter(s -> s.getShowTime().equals(show_time)).findAny();

			if (showToBook.isEmpty()) {
				throw new InvalidShowTimeException("Show not available on this time");
			} else if (showToBook.get().getSeatsAvailable() < noOfSeats) {
				throw new SeatsNotAvailableException("Seats not available");
			} else {
				showList=showList.stream().filter(show -> show.getShowName().equals(showName))
						.filter(s -> s.getShowTime().equals(show_time))
						.peek(show -> show.setSeatsAvailable(show.getSeatsAvailable() - noOfSeats))
					    .collect(Collectors.toList());
			}
		}

	}

}
