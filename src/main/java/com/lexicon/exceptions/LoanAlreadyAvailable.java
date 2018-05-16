package com.lexicon.exceptions;

public class LoanAlreadyAvailable extends Exception {

	public LoanAlreadyAvailable(String message) 
	{
		super(message);
	}
	
	public LoanAlreadyAvailable() 
	{
		super();
	}
}
