package com.assimilate.springboot.javafeb.model;

public class ErrorResponse {
	private Integer errorCode;
	private String errorMessage;
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	// 101 -> Student not found
	// 102 -> Student name not allowed
	// 103 -> mobile no is incorrect
	
	

}
