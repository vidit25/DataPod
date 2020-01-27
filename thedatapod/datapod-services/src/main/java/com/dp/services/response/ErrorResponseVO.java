package com.dp.services.response;

/**
 * The Class ErrorResponseVO.
 */
public class ErrorResponseVO {
	
	/** The errorCode. */
	private int errorCode;
	
	/** The errorLabel. */
	private String errorLabel;
	
	/** The errorMessage. */
	private String errorMessage;
	
	public ErrorResponseVO() {
		
	}
	
	public ErrorResponseVO(int errorCode, String errorLabel, String errorMessage) {
		this.errorCode = errorCode;
		this.errorLabel = errorLabel;
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error label.
	 *
	 * @return the error label
	 */
	public String getErrorLabel() {
		return errorLabel;
	}

	/**
	 * Sets the error label.
	 *
	 * @param errorLabel the new error label
	 */
	public void setErrorLabel(String errorLabel) {
		this.errorLabel = errorLabel;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
