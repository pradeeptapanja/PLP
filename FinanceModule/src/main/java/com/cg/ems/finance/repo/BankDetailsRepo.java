/**
 * 
 */
package com.cg.ems.finance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.ems.finance.dto.BankDetails;

/**
 * @author admin
 *
 */
public interface BankDetailsRepo extends JpaRepository<BankDetails, Integer> {

	@Query("DELETE b FROM bankdetails b WHERE b.emp_id=:id")
	boolean deleteBankDetails(String id);
}
