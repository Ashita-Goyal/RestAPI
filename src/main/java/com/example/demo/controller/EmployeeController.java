package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employees")
	public List<Employee> getAllEmp(){
		
		return employeeService.getAllEmp();
	}
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employeeService.getEmp(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/employees")
	public void addEmp(@RequestBody Employee emp) {
		employeeService.addEmp(emp);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employees/{emp_id}")
	public void updateEmp(@RequestBody Employee emp, @PathVariable int emp_id){
		
		employeeService.updateEmp(emp_id,emp);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmp(id);
	}
}
