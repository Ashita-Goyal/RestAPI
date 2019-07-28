package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	
	
	public List<Employee> getAllEmp(){
		//return employees;
		List<Employee> emp = new ArrayList<>();
		empRepo.findAll().forEach(emp::add);
		return emp;
	}
	
	public Employee getEmp(int id) {
		//return employees.stream().filter(t -> t.getEmp_id()==id).findFirst().get();
		return empRepo.findById(id).orElse(null);
	}

	public void addEmp(Employee emp) {
		//employees.add(emp);
		empRepo.save(emp);
	}

	@Transactional
	public void updateEmp(int emp_id, Employee emp) {
		/*
		for(int i=0;i<employees.size();i++) {
			Employee e= employees.get(i);
			if(e.getEmp_id()==id) {
				employees.set(i, emp);
				return;
			}
		}*/
		Employee e=empRepo.findById(emp_id).orElse(new Employee());
		e.setEmp_name(emp.getEmp_name());
		e.setEmp_dept(emp.getEmp_dept());
		e.setEmp_id(emp_id);
		empRepo.save(e);
	
	}

	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}
}
