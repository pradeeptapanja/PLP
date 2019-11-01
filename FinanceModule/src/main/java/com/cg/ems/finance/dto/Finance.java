/**
 * 
 */
package com.cg.ems.finance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author admin
 *
 */

@Entity
public class Finance {

	@Id
	@Column(name = "finance_id")
	@Pattern(regexp = "FE[A-Z0-9]{5}", message = "Invalid id")
	private String financeId;

	@Column(name = "claim_id")
	private int claimId;

	@Column(name = "account_number")
	@NotNull
	private long accountNumber;

	@Column(name = "budget")
	@NotNull
	private double budget;

	/**
	 * @return the financeId
	 */
	public String getFinanceId() {
		return financeId;
	}

	/**
	 * @param financeId the financeId to set
	 */
	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}

	/**
	 * @return the claimId
	 */
	public int getClaimId() {
		return claimId;
	}

	/**
	 * @param claimId the claimId to set
	 */
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the budget
	 */
	public double getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(double budget) {
		this.budget = budget;
	}

	/**
	 * 
	 */
	public Finance() {
		// TODO Auto-generated constructor stub
	}

}
