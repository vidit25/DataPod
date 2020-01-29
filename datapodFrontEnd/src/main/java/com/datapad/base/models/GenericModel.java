package com.datapad.base.models;

import java.util.ArrayList;
import java.util.List;


public class GenericModel {
	
	/** The errors. */
	private List<ErrorModel> errors = new ArrayList<ErrorModel>();
	
	/** The success. */
	private boolean success;
	
	/**
	 * Instantiates a new generic response VO.
	 */
	public GenericModel() {
		
	}
	
	/**
	 * Instantiates a new generic response VO.
	 *
	 * @param success the success
	 * @param errors the errors
	 */
	public GenericModel(boolean success, List<ErrorModel> errors) {
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
//	public GenericModel(boolean success, Object responseObj) {
//		super();
//		this.success = success;
//		this.response = responseObj;
//	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<ErrorModel> getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	public void setErrors(List<ErrorModel> errors) {
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

}
