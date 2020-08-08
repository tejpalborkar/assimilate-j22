package com.assimilate.springboot.javafeb.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//@Controller
//@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleBadRequest(Exception e) {

		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("message", "These is some problem with the server. Internal server error");
		responseMap.put("code", "500");
		e.printStackTrace();
		return responseMap;

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		for (ObjectError objectError : allErrors) {
			FieldError fieldError = (FieldError) objectError;
			errors.put(fieldError.getField(), objectError.getDefaultMessage());
		}
		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	public Map<String, String> handleNotFoundException(NotFoundException ex) {
		Map<String, String> errors = new HashMap<>();

		return errors;
	}
}
