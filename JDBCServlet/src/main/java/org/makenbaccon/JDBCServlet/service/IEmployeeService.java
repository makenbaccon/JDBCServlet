package org.makenbaccon.JDBCServlet.service;

import java.util.List;

import org.makenbaccon.JDBCServlet.entity.Employee;

public interface IEmployeeService {
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int employeeId);
	boolean createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(int employeeId);
}
