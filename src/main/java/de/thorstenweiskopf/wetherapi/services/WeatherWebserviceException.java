package de.thorstenweiskopf.wetherapi.services;

import org.springframework.http.HttpStatus;

public class WeatherWebserviceException extends RuntimeException {

	private static final long serialVersionUID = -3313916523170018081L;

	String message;
	HttpStatus httpStatus;

	
	public WeatherWebserviceException(String msg, HttpStatus httpCode) {
		super();
		this.message = msg;
		this.httpStatus = httpCode;
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

	
	
	
	
}
