package org.makenbaccon.JDBCServlet.entity;

public class Employee {
	private int employeeId;
	private String name;
	private String phoneNumber;
	private String supervisors;

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSupervisors() {
		return supervisors;
	}
	public void setSupervisors(String supervisors) {
		this.supervisors = supervisors;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Employee[id=%d, name='%s', phone_number='%s', supervisors='s']",
				employeeId, name, phoneNumber, supervisors);
	}
}
