package com.love2code.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.love2code.springboot.dao.EmployeeDao;
import com.love2code.springboot.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeRestController(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}
}
