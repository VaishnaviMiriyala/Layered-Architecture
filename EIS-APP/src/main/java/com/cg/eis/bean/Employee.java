package com.cg.eis.bean;

public class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private int salary;
	private String designation;
	private String insuranceScheme;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, int salary, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getInsuranceScheme() {
		return insuranceScheme;
	}

	public void setInsuranceScheme(String insuranceScheme) {
		this.insuranceScheme = insuranceScheme;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int myHashCode = 0;
		myHashCode = name.length()+id+designation.length()+salary+insuranceScheme.length();
		return myHashCode;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean isSame = false;
		// code to compare e1 and e2
		
		if(obj instanceof Employee)
		{
		  Employee e = (Employee)obj;	
		  
		  boolean a = this.name.equals(e.name);
		  boolean b = (this.id == e.id);
		  boolean c = this.salary == e.salary;
		  boolean d = this.designation.equals(e.designation);
		  
		  return a&&b&&c&&d;
			
		}
		return isSame;
	}
	public int compareTo(Employee o) {
		return this.id - o.getId();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee [Name=" + name + ", id=" + id + ", salary=" + salary + ", Designation=" + designation
				+ ", InsuranceScheme=" + insuranceScheme + "]";
	}
	
}