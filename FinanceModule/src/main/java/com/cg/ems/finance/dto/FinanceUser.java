/**
 * 
 */
package com.cg.ems.finance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author admin
 *
 */

@Entity
@Table(name = "finance_user")

public class FinanceUser {

	@Id
	@Column(name = "finance_user_id")
	@Pattern(regexp = "FE[A-Z0-9]{5}", message = "Invalid id")
	private String financeUserId;

	@Column(name = "finance_user_name")
	@Pattern(regexp = "[A-Z][A-Za-z ]+", message = "Invalid id")
	@NotNull
	private String financeUserName;

	@Column(name = "finance_user_password")
	// @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",
	// message = "Invalid id")
	@NotNull
	private String financeUserPassword;

	@Column(name = "finance_user_email")
	// @Pattern(regexp = "[\\w_]+@[a-z]{3,20}.[a-z]{2,4}", message = "Invalid id")
	@NotNull
	private String financeUserEMail;

	@Column(name = "finance_user_mobile")
	// @Pattern(regexp = "\\+91[6-9][0-9]{9}", message = "Invalid id")
	@NotNull
	private String financeUserMobile;

	/**
	 * @return the financeUserId
	 */
	public String getFinanceUserId() {
		return financeUserId;
	}

	/**
	 * @param financeUserId the financeUserId to set
	 */
	public void setFinanceUserId(String financeId) {
		this.financeUserId = financeId;
	}

	/**
	 * @return the financeUserName
	 */
	public String getFinanceUserName() {
		return financeUserName;
	}

	/**
	 * @param financeUserName the financeUserName to set
	 */
	public void setFinanceUserName(String financeUserName) {
		this.financeUserName = financeUserName;
	}

	/**
	 * @return the financeUserPassword
	 */
	public String getFinanceUserPassword() {
		return financeUserPassword;
	}

	/**
	 * @param financeUserPassword the financeUserPassword to set
	 */
	public void setFinanceUserPassword(String financeUserPassword) {
		this.financeUserPassword = financeUserPassword;
	}

	/**
	 * @return the financeUserEMail
	 */
	public String getFinanceUserEMail() {
		return financeUserEMail;
	}

	/**
	 * @param financeUserEMail the financeUserEMail to set
	 */
	public void setFinanceUserEMail(String financeUserEMail) {
		this.financeUserEMail = financeUserEMail;
	}

	/**
	 * @return the financeUserMobile
	 */
	public String getFinanceUserMobile() {
		return financeUserMobile;
	}

	/**
	 * @param financeUserMobile the financeUserMobile to set
	 */
	public void setFinanceUserMobile(String financeUserMobile) {
		this.financeUserMobile = financeUserMobile;
	}

	/**
	 * 
	 */
	public FinanceUser() {
		// TODO Auto-generated constructor stub
	}

}
