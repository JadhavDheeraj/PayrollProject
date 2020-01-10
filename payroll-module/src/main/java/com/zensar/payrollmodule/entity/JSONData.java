package com.zensar.payrollmodule.entity;

import org.springframework.stereotype.Component;

@Component
public class JSONData {

	private String message;
	private Integer statusCode;
	private Object result;

	public JSONData() {

	}

	public JSONData(String message, Integer statusCode, Object result) {
		this.message = message;
		this.statusCode = statusCode;
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "JSONData [message=" + message + ", statusCode=" + statusCode + ", result=" + result + "]";
	}

}
