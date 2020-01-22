package com.dp.services.exception;


/**
 * The Class GenericException.
 */
public class GenericException extends Exception {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6751772861292593264L;

	/** Variable that represents the error code. */
	private String errCode;

	/** Variable that represents the error level. */
	private String errLevel;

	/** Variable that represents the error reason. */
	private String errReason;

	/**
	 * Instantiates a new GenericDataMarketException.
	 */
	public GenericException() {

	}

	public GenericException(Exception lE) {
		// TODO Auto-generated constructor stub
		super(lE);
	}

	/**
	 * Instantiates a new generic datamarket exception.
	 *
	 * @param string
	 *            the cause
	 */
	public GenericException(String string) {
		super(string);
	}

	/**
	 * Instantiates a new generic datamarket exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public GenericException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new GenericDataMarketException.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 * @param enableSuppression
	 *            the enable suppression
	 * @param writableStackTrace
	 *            the writable stack trace
	 */
	public GenericException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @return the errCode
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * @return the errLevel
	 */
	public String getErrLevel() {
		return errLevel;
	}

	/**
	 * @return the errReason
	 */
	public String getErrReason() {
		return errReason;
	}

	/**
	 * @param errCode
	 *            the errCode to set
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * @param errLevel
	 *            the errLevel to set
	 */
	public void setErrLevel(String errLevel) {
		this.errLevel = errLevel;
	}

	/**
	 * @param errReason
	 *            the errReason to set
	 */
	public void setErrReason(String errReason) {
		this.errReason = errReason;
	}

}
