package com.impact.bookshow;

public class MovieDefaultDiscount implements Discount {

	@Override
	public double getDiscount(int noOfTickets) {
		if (noOfTickets < 5)
			return 0;
		else if (noOfTickets >= 5 && noOfTickets < 10) {
			return 15;
		} else if (noOfTickets >= 10 && noOfTickets <= 15) {
			return 20;
		}
		return 0;
	}

}
