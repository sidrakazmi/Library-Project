package com.lexicon.exceptions;

public class MemberAlreadyAvailable extends Exception {

	public MemberAlreadyAvailable(String message) 
	{
		super(message);
	}
	
	public MemberAlreadyAvailable() 
	{
		super();
	}
}
