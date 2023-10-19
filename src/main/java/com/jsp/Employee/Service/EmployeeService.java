package com.jsp.Employee.Service;

import java.util.List;

import com.jsp.Employee.Dao.EmployeeDao;
import com.jsp.Employee.Dto.Employee;

public class EmployeeService {
	EmployeeDao employeeDao = new EmployeeDao();

	public Employee saveEmployee(Employee employee) {
		if (employee.getName() != null && employee.getEmail() != null && employee.getGender() != null
				&& employee.getSalary() > 0) {
			return employeeDao.saveEmployee(employee);
	
		}
		return null;
	}
	
	public boolean deleteEmployeeById(int id) {
		return employeeDao.deleteEmployeeById(id);
	}
	
	public List<Employee> getAllEmployee(){
		return employeeDao.getAllEmployee();
	}
	
	public Employee getEmployeeById(int id) {
		 if(id>0) {
			 return employeeDao.getEmployeeById(id);
		 }else {
			 return null;
		 }
	}
	
	public Employee updateEmpByIdEmail(int id,String email,String old_email) {
		   Employee employee=employeeDao.getEmployeeById(id);
		   if(employee.getEmail().equals(old_email)) {
			   employee.setEmail(email);
		   }
		   return employeeDao.updateEmpByEmail(employee, id);
		}
	

	}
		
	

