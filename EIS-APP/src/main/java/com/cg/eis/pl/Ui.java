package com.cg.eis.pl;
import java.util.Scanner;
import java.util.Set;
import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImp;
public class Ui {
	
	static Scanner sc;
	EmployeeService empService;
	public Ui() {
		empService = new EmployeeServiceImp();
		sc = new Scanner(System.in);
	}
	public static void main(String[] args) {
		Ui obj = new Ui();
		while(true) {
			System.out.println("Enter the option:\n1. Insert the Employee details\n2. Get All Employee details based on Insurance\n3. Delete employee details based on ID\n4. Get all Employee details based on Salary\n");
			int option = Integer.parseInt(sc.nextLine());
			switch(option) {
			case 1:obj.insertEmployeeInforamtion();
			       break;
			case 2:obj.displayBasedOnEmployeeInsurance();
			       break;
			case 3:obj.displayBasedOnDeleteEmployeeId();
			       obj.displayAllEmployee();
			       break;
			case 4:obj.displayBasedOnSalary();
			       break;
			}
		}
		
	}
	
	public void insertEmployeeInforamtion()
	{
		System.out.println(" \n Enter Employee Informations \n");
		System.out.println(" Enter Employee Id ");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.println(" Enter Employee Name ");
		String empName = sc.nextLine();
		
		System.out.println(" Enter Employee Salary ");
		int salary = Integer.parseInt(sc.nextLine());
		
		System.out.println(" Enter Designation ");
		String designation = sc.nextLine();
		
		
		Employee e = new Employee(id,empName,salary, designation);
		try {
	        boolean  isInserted = empService.insertEmployee(e);
	        if(isInserted) {
	   	    	displayAllEmployee();
	   	    }
	    
		}
		catch(Exception exception){
			System.out.println(exception);
		}
	  

	}
	
	public void displayAllEmployee()
	{
		System.out.println("\n=========== Employees Information ===========\n");
		Set<Employee> empset = empService.getAllEmployees();
		
		for (Employee employee : empset) {
			
			displayEmployee(employee);
		}
	}
	public void displayBasedOnEmployeeInsurance()
	{
		System.out.println("Enter the Insurance:");
		String insurance = sc.nextLine();
		Set<Employee> empSet = empService.getAllEmployeesByInsurance(insurance);
		
		for (Employee employee : empSet) {
			displayEmployee(employee);
		}
	}
	public void displayBasedOnDeleteEmployeeId()
	{
		System.out.println("Enter the id:");
		int id = Integer.parseInt(sc.nextLine());
		Set<Employee> empSet = empService.deleteEmployee(id);
		
		for (Employee employee : empSet) {
			displayEmployee(employee);
		}
	}
	public void displayBasedOnSalary() {
		System.out.println("Enter the range1 and range 2");
		int range1 = Integer.parseInt(sc.nextLine());
		int range2 = Integer.parseInt(sc.nextLine());
		Set<Employee> empset = empService.getAllEmplyeesBySalary(range1, range2);
		for (Employee employee : empset) {
			displayEmployee(employee);
		}
		
	}
	public void displayEmployee(Employee e)
	{
		System.out.println(" ID "+e.getId());
		System.out.println(" Name "+e.getName());
		System.out.println(" Salary "+e.getSalary());
		System.out.println(" Designation "+e.getDesignation());
		System.out.println(" InsuranceScheme "+e.getInsuranceScheme());
		System.out.println("\n---------------------------------------------\n");
		
		
	}

}
