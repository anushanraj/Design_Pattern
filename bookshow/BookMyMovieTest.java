package com.impact.bookshow;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class BookMyMovieTest {

	@Test
	public void bookMyMovie101() {
		BookMyMovie bookMyMovie = new BookMyMovie(101, 5, 0, 0);
		bookMyMovie.calculateTicketAmount();
		assertEquals(510.0, bookMyMovie.getTotalAmount(), 0);
	}

	@Test
	public void bookMyMovie102Ticket4() {
		BookMyMovie bookMyMovie = new BookMyMovie(102, 4, 0, 0);
		bookMyMovie.calculateTicketAmount();
		assertEquals(680.0, bookMyMovie.getTotalAmount(), 0);
	}

	@Test
	public void bookMyMovie103Ticket8() {
		BookMyMovie bookMyMovie = new BookMyMovie(103, 8, 0, 0);
		bookMyMovie.calculateTicketAmount();
		assertEquals(1020.0, bookMyMovie.getTotalAmount(), 0);
	}

	@Test
	public void inValidMovieBooking() {
		ByteArrayOutputStream err = new ByteArrayOutputStream();
		PrintStream originalErr = System.err;
		System.setErr(new PrintStream(err));
		BookMyMovie bookMyMovie = new BookMyMovie(1031, 8, 0, 0);
		bookMyMovie.calculateTicketAmount();
		assertEquals("Sorry! Invalid Movie ID!.Please check the Movie ID and enter once again", err.toString().trim());
		System.setErr(originalErr);
	}

}
