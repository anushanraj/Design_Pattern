package com.impact.problem5;

import java.util.HashSet;
import java.util.Set;

import com.impact.problem5.dao.AssetsDao;
import com.impact.problem5.dao.EmployeeDao;
import com.impact.problem5.model.Assets;
import com.impact.problem5.model.Employee;

/**
 * 
 *
 */
public class App {
	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDao();
		AssetsDao assetsDao = new AssetsDao();

		Assets a1 = new Assets(1, 1001, 1, "Laptop", 59000, "Bangalore");
		Assets a2 = new Assets(2, 1002, 2, "Headphone", 1000, "Pune");

		Set<Assets> s1 = new HashSet<Assets>();
		s1.add(a1);
		s1.add(a2);


		Employee e1 = new Employee(101, "Jack", "jack123", s1);

		System.out.println("Add employee");
		empDao.addEmployee(e1);

		System.out.println("Get asset by Id");
		assetsDao.getAssetById(101);

		System.out.println("Get max price asset");
		assetsDao.getMaxPriceAsset();

		System.out.println("Get Employee count");
		empDao.getEmployeeCount();

		System.out.println("Get all employees");
		empDao.getEmployees();

		System.out.println("Get employee by Id");
		empDao.getEmployeeById(101);

		System.out.println("Get avg asset price");
		assetsDao.getAvgAssetPrice();
		
		System.out.println("update Employee");
		empDao.updatePassword("newpassword", 101);
		
		System.out.println("Delete employee by Id");
		empDao.deleteEmployee(101);

	}
}
