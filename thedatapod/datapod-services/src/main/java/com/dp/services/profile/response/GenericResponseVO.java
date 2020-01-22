package com.dp.services.profile.response;

import java.util.List;

import com.dp.services.exception.GenericException;



public class GenericResponseVO {
	
	/** Variable to represents the error responses. */
	private String errorResponse;

	private List<String> errors;

	private String status;

	private boolean success;

	public GenericResponseVO() {
		// TODO Auto-generated constructor stub
	}

	public GenericResponseVO(GenericException genericDataMarketException, String lMessage) {
		super();
		this.setStatus(lMessage);
		this.setSuccess(Boolean.FALSE);
	}

	/**
	 * @return the errorResponse
	 */
	public String getErrorResponse() {
		return errorResponse;
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param errorResponse
	 *            the errorResponse to set
	 */
	public void setErrorResponse(String errorResponse) {
		this.errorResponse = errorResponse;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
