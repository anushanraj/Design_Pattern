package com.impact.problem1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;

import com.impact.problem1.dao.MovieDAO;
import com.impact.problem1.model.Movie;

/**
 * User Interface
 *
 */
public class UserUI {

	private static List<String> menu = Arrays.asList("1. Add Movie", "2. Get Movie Details", "3. Update Movie Revenue",
			"4. Delete Movie", "0. Exit");

	public static void main(String[] args) {
		System.out.println("Welcome to Movie Worl!!");
		printLine();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Please Select the option");
			print(menu);
			printLine();
			int option = sc.nextInt();
			if (option == 0) {
				flag = false;
			} else {
				execute(option);
			}
		}
		System.out.println("Existing.......");
		System.exit(0);
	}

	private static void execute(int option) {
		Scanner scanner = new Scanner(System.in);
		MovieDAO dao = new MovieDAO();
		try {
			switch (option) {
			case 1:
				/** Create code **/
				System.out.println("CREATE");

				System.out.println("Enter the Movie ID");
				String id = scanner.next();
				System.out.println("Enter the Movie name");
				String name = scanner.next();
				System.out.println("Enter the Language");
				String language = scanner.next();
				System.out.println("Enter the released year");
				int year = scanner.nextInt();
				System.out.println("Enter the revenue");
				int revenue = scanner.nextInt();
				Movie createMovie = new Movie(id, name, language, year, revenue);
				dao.addMovie(createMovie);
				System.out.println("One record Created");

				break;

			case 2:
				System.out.println("READ");
				System.out.println("Enter the Movie ID");
				String movieId = scanner.next();
				Movie getMovie = dao.getMovie(movieId);
				System.out.println(getMovie);
				break;

			case 3:
				System.out.println("UPDATE");
				System.out.println("Enter the Movie ID");
				String id1 = scanner.next();
				System.out.println("Enter the additional revenue");
				int revenue1 = scanner.nextInt();
				dao.updateMovie(id1, revenue1);
				System.out.println("Updated");
				break;

			case 4:
				System.out.println("DELETE");
				System.out.println("Enter the Movie ID to delete");
				String deleteId = scanner.next();
				dao.deleteMovie(deleteId);
				System.out.println("deleted");
				break;
			default:
				System.out.println("Select correct option");
				break;
			}
		} catch (HibernateException e) {
			System.out.println("Exception " + e);
		}
	}

	private static void print(List<String> input) {
		input.forEach(System.out::println);
	}

	private static void printLine() {
		System.out.println("======================================");

	}

}
