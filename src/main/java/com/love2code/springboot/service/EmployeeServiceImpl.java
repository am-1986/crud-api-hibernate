package com.love2code.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.love2code.springboot.dao.EmployeeDao;
import com.love2code.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		return employeeDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		
		employeeDao.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		employeeDao.deleteById(id);
	}

}
