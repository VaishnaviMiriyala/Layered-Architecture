package com.cg.eis.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.cg.eis.bean.Employee;
import com.cg.eisapp1.exception.EmployeeException;

public class EmployeeServiceImp implements EmployeeService {
	Set<Employee> empset = new HashSet<Employee>();
	//HashMap<String,Set<Employee>> hm = new HashMap<String,Set<Employee>>();
	public boolean insertEmployee(Employee e) throws EmployeeException{
		if(e.getSalary() > 5000 && e.getSalary() < 20000 && e.getDesignation().equals("System Associate")) {
			e.setInsuranceScheme("Scheme C");
		}else if(e.getSalary() >= 20000 && e.getSalary() < 40000 && e.getDesignation().equals("Programmer")) {
			e.setInsuranceScheme("Scheme B");
		}else if(e.getSalary() >= 40000 && e.getDesignation().equals("Manager")) {
			e.setInsuranceScheme("Scheme A");
		}else if(e.getSalary() < 5000 && e.getDesignation().equals("Clerk")) {
			e.setInsuranceScheme("No Scheme");
		}
		
		if(e.getInsuranceScheme() == null) {
			throw new EmployeeException("The Insurance Scheme is null");
		}else {
		return empset.add(e);
		}
	}

	public Set<Employee> getAllEmployees() {
		
		return empset;
	}

	public Set<Employee> getAllEmployeesByInsurance(String insurance) {
		// TODO Auto-generated method stub
		Set<Employee> tempset = new HashSet<Employee>();
        for (Employee employee : empset) {
			
			if(employee.getInsuranceScheme().equals(insurance))
			{
				tempset.add(employee);
			}
			
		}
		
		return tempset;
	}

	public Set<Employee> deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Set<Employee> tempset = new HashSet<Employee>();
		for(Employee employee : empset) {
			if(employee.getId() !=  id) {
				tempset.add(employee);
			}
		}
		return tempset;
	}
	
	public Set<Employee>  getAllEmplyeesBySalary(int range1,int range2){
		Set<Employee> tempSet = new HashSet<Employee>();
		for(Employee employee : empset) {
			if(employee.getSalary() >= range1 && employee.getSalary() <= range2) {
				tempSet.add(employee);
			}
		}
		return tempSet;
	}
	
	

}
