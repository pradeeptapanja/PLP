/**
 * 
 */
package com.cg.ems.finance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ems.finance.dto.FinanceUser;

/**
 * @author admin
 *
 */

@Repository
public interface FinanceUserRepo extends JpaRepository<FinanceUser, String> {

	@Query("SELECT f FROM FinanceUser f WHERE f.financeUserId=:loginid")
	FinanceUser validateLoginId(String loginid);

	@Query("SELECT f FROM FinanceUser f WHERE f.financeUserId=:loginid AND f.financeUserPassword=:loginpassword")
	FinanceUser validateLoginPassword(String loginid, String loginpassword);

	@Modifying
	@Query("UPDATE FinanceUser f SET f.financeUserPassword=:newPassword WHERE f.financeUserId=:financeUserId AND f.financeUserPassword=:oldPassword")
	int updateFinanceUserPassword(String financeUserId, String oldPassword, String newPassword);

	@Query("SELECT financeUserId FROM FinanceUser f")
	List<String> getAllUserIds();
	

}
