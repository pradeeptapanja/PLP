/**
 * 
 */
package com.cg.ems.finance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author admin
 *
 */

@Entity
@GenericGenerator(name = "account_number_seq", strategy = "increment")
public class BankDetails {

	@Id
	@Column(name = "account_number")
	@GeneratedValue(generator = "account_number_seq", strategy = GenerationType.SEQUENCE)
	private int accountNumber;

	@Column(name = "emp_id")
	@NotNull
	private String empId;

	@Column(name = "account_type")
	@NotNull
	private String accountType;

	@Column(name = "bank_name")
	@NotNull
	@Pattern(regexp = "[A-Za-z ]{3,}")
	private String bankName;

	@Column(name = "total_claims")
	@NotNull
	private double totalClaims;

	@Column(name = "claim_balance")
	@NotNull
	private double claimBalance;

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the totalClaims
	 */
	public double getTotalClaims() {
		return totalClaims;
	}

	/**
	 * @param totalClaims the totalClaims to set
	 */
	public void setTotalClaims(double totalClaims) {
		this.totalClaims = totalClaims;
	}

	/**
	 * @return the claimBalance
	 */
	public double getClaimBalance() {
		return claimBalance;
	}

	/**
	 * @param claimBalance the claimBalance to set
	 */
	public void setClaimBalance(double claimBalance) {
		this.claimBalance = claimBalance;
	}

	/**
	 * 
	 */
	public BankDetails() {
		// TODO Auto-generated constructor stub
	}

}
