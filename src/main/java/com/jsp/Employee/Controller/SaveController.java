package com.jsp.Employee.Controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.Employee.Dto.Employee;
import com.jsp.Employee.Service.EmployeeService;



@WebServlet("/save")
public class SaveController extends HttpServlet {
	EmployeeService employeeService = new EmployeeService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String salary = req.getParameter("salary");
//		req.getParameter=its return type is string thats why we write salary in string

		double sal = Double.parseDouble(salary);
//		to convert the salary
		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail(email);
		employee.setGender(gender);
		employee.setSalary(sal);

		Employee e1 = employeeService.saveEmployee(employee);
		if (e1 != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("save.jsp");
			requestDispatcher.include(req, resp);
		}

	}
}
