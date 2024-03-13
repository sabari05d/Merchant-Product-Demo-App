package org.jsp.merchantbootapp.exception;

import org.jsp.merchantbootapp.dto.ResponceStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MerchantBootAppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFountException.class)
	public ResponseEntity<ResponceStructure<String>> handleINFE(IdNotFountException exception){
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setData("Can't Find Id!!");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ResponceStructure<String>> handleICE(InvalidCredentialException exception){
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setData("Can't Find Merchant!!");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ResponceStructure<String>> handlePNFE(ProductNotFoundException exception){
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setData("Product Not Found!!");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
}
