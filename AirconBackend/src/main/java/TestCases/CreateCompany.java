package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.AdminDashboardPage;
import PageObjects.CompaniesPage;
import PageObjects.LoginPage;
import PageObjects.CreateCompaniesPage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;

public class CreateCompany extends BaseSetup {
	CompaniesPage companiesPage;
	CreateCompaniesPage createCompaniesPage;
	LoginPage loginPage;
	AdminDashboardPage adminDashboardPage;
	static Logger log = Logger.getLogger(CreateCompany.class);


	@Test(priority = 0, description = "TC_CreateCompany_001 To verify Create Company page title")
	public void Verify_CreateCompany_page_title() {

		try {
			log.info("************************* TC-001*************************");
			extentTest.setDescription("TC_CreateCompany_001 To verify Create Company page title");
			loginPage = new LoginPage(getDriver());
			loginPage = new LoginPage(getDriver());
			companiesPage = new CompaniesPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
			loginPage.clickOnLogInButton();
			companiesPage.clickOnCompaniesLhsNavbar();
			companiesPage.clickOnPlusIconButton();
			String pageTitle = loginPage.getPageTitle();
			Assert.assertEquals(pageTitle, "Create Company | Aircon");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify Company page title " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify Company page title");
		}
	}

	
	@Test(priority = 1, description = "TC_CreateCompany_002 To verify Company page UI fields")
	public void Verify_Companies_page_UI_fields() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription("TC_CreateCompany_003 To verify Company page UI fields");
//			loginPage = new LoginPage(getDriver());
//			adminDashboardPage = new AdminDashboardPage(getDriver());
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
	
	@Test(priority = 2, description = "TC_CreateComapny_004 To verify all validation message")
	public void Verify_All_validation_message() {

		try {
			log.info("************************* TC-004*************************");
			extentTest.setDescription(
					"TC_Login_006 To all verify validation message");
			loginPage = new LoginPage(getDriver());
			companiesPage = new CompaniesPage(getDriver());
			createCompaniesPage = new CreateCompaniesPage(getDriver());
			adminDashboardPage = new AdminDashboardPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
//			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
//			loginPage.clickOnLogInButton();
			adminDashboardPage.clickOnCompaniesLhsNavbar();
			companiesPage.clickOnPlusIconButton();
			createCompaniesPage.clickOnSaveButton();
			String companyValidationErrorMessage = createCompaniesPage.getCompanyValidationMessage();
			Assert.assertEquals(companyValidationErrorMessage, "Please enter company name");
			String emailAddressFieldErrorMessage= createCompaniesPage.getEmailValidationMessage();
			Assert.assertEquals(emailAddressFieldErrorMessage, "Please enter email address");
			String phoneValidationErrorMessage = createCompaniesPage.getPhoneValidationMessage();
			Assert.assertEquals(phoneValidationErrorMessage, "Please enter phone number");
			String FreeUntillValidationErrorMessage = createCompaniesPage.getFreeUntillValidationMessage();
			Assert.assertEquals(FreeUntillValidationErrorMessage, "Note*: blank for life time");
			String AddressValidationErrorMessage = createCompaniesPage.getAddressValidationMessage();
			Assert.assertEquals(AddressValidationErrorMessage, "Please enter company address");
			String CityValidationErrorMessage = createCompaniesPage.getCityValidationMessage();
			Assert.assertEquals(CityValidationErrorMessage, "Please enter company city");
			String LocationValidationErrorMessage = createCompaniesPage.getLocationValidationMessage();
			Assert.assertEquals(LocationValidationErrorMessage, "Please enter company location");
			
		
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify_All_validation_message "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify_All_validation_message");
		}
	}
	
	
	@Test(priority = 2, description = "TC_CreateCompany_005 To Verify Create Company page With Enter Valid Data")
	public void Verify_Create_Company_page_With_Enter_Valid_Data() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription("TC_CreateCompany_003 To Verify Create Company page With Enter Valid Data");
			loginPage = new LoginPage(getDriver());
			companiesPage = new CompaniesPage(getDriver());
			createCompaniesPage = new CreateCompaniesPage(getDriver());
			adminDashboardPage = new AdminDashboardPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
			loginPage.clickOnLogInButton();
			adminDashboardPage.clickOnCompaniesLhsNavbar();
			companiesPage.clickOnPlusIconButton();
			createCompaniesPage.enterCompanyName(config.getProperty("CompanyName"));
			
			createCompaniesPage.clickOnUploadButton();
			
		    //put path to your image in a clipboard
		    StringSelection ss = new StringSelection("C:\\Users\\Abhishek\\Downloads\\download.jpg");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		    
		    //imitate mouse events like ENTER, CTRL+C, CTRL+V
		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
			
			createCompaniesPage.enterEmail(config.getProperty("EnterEmail"));
			createCompaniesPage.enterPhoneNumber(config.getProperty("EnterPhone"));
			createCompaniesPage.enterAddressField(config.getProperty("EnterAddress"));
			createCompaniesPage.enterLocationField(config.getProperty("EnterLocation"));
			createCompaniesPage.enterCityField(config.getProperty("EnterCity"));
			createCompaniesPage.clickOnSaveButton();
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify CreateCompany page UI fields " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Create Company UI fields");
		}
		
		
		
	}
	
		
}
