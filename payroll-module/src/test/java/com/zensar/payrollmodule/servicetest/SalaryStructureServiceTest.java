package com.zensar.payrollmodule.servicetest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.zensar.payrollmodule.entity.SalaryStructure;
import com.zensar.payrollmodule.repository.SalaryStructureRepository;
import com.zensar.payrollmodule.service.SalaryStructureImpl;

@RunWith(MockitoJUnitRunner.class)
public class SalaryStructureServiceTest {

	@InjectMocks
	SalaryStructureImpl salaryStructureImpl;
	
	@Mock
	SalaryStructureRepository salaryStructureRepository;

	/*
	 * @Test public void getSalaryStructureByRoleIdTest() {
	 * 
	 * SalaryStructure salaryStructure = new
	 * SalaryStructure(1,"HR",18000.00,12000.00,10);
	 * 
	 * when(salaryStructureRepository.findById(1)).thenReturn(new
	 * SalaryStructure(1,"HR",18000.00,12000.00,10)); assertEquals(salaryStructure,
	 * salaryStructureRepository.findById(1)); }
	 */
	
	@Test
	public void addRoleAndSalaryTest() {
		
		SalaryStructure salaryStructure = new SalaryStructure(1,"HR",18000.00,12000.00,10);
		
		when(salaryStructureRepository.save(salaryStructure)).thenReturn(new SalaryStructure(1,"HR",18000.00,12000.00,10));
		assertEquals(salaryStructure, salaryStructureRepository.save(salaryStructure));
	}
	
	@Test
	public void updateRoleAndSalaryTest() {
		
		SalaryStructure salaryStructure = new SalaryStructure(1,"HR",18000.00,12000.00,10);
		
		SalaryStructure salaryStructure1 = new SalaryStructure(1,"Software Engineer",20000.00,15000.00,30);
		
		when(salaryStructureRepository.save(salaryStructure)).thenReturn(new SalaryStructure(1,"Software Engineer",20000.00,15000.00,30));
		assertEquals(salaryStructure1, salaryStructureRepository.save(salaryStructure));
	}
	
	@Test
	public void getAllRoleAndSalaryTest() {
		
		List<SalaryStructure> list = new ArrayList<SalaryStructure>();
		
		SalaryStructure salaryStructure1 = new SalaryStructure(1,"HR",18000.00,12000.00,10);
		SalaryStructure salaryStructure2 = new SalaryStructure(2,"Software Engineer",20000.00,15000.00,30);
		SalaryStructure salaryStructure3 = new SalaryStructure(3,"Manager",30000.00,28000.00,50);
		SalaryStructure salaryStructure4 = new SalaryStructure(4,"Tech Lead",25000.00,20000.00,25);
		
		list.add(salaryStructure1);
		list.add(salaryStructure2);
		list.add(salaryStructure3);
		list.add(salaryStructure4);
		
		when(salaryStructureRepository.findAll()).thenReturn(list);

		List<SalaryStructure> salaryStructureList = (List<SalaryStructure>) salaryStructureRepository.findAll();
		
		assertEquals(4, salaryStructureList.size());
		verify(salaryStructureRepository, times(1)).findAll();
	}
}
