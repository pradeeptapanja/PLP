/**
 * 
 */
package com.cg.ems.finance.service;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.finance.dto.FinanceUser;
import com.cg.ems.finance.repo.FinanceUserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author admin
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class FinanceUserServiceImplTest {

	@Mock
	private FinanceUserService service;
	private FinanceUserRepo repo;
	private MockMvc mockMvc;
	@Spy
	@InjectMocks
	private RestController controller = new RestController() {

		@Override
		public Class<? extends Annotation> annotationType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String value() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.cg.ems.finance.service.FinanceUserServiceImpl#authenticateFinanceUser(java.lang.String, java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testAuthenticateFinanceUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.cg.ems.finance.service.FinanceUserServiceImpl#addFinanceUser(com.cg.ems.finance.dto.FinanceUser)}.
	 * 
	 * @throws Exception
	 */
	@Ignore
	@Test
	public void testAddFinanceUser() throws Exception {

		FinanceUser testUser = new FinanceUser();
		testUser.setFinanceUserId("FETEST1");
		testUser.setFinanceUserPassword("password");
		testUser.setFinanceUserName("Test User");
		testUser.setFinanceUserEMail("test@user.com");
		testUser.setFinanceUserMobile("+919879879877");

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(testUser);

		Mockito.when(service.addFinanceUser(Mockito.any(FinanceUser.class))).thenReturn(jsonString);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/finance-team/register").content(jsonString)
						.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404)).andReturn();
		assertEquals(404, result.getResponse().getStatus());

	}

	/**
	 * Test method for
	 * {@link com.cg.ems.finance.service.FinanceUserServiceImpl#changeFinanceUserPassword(java.lang.String, java.lang.String, java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testChangeFinanceUserPassword() throws Exception {

		FinanceUser testUser = new FinanceUser();
		testUser.setFinanceUserId("FETEST1");
		testUser.setFinanceUserPassword("password");
		testUser.setFinanceUserName("Test User");
		testUser.setFinanceUserEMail("test@user.com");
		testUser.setFinanceUserMobile("+919879879877");

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(testUser);
		//Mockito.when(repo.validateLoginId(Mockito.anyString())).thenReturn(testUser);

		// ((EmployeeService)
		// Mockito.when(service)).updateEmployee(Mockito.any(Employee.class));
		mockMvc.perform(
				MockMvcRequestBuilders.put("/update").content(jsonString).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404));
	}

}
