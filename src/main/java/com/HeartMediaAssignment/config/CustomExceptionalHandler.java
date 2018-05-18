package com.HeartMediaAssignment.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.HeartMediaAssignment.Exception.AdvertiserFieldsNullException;
import com.HeartMediaAssignment.Exception.AdvertiserNotFoundException;
import com.HeartMediaAssignment.Exception.CannotPerformTransactionException;
import com.HeartMediaAssignment.Exception.LowCreditLimitException;
import com.HeartMediaAssignment.Model.ErrorMessage;

@ControllerAdvice
public class CustomExceptionalHandler {
	
	@ExceptionHandler(value=AdvertiserNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleEntityNotFoundException(AdvertiserNotFoundException ex) {
	    ErrorMessage errorMessage = new ErrorMessage();
	    errorMessage.setMessage(ex.getMessage());
	    errorMessage.setStatus(HttpStatus.NOT_FOUND);
	    return errorMessage;
	}
	
	@ExceptionHandler(value=AdvertiserFieldsNullException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleNullFieldsException(AdvertiserFieldsNullException ex) {
	    ErrorMessage errorMessage = new ErrorMessage();
	    errorMessage.setMessage(ex.getMessage());
	    errorMessage.setStatus(HttpStatus.BAD_REQUEST);
	    return errorMessage;
	}
	
	@ExceptionHandler(value=CannotPerformTransactionException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorMessage handleCannotPerformTransactionException(CannotPerformTransactionException ex) {
	    ErrorMessage errorMessage = new ErrorMessage();
	    errorMessage.setMessage(ex.getMessage());
	    errorMessage.setStatus(HttpStatus.UNAUTHORIZED);
	    return errorMessage;
	}
	
	@ExceptionHandler(value=LowCreditLimitException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorMessage handleLowCreditLimitException(LowCreditLimitException ex) {
	    ErrorMessage errorMessage = new ErrorMessage();
	    errorMessage.setMessage(ex.getMessage());
	    errorMessage.setStatus(HttpStatus.UNAUTHORIZED);
	    return errorMessage;
	}

}
