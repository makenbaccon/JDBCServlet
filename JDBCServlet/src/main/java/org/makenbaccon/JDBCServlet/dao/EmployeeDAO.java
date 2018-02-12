package org.makenbaccon.JDBCServlet.dao;

import java.util.List;

import org.makenbaccon.JDBCServlet.entity.Employee;
import org.makenbaccon.JDBCServlet.entity.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository

public class EmployeeDAO implements IEmployeeDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM employees";
		
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		String sql = "SELECT * FROM employees WHERE employeeId = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, employeeId);
		return employee;
	}

	@Override
	public void createEmployee(Employee employee) {
		String sql = "INSERT INTO articles (employeeId, name, phone_number, supervisors) value (?,?,?)";
		jdbcTemplate.update(sql, employee.getEmployeeId(), employee.getName(), employee.getPhoneNumber(), employee.getSupervisors());
	}

	@Override
	public void updateEmployee(Employee employee) {
		String sql = "UPDATE employees SET name=?, phone_number=?, supervisors=?";
		jdbcTemplate.update(sql, employee.getName(), employee.getPhoneNumber(), employee.getSupervisors());
	}

	@Override
	public void deleteEmployee(int employeeId) {
		String sql = "DELETE FROM employees WHERE employeeId=?";
		jdbcTemplate.update(sql, employeeId);
	}

	@Override
	public boolean employeeExists(String name, String phoneNumber, String supervisors) {
		String sql = "SELECT count(*) FROM employees WHERE name=? and phone_number=? and supervisors=?";
		int count = jdbcTemplate.queryForObject(sql,  Integer.class, name, phoneNumber, supervisors);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}

}
