package com.dp.services.response;

import java.util.List;




/**
 * The Class GenericResponseVO.
 */
public class GenericResponseVO {
	
	
	/** The errors. */
	private List<ErrorResponseVO> errors;
	
	/** The success. */
	private boolean success;
	
	private Object response;

	/**
	 * Instantiates a new generic response VO.
	 */
	public GenericResponseVO() {
	}
	
	public GenericResponseVO(boolean success, List<ErrorResponseVO> errors) {
		super();
		this.success = success;
		this.errors = errors;
	}
	
	public GenericResponseVO(boolean success, Object responseObj) {
		super();
		this.success = success;
		this.response = responseObj;
	}

	public List<ErrorResponseVO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorResponseVO> errors) {
		this.errors = errors;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	

}
