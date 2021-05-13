package com.capg.emsapp.beans;

public class Employee implements Comparable<Employee>{
	private String empName;
	private int id;
	private int salary;
	private String projectName;
	private Project project;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empName, int id, int salary, String projectName) {
		super();
		this.empName = empName;
		this.id = id;
		this.salary = salary;
		this.projectName = projectName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public int hashCode() {
	  // 1000 line code
		
		int myHashCode = 0;
		myHashCode = empName.length()+id+projectName.length();
		return myHashCode;
	}
	

	@Override    //        (Animal a)
	public boolean equals(Object obj) {
		
		
		boolean isSame = false;
		// code to compare e1 and e2
		
		if(obj instanceof Employee)
		{
		  Employee e = (Employee)obj;	
		  
		  boolean a = this.empName.equals(e.empName);
		  boolean b = (this.id == e.id);
		  boolean c = this.salary == e.salary;
		  boolean d = this.projectName.equals(e.projectName);
		  
		  return a&&b&&c&&d;
			
		}
		return isSame;
	}
	
	public int compareTo(Employee o) {
		return this.id - o.getId();
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", id=" + id + ", salary=" + salary + ", projectName=" + projectName
				+ ", project=" + project + "]";
	}

}
