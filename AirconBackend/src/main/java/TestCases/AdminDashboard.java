package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.AdminDashboardPage;
import PageObjects.LoginPage;

import org.apache.log4j.Logger;

public class AdminDashboard extends BaseSetup {
	AdminDashboardPage adminDashboardPage;
	LoginPage loginPage;
	static Logger log = Logger.getLogger(AdminDashboard.class);


	@Test(priority = 0, description = "TC_Dashboard_001 To verify Dashboard page title")
	public void Verify_Dashboard_page_title() {

		try {
			log.info("************************* TC-001*************************");
			extentTest.setDescription("TC_Dashboard_001 To verify Dashboard page title");
			loginPage = new LoginPage(getDriver());
			loginPage = new LoginPage(getDriver());
			adminDashboardPage = new AdminDashboardPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
			loginPage.clickOnLogInButton();
			String pageTitle = loginPage.getPageTitle();
			Assert.assertEquals(pageTitle, "Welcome hlebsack | Aircon");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify Dashbaoard page title " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify Dashbaoard page title");
		}
	}

	
	@Test(priority = 1, description = "TC_Dashboard_002 To verify Dashboard page UI fields")
	public void Verify_Companies_page_UI_fields() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription("TC_Login_003 To verify Dashboard page UI fields");
//			loginPage = new LoginPage(getDriver());
//			adminDashboardPage = new AdminDashboardPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
//			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
//			loginPage.clickOnLogInButton();
			adminDashboardPage.clickOnCompaniesLhsNavbar();
			Assert.assertTrue(adminDashboardPage.isCompanyNamePresent());
		
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify dashboard page UI fields " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to dashboard login page UI fields");
		}
	}
	
	@Test(priority = 1, description = "TC_Dashboard_002 To verify Dashboard page UI fields")
	public void Verify_Dashboard_page_UI_fields() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription("TC_Login_003 To verify Dashboard page UI fields");
			loginPage = new LoginPage(getDriver());
			adminDashboardPage = new AdminDashboardPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
			loginPage.clickOnLogInButton();
			Assert.assertTrue(adminDashboardPage.isPageHeaderPresent());
			Assert.assertTrue(adminDashboardPage.isDashboardSectionPresent("COMPANIES"));
			Assert.assertTrue(adminDashboardPage.isDashboardSectionPresent("USERS"));
			Assert.assertTrue(adminDashboardPage.isDashboardSectionPresent("MANAGERS"));
			Assert.assertTrue(adminDashboardPage.isDashboardSectionPresent("BOOKINGS"));
			Assert.assertTrue(adminDashboardPage.isDashboardSectionPresent("PROVIDERS"));
		
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify dashboard page UI fields " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to dashboard login page UI fields");
		}
	}
	
	
	

	

}
