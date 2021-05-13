package com.cg.eisapp1.service;

import java.util.Map;

import com.cg.eisapp1.beans.Employees;

public interface EmployeeInterface {
	public Map<Integer,Employees> insertEmployee(Map<Integer,Employees> map , Employees e);
    public Map<Integer,Employees> getEmployeeDetailsOnInsuranceScheme(Map<Integer,Employees> map,String str);
    public boolean deleteEmployee(Map<Integer,Employees> map ,int id);

}
