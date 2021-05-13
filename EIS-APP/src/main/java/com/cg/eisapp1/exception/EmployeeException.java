package com.cg.eisapp1.exception;

public class EmployeeException extends Exception{
	private String message;
    
	public EmployeeException() {
		super();
	}
	public EmployeeException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The Exception is:"+message;
	}
    
	
	

}
