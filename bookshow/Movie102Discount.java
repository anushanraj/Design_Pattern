package com.impact.bookshow;

public class Movie102Discount implements Discount {

	@Override
	public double getDiscount(int noOfTickets) {
		if (noOfTickets < 5)
			return 0;
		else if (noOfTickets >= 5 && noOfTickets < 10) {
			return 10;
		} else if (noOfTickets >= 10 && noOfTickets <= 15) {
			return 15;
		}
		return 0;
	}

}
