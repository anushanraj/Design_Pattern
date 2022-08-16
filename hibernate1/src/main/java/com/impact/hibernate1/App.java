package com.impact.hibernate1;

import java.util.Scanner;

import org.hibernate.HibernateException;

import com.impact.hibernate1.dao.CustomerDAO;
import com.impact.hibernate1.model.Customer;

/**
 * Demo
 *
 */
public class App {
	public static void main(String[] args) {

		CustomerDAO customerDAO = new CustomerDAO();
		try {
			/** Create code **/
			System.out.println("CREATE");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Customer ID");
			int id = scanner.nextInt();
			System.out.println("Enter the Customer name");
			String name = scanner.next();
			Customer customer = new Customer(id, name);
			customerDAO.addCustomer(customer);
			System.out.println("One record Created");

			/** Read code **/
			System.out.println("READ");
			System.out.println("Enter the Customer ID to read");
			int id1 = scanner.nextInt();
			customerDAO.getCustomer(id1);

			/** Update code **/
			System.out.println("Update");
			System.out.println("Enter the Customer ID and new name of Customer");
			System.out.println("Enter the Customer ID");
			int id2 = scanner.nextInt();
			System.out.println("Enter the Customer name");
			String name1 = scanner.next();
			customerDAO.updateCustomer(id2, name1);
			System.out.println("Updated");

			/** Delete code **/
			System.out.println("DELETE");
			System.out.println("Enter the Customer ID to delete");
			int deleteId = scanner.nextInt();
			customerDAO.deleteCustomer(deleteId);
			System.out.println("deleted");
			scanner.close();

		} catch (HibernateException e) {
			System.out.println("Exception " + e);
		}
	}
}
