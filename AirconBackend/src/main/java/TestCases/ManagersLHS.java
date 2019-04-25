package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.AdminDashboardPage;
import PageObjects.CompaniesPage;
import PageObjects.LoginPage;
import org.apache.log4j.Logger;

public class ManagersLHS extends BaseSetup {
	CompaniesPage companiesPage;
	LoginPage loginPage;
	AdminDashboardPage adminDashboardPage;
	static Logger log = Logger.getLogger(CompaniesLHS.class);


	@Test(priority = 0, description = "TC_Managers_001 To verify Managers page title")
	public void Verify_Managers_page_title() {

		try {
			log.info("************************* TC-001*************************");
			extentTest.setDescription("TC_Managers_001 To verify Managers page title");
			loginPage = new LoginPage(getDriver());
			loginPage = new LoginPage(getDriver());
			adminDashboardPage = new AdminDashboardPage(getDriver());
			
			companiesPage = new CompaniesPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
			loginPage.clickOnLogInButton();
			adminDashboardPage.clickOnManagersLhsNavbar();
			String pageTitle = loginPage.getPageTitle();
			Assert.assertEquals(pageTitle, "Showing All Users | Aircon");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify Managers page title " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify Managers page title");
		}
	}

	
	@Test(priority = 1, description = "TC_Managers_002 To verify Managers page UI fields")
	public void Verify_Managers_page_UI_fields() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription("TC_Login_003 To verify Managers page UI fields");
			loginPage = new LoginPage(getDriver());
			companiesPage = new CompaniesPage(getDriver());
			adminDashboardPage = new AdminDashboardPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
//			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
//			loginPage.clickOnLogInButton();
			adminDashboardPage.clickOnManagersLhsNavbar();
			Assert.assertTrue(adminDashboardPage.isCompanyNamePresent());
			Assert.assertTrue(companiesPage.isTableHeaderPrasentPresent());
				
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify Managers page UI fields " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Managers page UI fields");
		}
	}
	

}
