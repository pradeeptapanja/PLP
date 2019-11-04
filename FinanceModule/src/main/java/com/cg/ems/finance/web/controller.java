/**
 * 
 */
package com.cg.ems.finance.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.finance.dto.FinanceUser;
import com.cg.ems.finance.exception.InvalidFinanceUserLoginCredentialsException;
import com.cg.ems.finance.service.FinanceUserService;

/**
 * @author admin
 *
 */

@RestController
@RequestMapping("/finance-team")
public class controller {

	/**
	 * 
	 */
	@Autowired
	FinanceUserService financeUserService;

	@GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public FinanceUser loginFinanceUser(@RequestParam String userId, String password)
			throws InvalidFinanceUserLoginCredentialsException {
		return financeUserService.authenticateFinanceUser(userId, password);
	}

	@PostMapping(value = "/register", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public String registerFinanceUser(@RequestBody FinanceUser newFinanceUser) {
		return financeUserService.addFinanceUser(newFinanceUser);
	}

	@PutMapping(value = "/update-password")
	public int updateFinanceUserPassword(@RequestParam String userId, String oldPassword, String newPassword)
			throws InvalidFinanceUserLoginCredentialsException {
		return financeUserService.changeFinanceUserPassword(userId, oldPassword, newPassword);
	}

}
