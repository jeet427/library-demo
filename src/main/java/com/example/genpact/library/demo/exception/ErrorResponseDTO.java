package com.example.genpact.library.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorResponseDTO {
	private String message;
	private HttpStatus httpStatus;
	private Date timestamp;

	/**
	 * 
	 */
	public ErrorResponseDTO() {
		super();
	}

	/**
	 * @param message
	 * @param httpStatus
	 */
	public ErrorResponseDTO(String message, HttpStatus httpStatus) {
		super();
		this.timestamp = new Date();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
