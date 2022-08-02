package com.love2code.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.love2code.springboot.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	// Define fields for entity manager
	private EntityManager entityManager;
	
	// Set up constructor injection
	@Autowired
	public EmployeeDaoImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		// Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		// Execute query and get result list
		List<Employee> employees = query.getResultList();
		
		// return the result
		return employees;
	}

}
