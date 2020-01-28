package com.dp.services.response;

import java.util.ArrayList;
import java.util.List;

import com.dp.services.constants.DpConstants;
import com.fasterxml.jackson.annotation.JsonInclude;




/**
 * The Class GenericResponseVO.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponseVO {
	
	
	/** The errors. */
	private List<ErrorResponseVO> errors = new ArrayList<ErrorResponseVO>();
	
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
