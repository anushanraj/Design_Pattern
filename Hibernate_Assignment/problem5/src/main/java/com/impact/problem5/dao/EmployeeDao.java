package com.impact.problem5.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.impact.problem5.model.Employee;
import com.impact.problem5.util.HibernateUtil;

public class EmployeeDao {

	public void addEmployee(Employee emp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trascation = session.beginTransaction();
		Serializable id = session.save(emp);
		trascation.commit();
		System.out.println("Employee with id " + id + " is successfully added.");
		session.close();
	}

	public void deleteEmployee(int empId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trascation = session.beginTransaction();
		Query query = session.createQuery("delete from Employee e where e.empId=?1");
		query.setParameter(1, empId);
		int rows = query.executeUpdate();
		System.out.println(rows + " deleted");
		trascation.commit();
		session.close();
	}

	public void updatePassword(String newPassword, int empId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trascation = session.beginTransaction();
		Query query = session.createQuery("update Employee e set e.password=?1 " + " where e.empId=?2");
		query.setParameter(1, newPassword);
		query.setParameter(2, empId);
		int rows = query.executeUpdate();
		System.out.println(rows + " updated");
		trascation.commit();
		session.close();
	}

	public void getEmployeeCount() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trascation = session.beginTransaction();
		Query<Long> query = session.createQuery("select count(*) from Employee");
		long count = query.getResultList().get(0);
		System.out.println("count of Employees is " + count);
		trascation.commit();
		session.close();
	}

	public void getEmployees() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query selQuery = session.createQuery("select e from Employee e order by e.empName desc ");
		List<Employee> employees = selQuery.getResultList();
		System.out.println("Employees list in descending order of name");

		for (Employee employee : employees) {
			System.out.println(employee);
		}
		session.close();
	}

	public void getEmployeeById(int empId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee = session.get(Employee.class, empId);
		System.out.println(employee);
		session.close();
	}

}
