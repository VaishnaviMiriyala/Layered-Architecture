package com.cg.eisapp1.service;

import java.util.HashMap;
import java.util.Map;

import com.cg.eisapp1.beans.Employees;

public class EmployeeServiceImpl implements EmployeeInterface{
	public Map<Integer,Employees> insertEmployee(Map<Integer,Employees> map ,Employees e) {
		map.put(e.getId(), e);
		return map;
	}
	public boolean deleteEmployee(Map<Integer,Employees> map , int id) {
		Boolean isSame = false;
		if(map.containsKey(id)) {
			map.remove(id);
			isSame = true;
			return isSame;
		}
		return isSame;
		
	}
	public Map<Integer,Employees> getEmployeeDetailsOnInsuranceScheme(Map<Integer,Employees> map,String str){
		Map<Integer,Employees> hashmap = new HashMap<Integer,Employees>();
		for(Map.Entry<Integer,Employees> m : map.entrySet()){ 
			int key = m.getKey();
		    Employees e = m.getValue();
		    if(e.getInsuranceScheme().equals(str)) {
		    	hashmap.put(key,e);
		    }
	    } 
		return hashmap;
	}

}
