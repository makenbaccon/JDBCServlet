package org.makenbaccon.JDBCServlet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.makenbaccon.JDBCServlet.dao.IEmployeeDAO;
import org.makenbaccon.JDBCServlet.entity.Employee;

@Service

public class EmployeeService implements IEmployeeService{

	@Autowired
	private IEmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Employee obj = employeeDAO.getEmployeeById(employeeId);
		return obj;
	}

	@Override
	public synchronized boolean createEmployee(Employee employee) {
		if (employeeDAO.employeeExists(employee.getName(), employee.getPhoneNumber(), employee.getSupervisors())) {
	    	   return false;
	       } else {
	    	   employeeDAO.createEmployee(employee);
	    	   return true;
	       }
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
		
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeDAO.deleteEmployee(employeeId);
		
	}

}
