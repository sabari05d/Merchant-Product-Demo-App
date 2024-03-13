package org.jsp.merchantbootapp.exception;

@SuppressWarnings("serial")
public class InvalidCredentialException extends RuntimeException {
	public InvalidCredentialException(String message) {
		super(message);
	}
}
