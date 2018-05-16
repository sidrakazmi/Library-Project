package com.lexicon.exceptions;

public class BookAlreadyAvailableException extends Exception {

	public BookAlreadyAvailableException(String message) 
	{
		super(message);
	}
	
	public BookAlreadyAvailableException() 
	{
		super();
	}

}
