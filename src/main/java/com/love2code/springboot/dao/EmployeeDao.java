package com.love2code.springboot.dao;

import java.util.List;

import com.love2code.springboot.entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();
} 
