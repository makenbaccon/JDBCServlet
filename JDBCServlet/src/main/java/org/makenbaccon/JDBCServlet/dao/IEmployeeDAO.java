package org.makenbaccon.JDBCServlet.dao;

import java.util.List;

import org.makenbaccon.JDBCServlet.entity.Employee;

public interface IEmployeeDAO {
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int employeeId);
    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    boolean employeeExists(String name, String phoneNumber, String supervisors);
}
