package com.impact.problem5.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	private int empId;
	
	@Column
	private String empName;
	
	@Column
	private String password;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Assets.class)
	@JoinTable(name = "emp_assetId")
	private Set<Assets> assets;

	public Employee(int empId, String empName, String password, Set<Assets> assets) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.password = password;
		this.assets = assets;
	}

	public Employee() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Assets> getAssets() {
		return assets;
	}

	public void setAssets(Set<Assets> assets) {
		this.assets = assets;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", password=" + password + ", assets=" + assets
				+ "]";
	}

}
