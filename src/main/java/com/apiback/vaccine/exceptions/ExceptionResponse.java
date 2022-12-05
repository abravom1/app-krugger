package com.apiback.vaccine.exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private LocalDateTime datetime;
	private String message;
	private String details;

	public ExceptionResponse() {

	}

	public ExceptionResponse(LocalDateTime datetime, String message, String details) {

		this.datetime = datetime;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
