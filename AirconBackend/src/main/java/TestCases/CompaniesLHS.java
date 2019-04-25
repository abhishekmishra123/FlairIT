package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.AdminDashboardPage;
import PageObjects.CompaniesPage;
import PageObjects.LoginPage;
import org.apache.log4j.Logger;

public class CompaniesLHS extends BaseSetup {
	CompaniesPage companiesPage;
	LoginPage loginPage;
	AdminDashboardPage adminDashboardPage;
	static Logger log = Logger.getLogger(CompaniesLHS.class);


	@Test(priority = 0, description = "TC_Companies_001 To verify Company page title")
	public void Verify_Company_page_title() {

		try {
			log.info("************************* TC-001*************************");
			extentTest.setDescription("TC_Companies_001 To verify Company page title");
			loginPage = new LoginPage(getDriver());
			loginPage = new LoginPage(getDriver());
			companiesPage = new CompaniesPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
			loginPage.clickOnLogInButton();
			companiesPage.clickOnCompaniesLhsNavbar();
			String pageTitle = loginPage.getPageTitle();
			Assert.assertEquals(pageTitle, "Company | Aircon");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify Company page title " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify Company page title");
		}
	}

	
	@Test(priority = 1, description = "TC_Companies_002 To verify Company page UI fields")
	public void Verify_Companies_page_UI_fields() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription("TC_Companies_003 To verify Company page UI fields");
			loginPage = new LoginPage(getDriver());
			adminDashboardPage = new AdminDashboardPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
//			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
//			loginPage.clickOnLogInButton();
			adminDashboardPage.clickOnCompaniesLhsNavbar();
			Assert.assertTrue(adminDashboardPage.isCompanyNamePresent());
			Assert.assertTrue(companiesPage.isTableHeaderPrasentPresent());
				
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify Company page UI fields " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Company login page UI fields");
		}
	}
	
}
