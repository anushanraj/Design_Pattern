package com.impact.problem4Agg;

import java.util.Scanner;

import org.hibernate.HibernateException;

import com.impact.problem4Agg.dao.MovieDAO;

/**
 * Film Corporation
 *
 */
public class App {
	private static String[] options = { "1- Find Maximum Revenue", "2- Find Minimum Revenue", "3- Find Sum of Revenue",
			"4- Find Average of Revenue", "5- Find the number of movies By langauge", "6- Exit" };

	public static void main(String[] args) {
		System.out.println("------------Starting Application -----------");

		try (Scanner scanner = new Scanner(System.in)) {
			boolean flag = true;
			while (flag) {
				printMenu(options);
				try {
					int option = scanner.nextInt();
					excecute(option);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					flag = true;
				}
			}
		}
	}

	public static void printMenu(String[] options) {
		System.out.println("Options: ");
		for (String option : options) {
			System.out.println(option);
		}
	}

	@SuppressWarnings("resource")
	public static void excecute(int option) throws IllegalArgumentException {
		Scanner scanner = new Scanner(System.in);
		MovieDAO movieDAO = new MovieDAO();
		try {
			switch (option) {
			case 1: {
				movieDAO.getMaximumMovieRevenue();
				break;
			}
			case 2: {
				movieDAO.getMinimumMovieRevenue();
				break;
			}
			case 3: {
				movieDAO.getSumOfRevenue();
				break;
			}
			case 4: {
				movieDAO.getAverageOfRevenue();
				break;
			}
			case 5: {
				movieDAO.getMovieCountByLanguage();
				break;
			}
			case 6: {
				System.out.println("------------Existing Application -----------");
				System.exit(0);
				break;
			}

			default:
				throw new IllegalArgumentException("Please choose correct option");
			}
		} catch (HibernateException e) {
			System.out.println(e);
		}
	}
}
