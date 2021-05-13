package com.cg.eis.service;



import java.util.Set;

import com.cg.eis.bean.Employee;
import com.cg.eisapp1.exception.EmployeeException;


public interface EmployeeService {
	public boolean insertEmployee(Employee e) throws EmployeeException;
	public Set<Employee> getAllEmployees();
	public Set<Employee> getAllEmployeesByInsurance(String insurance);
	public Set<Employee> deleteEmployee(int id);
	public Set<Employee>  getAllEmplyeesBySalary(int r1,int r2);

}
