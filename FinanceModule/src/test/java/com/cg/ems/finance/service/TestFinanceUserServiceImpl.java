/**
 * class containing test methods for service layer methods
 */
package com.cg.ems.finance.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ems.finance.dto.ExpenseClaim;
import com.cg.ems.finance.dto.FinanceUser;
import com.cg.ems.finance.exception.InvalidFinanceUserLoginCredentialsException;
import com.cg.ems.finance.exception.userIdExistsException;

/**
 * @author Panja
 * @version 1.0
 */
@RunWith(SpringRunner.class)

@SpringBootTest
public class TestFinanceUserServiceImpl {

	@Autowired
	private FinanceUserService service;

	private FinanceUser user;

	private ExpenseClaim claim;

	@Before
	public void init() {
		user = new FinanceUser();
		user.setFinanceUserId("FE12345");
		user.setFinanceUserName("Panja");
		user.setFinanceUserPassword("Passw12");
		user.setFinanceUserMobile("9879879877");
		user.setFinanceUserEMail("panja@mail.com");

	}

	@Test
	public void testAuthenticateLogin() throws InvalidFinanceUserLoginCredentialsException {
		FinanceUser testUser = service.authenticateFinanceUser("FE11111", "Passw12");
		assertNotNull(testUser);
	}

	@Test(expected = InvalidFinanceUserLoginCredentialsException.class)
	public void testFailAuthenticateLogin() throws InvalidFinanceUserLoginCredentialsException {
		FinanceUser testUser = service.authenticateFinanceUser("FE11112", "Passw12");
		assertNotNull(testUser);
	}

	@Test
	public void testRegister() throws userIdExistsException {
		String testUser = service.addFinanceUser(user);
		assertTrue(testUser.equals(user.getFinanceUserId()));
	}

	@Test (expected = userIdExistsException.class)
	public void testFailRegister() throws userIdExistsException {
		String testUser = service.addFinanceUser(user);
		assertTrue(testUser.equals("FE12345"));
	}

	@Test
	public void testChangeFinanceUserPassword() throws InvalidFinanceUserLoginCredentialsException {
		FinanceUser testUser = service.changeFinanceUserPassword("FE11111", "Passw12", "Passw23");
		assertTrue(testUser.getFinanceUserPassword().equals("Passw23"));
	}

	@Test(expected = InvalidFinanceUserLoginCredentialsException.class)
	public void testFailChangeFinanceUserPassword() throws InvalidFinanceUserLoginCredentialsException {
		FinanceUser testUser = service.changeFinanceUserPassword("FE11111", "Passw2", "Passw23");
		assertFalse(testUser.getFinanceUserPassword().equals("Passw23"));
	}

	@Test
	public void testGetAllUserIds() {
		List<String> list = service.getAllUserIds();
		assertNotNull(list);
	}

	@Test
	public void testGetAllClaims() {
		List<ExpenseClaim> list = service.getAllClaims();
		assertNotNull(list);
	}

	@Test
	public void testApproveClaim() {
		assertEquals(1, service.approveClaim(50001));
	}

	@Test
	public void testRejectClaim() {
		assertEquals(1, service.rejectClaim(50002));
	}

}
