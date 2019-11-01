/**
 * 
 */
package com.cg.ems.finance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.ems.finance.dto.Finance;

/**
 * @author admin
 *
 */
public interface FinanceRepo extends JpaRepository<Finance, String> {

	@Query("SELECT c FROM expense_claim c")
	List<Object> viewAllClaims();

	@Query("SELECT c FROM expense_claim c WHERE c.status=2")
	List<Object> viewAllClearedClaims();

	@Query("SELECT c FROM expense_claim c WHERE c.status=1")
	List<Object> viewAllPendingApprovedClaims();

	@Query("SELECT c FROM expense_claim c WHERE c.status=0")
	List<Object> viewAllAppliedClaims();

	@Modifying
	@Query("UPDATE expense_claim c SET c.status=:latestStatus WHERE c.claim_id = :claimId")
	int updateClaimStatus(int claimId, int latestStatus);

	Object viewClaimById(int claimId);

	boolean claimFundTransfer();

}
