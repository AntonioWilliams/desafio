package com.noxtec.error;

import java.io.Serializable;


public class StandardError implements Serializable {

	public StandardError(Long timestamp, Integer status, String message) {
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
	}

	public StandardError() {

	}

	private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer status;
	private String message;
//	private String messageDev;


	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
