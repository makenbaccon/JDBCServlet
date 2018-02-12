package org.makenbaccon.JDBCServlet.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeId(row.getInt("employeeId"));
		employee.setName(row.getString("name"));
		employee.setPhoneNumber(row.getString("phoneNumber"));
		employee.setSupervisors(row.getString("supervisors"));
		
		return employee;
	}

}
