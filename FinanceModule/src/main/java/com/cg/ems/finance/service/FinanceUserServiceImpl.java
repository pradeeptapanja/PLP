/**
 * 
 */
package com.cg.ems.finance.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ems.finance.dto.FinanceUser;
import com.cg.ems.finance.exception.InvalidFinanceUserLoginCredentialsException;
import com.cg.ems.finance.repo.FinanceUserRepo;

/**
 * @author admin
 *
 */

@Service
@Transactional(rollbackFor = InvalidFinanceUserLoginCredentialsException.class)
public class FinanceUserServiceImpl implements FinanceUserService {

	@Autowired
	private FinanceUserRepo financeUserRepo;

	@Override
	public FinanceUser authenticateFinanceUser(String loginId, String loginPassword)
			throws InvalidFinanceUserLoginCredentialsException {
		FinanceUser loggedInUser = financeUserRepo.validateLoginId(loginId);
		if (loggedInUser != null) {
			String encodedPassword = Base64.getEncoder().encodeToString(loginPassword.getBytes());
			loggedInUser = financeUserRepo.validateLoginPassword(loginId, encodedPassword);
			if (loggedInUser != null) {
				return loggedInUser;
			} else {
				throw new InvalidFinanceUserLoginCredentialsException("Invalid login password!");
			}
		} else {
			throw new InvalidFinanceUserLoginCredentialsException("Invalid login ID!");
		}
	}

	@Override
	public String addFinanceUser(FinanceUser newFinanceUser) {
		FinanceUser registerNewFinanceUser = newFinanceUser;
		Base64.Encoder encoder = Base64.getEncoder();
		registerNewFinanceUser
				.setFinanceUserPassword(encoder.encodeToString(newFinanceUser.getFinanceUserPassword().getBytes()));
		financeUserRepo.save(registerNewFinanceUser);
		return registerNewFinanceUser.getFinanceUserId();
	}

	@Override
	public int changeFinanceUserPassword(String financeUserId, String oldPassword, String newPassword)
			throws InvalidFinanceUserLoginCredentialsException {
		String encodedOldPassword = Base64.getEncoder().encodeToString(oldPassword.getBytes());
		String encodedNewPassword = Base64.getEncoder().encodeToString(newPassword.getBytes());
		int i = financeUserRepo.updateFinanceUserPassword(financeUserId, encodedOldPassword, encodedNewPassword);
		if (i != 0) {
			return i;
		} else {
			throw new InvalidFinanceUserLoginCredentialsException("Invalid credentials!");
		}
	}

}