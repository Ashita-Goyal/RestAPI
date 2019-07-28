package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private String emp_name;
	private String emp_dept;
	
	
	
	public Employee() {
		
	}
	
	public Employee(int emp_id, String emp_name, String emp_dept) {
		super();
		this.id = emp_id;
		this.emp_name = emp_name;
		this.emp_dept = emp_dept;
	}
	public int getEmp_id() {
		return id;
	}
	public void setEmp_id(int emp_id) {
		this.id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}

}
