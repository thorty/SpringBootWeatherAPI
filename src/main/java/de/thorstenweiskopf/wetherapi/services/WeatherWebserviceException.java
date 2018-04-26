package de.thorstenweiskopf.wetherapi.services;

import org.springframework.http.HttpStatus;

public class WeatherWebserviceException extends RuntimeException {

	private static final long serialVersionUID = -3313916523170018081L;

	String message;
	HttpStatus httpStatus;
	boolean isError = true;
	
	public WeatherWebserviceException(String msg, HttpStatus httpCode, boolean isError) {
		super();
		this.message = msg;
		this.httpStatus = httpCode;
		this.isError = isError;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getCode() {
		return httpStatus;
	}
	public void setCode(int code) {
		this.httpStatus = httpStatus;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	
	
	
	
	
}
