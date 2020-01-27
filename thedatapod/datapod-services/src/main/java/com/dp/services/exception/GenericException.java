package com.dp.services.exception;


/**
 * The Class GenericException.
 */
public class GenericException extends Exception {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6751772861292593264L;

	/** Variable that represents the error code. */
	private int errCode;

	/** Variable that represents the error level. */
	private String errLabel;

	/** Variable that represents the error reason. */
	private String errReason;

	/**
	 * Instantiates a new GenericDataMarketException.
	 */
	public GenericException() {

	}

	/**
	 * Instantiates a new generic exception.
	 *
	 * @param lE the l E
	 */
	public GenericException(Exception lE) {
		// TODO Auto-generated constructor stub
		super(lE);
	}
	
	/**
	 * Instantiates a new generic exception.
	 *
	 * @param errorCode the error code
	 * @param label the label
	 * @param message the message
	 */
	public GenericException(int errorCode, String label, String message) {
		this.errCode = errorCode;
		this.errLabel= label;
		this.errReason = message;
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
	 * Gets the err code.
	 *
	 * @return the errCode
	 */
	public int getErrCode() {
		return errCode;
	}

	/**
	 * Gets the err level.
	 *
	 * @return the errLevel
	 */
	public String getErrLevel() {
		return errLabel;
	}

	/**
	 * Gets the err reason.
	 *
	 * @return the errReason
	 */
	public String getErrReason() {
		return errReason;
	}

	/**
	 * Sets the err code.
	 *
	 * @param errCode            the errCode to set
	 */
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	/**
	 * Sets the err level.
	 *
	 * @param errLevel            the errLevel to set
	 */
	public void setErrLevel(String errLevel) {
		this.errLabel = errLevel;
	}

	/**
	 * Sets the err reason.
	 *
	 * @param errReason            the errReason to set
	 */
	public void setErrReason(String errReason) {
		this.errReason = errReason;
	}

}
