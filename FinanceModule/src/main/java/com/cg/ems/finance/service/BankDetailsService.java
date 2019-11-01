/**
 * 
 */
package com.cg.ems.finance.service;

import com.cg.ems.finance.dto.BankDetails;

/**
 * @author admin
 *
 */
public interface BankDetailsService {

	BankDetails addBankDetails(BankDetails bankDetails);

	boolean deleteBankDetails(String emp_id);

}
