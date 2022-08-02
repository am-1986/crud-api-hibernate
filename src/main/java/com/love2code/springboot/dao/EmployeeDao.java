package com.love2code.springboot.dao;

import java.util.List;

import com.love2code.springboot.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
} 
