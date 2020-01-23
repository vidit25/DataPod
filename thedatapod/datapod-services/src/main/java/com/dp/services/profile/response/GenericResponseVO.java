package com.dp.services.profile.response;

import java.util.List;

import com.dp.services.exception.GenericException;



/**
 * The Class GenericResponseVO.
 */
public class GenericResponseVO {
	
	/** Variable to represents the error responses. */
	private String errorResponse;

	/** The errors. */
	private List<String> errors;

	/** The status. */
	private String status;

	/** The success. */
	private boolean success;

	/**
	 * Instantiates a new generic response VO.
	 */
	public GenericResponseVO() {
	}

	/**
	 * Instantiates a new generic response VO.
	 *
	 * @param genericDataMarketException the generic data market exception
	 * @param lMessage the l message
	 */
	public GenericResponseVO(GenericException genericDataMarketException, String lMessage) {
		super();
		this.setStatus(lMessage);
		this.setSuccess(Boolean.FALSE);
	}

	/**
	 * Gets the error response.
	 *
	 * @return the errorResponse
	 */
	public String getErrorResponse() {
		return errorResponse;
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Checks if is success.
	 *
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Sets the error response.
	 *
	 * @param errorResponse            the errorResponse to set
	 */
	public void setErrorResponse(String errorResponse) {
		this.errorResponse = errorResponse;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors            the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	/**
	 * Sets the status.
	 *
	 * @param status            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Sets the success.
	 *
	 * @param success            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
