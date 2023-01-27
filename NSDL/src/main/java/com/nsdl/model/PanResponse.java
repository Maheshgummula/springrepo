package com.nsdl.model;

public class PanResponse<T> {
	private Long response_status_id;
	public Long getResponse_status_id() {
		return response_status_id;
	}
	public void setResponse_status_id(Long response_status_id) {
		this.response_status_id = response_status_id;
	}
	public Long getResponse_type_id() {
		return response_type_id;
	}
	public void setResponse_type_id(Long response_type_id) {
		this.response_type_id = response_type_id;
	}
	private Long response_type_id;
	private String message;
	private T status ;
	public T getStatus() {
		return status;
	}
	public void setStatus(T status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
