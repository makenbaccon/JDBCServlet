package org.makenbaccon.JDBCServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JDBCServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(JDBCServletApplication.class, args);
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;
}
