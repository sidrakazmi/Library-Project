package com.lexicon.exceptions;

public class MemberNotFound extends Exception {

	public MemberNotFound(String message) 
	{
		super(message);
	}
	
	public MemberNotFound() 
	{
		super();
	}
}
