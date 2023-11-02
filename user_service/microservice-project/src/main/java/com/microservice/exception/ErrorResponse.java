package com.microservice.exception;


public class ErrorResponse {
	private String message;
	private String url;
	private String timestamp;
	public ErrorResponse(String message, String url, String timestamp) {
		super();
		this.message = message;
		this.url = url;
		this.timestamp = timestamp;
	}
	


}