/**
 * 
 */
package com.cg.ems.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ems.finance.dto.BankDetails;
import com.cg.ems.finance.repo.FinanceRepo;

/**
 * @author admin
 *
 */

@Service
@Transactional
public class FinanceServiceImpl implements FinanceService {

	/**
	 * 
	 */

	@Autowired
	FinanceRepo financeRepo;
	BankDetailsServiceImpl bankService;

	public FinanceServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addEmployeeClaimAccount(BankDetails claimAccount) {
		return bankService.addBankDetails(claimAccount).getAccountNumber();
		// return newClaimAccount.getAccountNumber();
	}

	@Override
	public List<Object> viewAllClaims() {
		return financeRepo.viewAllClaims();
	}

	@Override
	public List<Object> viewAllClearedClaims() {
		return financeRepo.viewAllClearedClaims();
	}

	@Override
	public List<Object> viewAllPendingApprovedClaims() {
		return financeRepo.viewAllPendingApprovedClaims();
	}

	@Override
	public List<Object> viewAllAppliedClaims() {
		return financeRepo.viewAllAppliedClaims();
	}

	@Override
	public int updateClaimStatus(int claimId, int latestStatus) {
		return financeRepo.updateClaimStatus(claimId, latestStatus);
	}

	@Override
	public Object viewClaimById(int claimId) {
		return financeRepo.viewClaimById(claimId);
	}

	@Override
	public boolean claimFundTransfer() {
		return financeRepo.claimFundTransfer();
	}

}
