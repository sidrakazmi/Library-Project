package com.lexicon.exceptions;

public class BookNotFoundException extends Exception {

	public BookNotFoundException(String message) 
	{
		super(message);
	}
	
	public BookNotFoundException() 
	{
		super();
	}
}
