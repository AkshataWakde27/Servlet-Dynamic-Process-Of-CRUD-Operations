package com.jsp.Employee.Dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Employee.Dto.Employee;



public class EmployeeDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("devesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

//	save

	public Employee saveEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

//	delete

	public boolean deleteEmployeeById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}
		return false;

	}

//	update

	public Employee updateEmpByEmail(Employee employee,int id) {
		Employee emp=entityManager.find(Employee.class, id);
		if(emp!=null) {
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
		}
		return employee;
	}
	
//	GetAll
	public List<Employee> getAllEmployee(){
		String sql ="SELECT e from Employee e";
		Query query=entityManager.createQuery(sql);
		List<Employee> employees=query.getResultList();
		return employees;
	}
	
	//GetById
	public Employee getEmployeeById(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		if(employee!=null) {
			return employee;

		}else {
		 return null;
		}
}
}