/**
 * user defined exception class for already existing user id
 */
package com.cg.ems.finance.exception;

/**
 * @author admin
 *
 */
public class userIdExistsException extends Exception {

	private String uriDetails;

	public String getUriDetails() {
		return uriDetails;
	}

	public void setUriDetails(String uriDetails) {
		this.uriDetails = uriDetails;
	}
	
	/**
	 * Default constructor of userIdExistsException.class
	 */
	public userIdExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public userIdExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public userIdExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public userIdExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public userIdExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
