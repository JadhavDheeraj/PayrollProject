package com.zensar.payrollmodule.servicetest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.zensar.payrollmodule.entity.Employee;
import com.zensar.payrollmodule.repository.EmployeeRepository;
import com.zensar.payrollmodule.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;

	@Mock
	EmployeeRepository employeeRepository;

	/*
	 * @Test public void getEmployeesByIdTest() { LocalDate date =
	 * LocalDate.parse("1977-04-24");
	 * when(employeeRepository.findById(1)).thenReturn(new Employee(1, "Sachin",
	 * "Tendulkar", date, "Mumbai")); assertEquals(new Employee(1, "Sachin",
	 * "Tendulkar", date, "Mumbai"), employeeRepository.findById(1)); }
	 */

	@Test
	public void addEmployeesTest() {
		LocalDate date = LocalDate.parse("1980-05-25");

		Employee employee = new Employee(2, "Rahul", "Dravid", date, "Banglore");

		when(employeeRepository.save(employee)).thenReturn(new Employee(2, "Rahul", "Dravid", date, "Banglore"));
		assertEquals(employee, employeeRepository.save(employee));

	}

	@Test
	public void updateEmployeesTest() {
		LocalDate date = LocalDate.parse("1947-08-15");

		Employee employee = new Employee(2, "Rahul", "Dravid", date, "Banglore");
		Employee employee1 = new Employee(2, "MS", "Dhoni", date, "Ranchi");

		when(employeeRepository.save(employee)).thenReturn(new Employee(2, "MS", "Dhoni", date, "Ranchi"));
		assertEquals(employee1, employeeRepository.save(employee));

	}

	@Test
	public void getAllEmployeesTest() {
		LocalDate date = LocalDate.parse("1947-08-15");

		List<Employee> list = new ArrayList<Employee>();
		Employee empOne = new Employee(1, "Sachin", "Tendulkar", date, "Mumbai");
		Employee empTwo = new Employee(2, "MS", "Dhoni", date, "Ranchi");
		Employee empThree = new Employee(3, "Rahul", "Dravid", date, "Banglore");

		list.add(empOne);
		list.add(empTwo);
		list.add(empThree);

		when(employeeRepository.findAll()).thenReturn(list);

		// test
		List<Employee> empList = (List<Employee>) employeeRepository.findAll();

		assertEquals(3, empList.size());
		verify(employeeRepository, times(1)).findAll();

	}
	
}
