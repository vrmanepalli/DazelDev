package com.nike.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;

import com.nike.dazeldev.HomePage;

public class HomePageTestCases extends BaseTestCase {

	HomePage home;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		navigateTo(baseURL + "/default");
		home = new HomePage(driver);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		 home = null;
	}

	public void testSearchFileBegin_Works() throws InterruptedException {
		home.searchFileBegin("DAH");
		boolean isSelected = home.selectFileElement.isSelected("DAH");
		assertTrue("Select option was not matching DAH", isSelected);
		assertTrue("Show Message response is not showing success message.", home.showMsg.isSuccessful());
	}

}
