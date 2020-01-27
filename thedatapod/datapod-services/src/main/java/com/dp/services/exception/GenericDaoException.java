package com.dp.services.exception;

/**
 * The Class GenericDaoException.
 */
public class GenericDaoException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6751772861292593264L;
	
	/** The err code. */
	private int errCode;

	/** Variable that represents the error level. */
	private String errLabel;

	/** Variable that represents the error reason. */
	private String errReason;


	/**
	 * Instantiates a new generic dao exception.
	 */
	public GenericDaoException() {

	}

	/**
	 * Instantiates a new generic dao exception.
	 *
	 * @param message the message
	 */
	public GenericDaoException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new generic dao exception.
	 *
	 * @param cause the cause
	 */
	public GenericDaoException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new generic dao exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public GenericDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new generic dao exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public GenericDaoException(String message, Throwable cause, 
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public GenericDaoException(int errorCode, String label, String message) {
		this.errCode = errorCode;
		this.errLabel= label;
		this.errReason = message;
	}

	

	/**
	 * Gets the err level.
	 *
	 * @return the err level
	 */
	public String getErrLevel() {
		return errLabel;
	}

	/**
	 * Sets the err level.
	 *
	 * @param errLevel the new err level
	 */
	public void setErrLevel(String errLevel) {
		this.errLabel = errLevel;
	}

	/**
	 * Gets the err reason.
	 *
	 * @return the err reason
	 */
	public String getErrReason() {
		return errReason;
	}

	/**
	 * Sets the err reason.
	 *
	 * @param errReason the new err reason
	 */
	public void setErrReason(String errReason) {
		this.errReason = errReason;
	}

	/**
	 * Gets the err code.
	 *
	 * @return the err code
	 */
	public int getErrCode() {
		return errCode;
	}

	/**
	 * Sets the err code.
	 *
	 * @param errCode the new err code
	 */
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

}
