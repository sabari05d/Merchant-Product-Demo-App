package org.jsp.merchantbootapp.exception;

@SuppressWarnings("serial")
public class IdNotFountException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invalid Id!!";
	}
}
