package com.cg.eisapp1.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.cg.eisapp1.beans.Employees;
import com.cg.eisapp1.service.EmployeeInterface;
import com.cg.eisapp1.service.EmployeeServiceImpl;

public class MainUi {
EmployeeInterface empService;
	
	public MainUi() {
		empService = new EmployeeServiceImpl();
	}
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	    MainUi obj = new MainUi();
		Map<Integer,Employees> hashmap = new HashMap<Integer,Employees>();
		Employees e1 = new Employees(111,"Ram",20000,"Programmer","Scheme B");
		Employees e2 = new Employees(222,"Vaishnavi",50000,"Manager","Scheme A");
		Employees e3 = new Employees(333,"Ramya",5000,"System Associate","Scheme C");
		Employees e4 = new Employees(444,"RamyaSree",3000,"Clerk","No Scheme");
		
		hashmap.put(e1.getId(), e1);
		hashmap.put(e2.getId(), e2);
		hashmap.put(e3.getId(), e3);
		hashmap.put(e4.getId(), e4);
		while(true) {
			System.out.println("Enter the options:\n1. Insert new Employees\n2. Delete Employee details\n3. Get Employee details on InsuranceScheme");
            int option = Integer.parseInt(sc.nextLine());
            	switch(option) {
            	case 1:hashmap = obj.insertEmployeeDetails(hashmap);
            		   obj.displayEmployeeDetails(hashmap);
            		   break;
            	case 2:hashmap = obj.deleteEmployeeDetails(hashmap);
            		   obj.displayEmployeeDetails(hashmap);
            		   break;
            	case 3:Map<Integer,Employees> map = obj.EmployeeDetailsBasedOnInsurance(hashmap);
            		   obj.displayEmployeeDetails(map);
            		   break;
            	}
		}
		
	}  
    public Map<Integer,Employees> insertEmployeeDetails(Map<Integer,Employees> hm) {
    	System.out.println("Enter the Id :");
    	int id = Integer.parseInt(sc.nextLine());
    	System.out.println("Enter the Name :");
    	String name = sc.nextLine();
    	System.out.println("Enter the Salary :");
    	int salary = Integer.parseInt(sc.nextLine());
    	System.out.println("Enter the Designation:");
    	String designation = new String();
    	String insuranceScheme = new String();
    	if(salary>=5000 && salary<20000) {
    		designation = "System Associate";
    		insuranceScheme = "Scheme C";
    	}else if(salary>=20000 && salary<40000) {
    		designation =  "Programmer";
    		insuranceScheme = "Scheme B";
    	}else if(salary >= 40000) {
    		designation =  "Manager";
    		insuranceScheme = "Scheme A";
    	}else {
    		designation =  "Clerk";
    		insuranceScheme = "No Scheme";
    	}
    	
    	Employees e = new Employees(id,name,salary,designation,insuranceScheme);
    	hm = empService.insertEmployee(hm, e);
        return hm;
    	
    }
    
    public Map<Integer,Employees> deleteEmployeeDetails(Map<Integer,Employees> hm){
    	System.out.println("Enter the ID:");
    	int id = Integer.parseInt(sc.nextLine());
    	if(empService.deleteEmployee(hm, id)) {
    		return hm;
    	}else {
    		System.out.println("No such Id");
    		return hm;
    	}
    	
    }
    
    public Map<Integer,Employees> EmployeeDetailsBasedOnInsurance(Map<Integer,Employees> hm){
    	
    	return hm;
	}
    public void displayEmployeeDetails(Map<Integer,Employees> map) {
    	for(Map.Entry<Integer, Employees> entry:map.entrySet()){    
            int key=entry.getKey();  
            Employees e=entry.getValue();
            System.out.println( "ID:" + key+"\nName :" +e.getName()+"\nSalary :"+e.getSalary()+"\nDesignation :"+e.getDesignation()+"\nInsurance Scheme :"+e.getInsuranceScheme());   
        }    
    }

}
