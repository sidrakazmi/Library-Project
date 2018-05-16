package com.lexicon.exceptions;

public class LoanNotFound extends Exception {

	public LoanNotFound(String message) 
	{
		super(message);
	}
	
	public LoanNotFound() 
	{
		super();
	}
}
