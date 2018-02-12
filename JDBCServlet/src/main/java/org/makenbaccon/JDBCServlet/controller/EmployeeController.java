package org.makenbaccon.JDBCServlet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import org.makenbaccon.JDBCServlet.entity.Employee;
import org.makenbaccon.JDBCServlet.service.IEmployeeService;

@Controller
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200"})

public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("employee")
	public ResponseEntity<Employee> getEmployeeById(@RequestParam("id") String id) {
		Employee employee = employeeService.getEmployeeById(Integer.parseInt(id));
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping("all-employees")
	public ResponseEntity<List<Employee>> getAllArticles() {
		List<Employee> list = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
	
	@PostMapping("employee")
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder builder) {
        boolean flag = employeeService.createEmployee(employee);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/employee?id={id}").buildAndExpand(employee.getEmployeeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("employee")
	public ResponseEntity<Employee> updateArticle(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("employee")
	public ResponseEntity<Void> deleteEmployee(@RequestParam("id") String id) {
		employeeService.deleteEmployee(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
