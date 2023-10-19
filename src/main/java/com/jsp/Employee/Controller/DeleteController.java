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

@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	EmployeeService employeeService = new EmployeeService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("delete");
		int empid=Integer.parseInt(id);
		
		boolean e2 = employeeService.deleteEmployeeById(empid);
		if (e2==true) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("delete.jsp");
			requestDispatcher.include(req, resp);
		}
	}

}
