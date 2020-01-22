package com.dp.services.exception;

/**
 * The Class GenericDaoException.
 */
public class GenericDaoException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6751772861292593264L;

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

}
