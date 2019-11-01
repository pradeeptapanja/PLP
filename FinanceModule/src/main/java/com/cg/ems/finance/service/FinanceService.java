/**
 * 
 */
package com.cg.ems.finance.service;

import java.util.List;

import com.cg.ems.finance.dto.BankDetails;

/**
 * @author admin
 *
 */
public interface FinanceService {

	int addEmployeeClaimAccount(BankDetails claimAccount);

	List<Object> viewAllClaims();

	List<Object> viewAllClearedClaims();

	List<Object> viewAllPendingApprovedClaims();

	List<Object> viewAllAppliedClaims();

	int updateClaimStatus(int claimId, int latestStatus);

	Object viewClaimById(int claimId);

	boolean claimFundTransfer();
}
