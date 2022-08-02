package com.impact.day2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		List<Show> list = new ArrayList<Show>();

		ShowManager showManager = new ShowManagerImpl();
		list = showManager.populate("show.txt");
		if (list != null) {
			displayShow(list);
			try {
				String showName = "Thor";
				String showTime = "11:00pm";
				int noOfSeats = 2;
				System.out.println("Booking " + noOfSeats + " tickets for " + showName + " at " + showTime + ".....");
				//Booking show
				showManager.bookShow(list, showName, showTime, noOfSeats);
				System.out.println("Booking sucessfull");
				displayShow(list);
			} catch (InvalidShowTimeException invalidShowTimeException) {
				System.out.println(invalidShowTimeException.getMessage());
			} catch (SeatsNotAvailableException seatsNotAvailableException) {
				System.out.println(seatsNotAvailableException.getMessage());
			} catch (UnknownShowException unknownShowException) {
				System.out.println(unknownShowException.getMessage());
			}
		}

	}

	/**
	 * Display list
	 * @param list
	 */
	private static void displayShow(List<Show> list) {
		ShowDisplay display = new ShowImpl();
		System.out.println("SHOWS ARE AS FOLLOWS::");
		display.displayAllShows(list);
		System.out.println("====================================");
	}

}
