package com.capg.emsapp.exceptions;

public class EmployeeSalaryException extends Exception{
	private String message;
	

	public EmployeeSalaryException() {
		super();
	}


	public EmployeeSalaryException(String message) {
		super();
		this.message = message;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The Exception is:"+message;
	}
	

}
