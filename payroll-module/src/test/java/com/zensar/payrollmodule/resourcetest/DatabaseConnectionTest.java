package com.zensar.payrollmodule.resourcetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseConnectionTest {
	
	

	//@Value("${spring.datasource.username}")
	private String username="root";
	
	//@Value("${spring.datasource.password}")
	private String password="Temp1234";
	
	//@Value("${spring.datasource.url}")
	private String url="jdbc:mysql://localhost:3306/payroll";
	
	String query ="SELECT * FROM employee";
	
	
	@Test
	public void getDatabaseConnection()  throws SQLException{

			Connection con = DriverManager.getConnection(url,username,password);
			
			Statement statement = con.createStatement();
			 
			boolean b = statement.execute(query);
			
			//when(statement.execute(query)).thenReturn(true);
			assertEquals(true, statement.execute(query));
	}
}
