package com.lexicon.exceptions;

public class BookNotFound extends Exception {

	public BookNotFound(String message) 
	{
		super(message);
	}
	
	public BookNotFound() 
	{
		super();
	}
}
