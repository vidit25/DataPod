package com.dp.services.response;

import java.util.ArrayList;
import java.util.List;

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
	
	/** The response. */
	private Object response;

	/**
	 * Instantiates a new generic response VO.
	 */
	public GenericResponseVO() {
	}
	
	/**
	 * Instantiates a new generic response VO.
	 *
	 * @param success the success
	 * @param errors the errors
	 */
	public GenericResponseVO(boolean success, List<ErrorResponseVO> errors) {
		super();
		this.success = success;
		this.errors = errors;
	}
	
	/**
	 * Instantiates a new generic response VO.
	 *
	 * @param success the success
	 * @param responseObj the response obj
	 */
	public GenericResponseVO(boolean success, Object responseObj) {
		super();
		this.success = success;
		this.response = responseObj;
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<ErrorResponseVO> getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	public void setErrors(List<ErrorResponseVO> errors) {
		this.errors = errors;
	}

	/**
	 * Checks if is success.
	 *
	 * @return true, if is success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Sets the success.
	 *
	 * @param success the new success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public Object getResponse() {
		return response;
	}

	/**
	 * Sets the response.
	 *
	 * @param response the new response
	 */
	public void setResponse(Object response) {
		this.response = response;
	}

	

}
