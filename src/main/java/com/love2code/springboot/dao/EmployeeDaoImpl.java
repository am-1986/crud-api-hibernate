package com.love2code.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	@Override
	public Employee findById(int id) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Employee employee = currentSession.get(Employee.class, id);
		
		// return the employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> query = currentSession.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
		
	}

	

}
