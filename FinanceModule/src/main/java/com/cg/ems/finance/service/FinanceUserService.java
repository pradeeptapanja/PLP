/**
 * 
 */
package com.cg.ems.finance.service;

import java.util.List;

import com.cg.ems.finance.dto.FinanceUser;
import com.cg.ems.finance.exception.InvalidFinanceUserLoginCredentialsException;

/**
 * @author admin
 *
 */
public interface FinanceUserService {
	FinanceUser authenticateFinanceUser(String loginId, String loginPassword)
			throws InvalidFinanceUserLoginCredentialsException;

	String addFinanceUser(FinanceUser newFinanceUser);

	FinanceUser changeFinanceUserPassword(String financeUserId, String oldPassword, String newPassword)
			throws InvalidFinanceUserLoginCredentialsException;

	List<String> getAllUserIds();
	
}
