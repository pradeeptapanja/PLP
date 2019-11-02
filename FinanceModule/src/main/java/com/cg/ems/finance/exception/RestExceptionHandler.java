/**
 * Global rest exception handler class
 */
package com.cg.ems.finance.exception;

import java.util.Date;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.ems.finance.dto.ExceptionDetails;

/**
 * @author Pradeepta
 * @version 1.0
 *
 */

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Method for handling exception
	 * 
	 */

	@ExceptionHandler(InvalidFinanceUserLoginCredentialsException.class)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidEntry(InvalidFinanceUserLoginCredentialsException ex) {
		ExceptionDetails error = new ExceptionDetails();
		error.setTimestamp(new Date());
		error.setMessage(ex.getMessage());
		error.setDetails(ex.getUriDetails());
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}

}
