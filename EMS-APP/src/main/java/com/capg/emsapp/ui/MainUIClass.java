package com.capg.emsapp.ui;
import java.util.List;
import java.util.Scanner;

import com.capg.emsapp.beans.Employee;
import com.capg.emsapp.service.EmployeeServiceImpl;
import com.capg.emsapp.service.IEmployeeService;

public class MainUIClass {
	static Scanner sc;
	IEmployeeService empService;
	
	public MainUIClass() {
		empService = new EmployeeServiceImpl();
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		MainUIClass obj = new MainUIClass();
		
		
		// menu based program 
		obj.displayAllEmployee();
		while(true) {
			System.out.println("Enter the option:\n1. Insert the Employee details\n2. Get All Employee details based on Salary\n3. Get details of employee based on ID\n");
			int option = Integer.parseInt(sc.nextLine());
			switch(option) {
			case 1:obj.insertEmployeeInforamtion();
			       obj.displayAllEmployee();
			       break;
			case 2:obj.displayBasedOnEmployeeSalary();
			       break;
			case 3:obj.displayBasedOnEmployeeId();
			       break;
			}
		}
		
		
		
	}
	
	public void insertEmployeeInforamtion()
	{
		System.out.println(" \n Enter Employee Informations \n");
		System.out.println(" Enter Employee Name ");
		String empName = sc.nextLine();
		
		System.out.println(" Enter Employee Id ");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.println(" Enter Employee Salary ");
		int salary = Integer.parseInt(sc.nextLine());
		
		System.out.println(" Enter Project  Name ");
		String projectName = sc.nextLine();
		
		Employee e = new Employee(empName, id, salary, projectName);
		
		try
		{
			boolean isInserted = empService.insertEmployee(e);
			
			// -----
		}
		catch(Exception excep)
		{
			
			System.out.println(" Contact HR "+excep);
		}
		
		
	}
	
	public void displayAllEmployee()
	{
		System.out.println("\n=========== Employees Information ===========\n");
		List<Employee> empList = empService.getAllEmployees();
		
		for (Employee employee : empList) {
			displayEmployee(employee);
		}
	}
	public void displayBasedOnEmployeeSalary()
	{
		System.out.println("Enter the range of salary:");
		int range1 = Integer.parseInt(sc.nextLine());
		int range2 = Integer.parseInt(sc.nextLine());
		List<Employee> empList = empService.getAllEmployeesBySalary(range1,range2);
		
		for (Employee employee : empList) {
			displayEmployee(employee);
		}
	}
	public void displayBasedOnEmployeeId()
	{
		System.out.println("Enter the id:");
		int id = Integer.parseInt(sc.nextLine());
	    Employee emp = empService.getEmployeeById(id);
		
		displayEmployee(emp);
	}
	public void displayEmployee(Employee e)
	{
		System.out.println(" Name "+e.getEmpName());
		System.out.println(" ID "+e.getId());
		System.out.println(" Salary "+e.getSalary());
		System.out.println("\n---------------------------------------------\n");
		
		
	}

}
