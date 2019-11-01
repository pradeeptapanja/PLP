/**
 * 
 */
package com.cg.ems.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ems.finance.dto.BankDetails;
import com.cg.ems.finance.repo.BankDetailsRepo;

/**
 * @author admin
 *
 */

@Service
@Transactional
public class BankDetailsServiceImpl implements BankDetailsService {

	/**
	 * 
	 */
	
	@Autowired
	BankDetailsRepo bankRepo;
	public BankDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BankDetails addBankDetails(BankDetails bankDetails) {
		return bankRepo.save(bankDetails);
	}

	@Override
	public boolean deleteBankDetails(String emp_id) {
		try {
			bankRepo.deleteBankDetails(emp_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
