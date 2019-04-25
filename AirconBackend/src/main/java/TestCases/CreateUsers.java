package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.AdminDashboardPage;
import PageObjects.CompaniesPage;
import PageObjects.LoginPage;
import PageObjects.CreateCompaniesPage;
import PageObjects.CreateUserPage;
import java.util.Random;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CreateUsers extends BaseSetup {
	CompaniesPage companiesPage;
	CreateCompaniesPage createCompaniesPage;
	LoginPage loginPage;
	CreateUserPage createUserPage;
	
	
	AdminDashboardPage adminDashboardPage;
	static Logger log = Logger.getLogger(CreateUsers.class);


	@Test(priority = 0, description = "TC_CreateUser_001 To verify Create User page title")
	public void Verify_CreateUser_page_title() {

		try {
			log.info("************************* TC-001*************************");
			extentTest.setDescription("TC_CreateUser_001 To verify Create User page title");
			loginPage = new LoginPage(getDriver());
			loginPage = new LoginPage(getDriver());
			companiesPage = new CompaniesPage(getDriver());
			adminDashboardPage = new AdminDashboardPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
			loginPage.clickOnLogInButton();
			adminDashboardPage.clickOnManagersLhsNavbar();
			companiesPage.clickOnPlusIconButton();
			String pageTitle = loginPage.getPageTitle();
			Assert.assertEquals(pageTitle, "Create New User | Aircon");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify Create User  title " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify Create User title");
		}
	}

	
	@Test(priority = 1, description = "TC_CreateUser_002 To verify Create User UI fields")
	public void Verify_Companies_page_UI_fields() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription("TC_CreateUser_002 To verify Create User UI fields");
			loginPage = new LoginPage(getDriver());
			adminDashboardPage = new AdminDashboardPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
//			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
//			loginPage.clickOnLogInButton();
			adminDashboardPage.clickOnManagersLhsNavbar();
		    Assert.assertTrue(adminDashboardPage.isCompanyNamePresent());
			Assert.assertTrue(companiesPage.isTableHeaderPrasentPresent());
				
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify Create User page UI fields " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Create User  page UI fields");
		}
	}
	
	@Test(priority = 2, description = "TC_CreateUser_003 To verify all validation message")
	public void Verify_All_validation_message() {

		try {
			log.info("************************* TC-004*************************");
			extentTest.setDescription(
					"TC_Login_003 To all verify validation message");
			loginPage = new LoginPage(getDriver());
			companiesPage = new CompaniesPage(getDriver());
			createCompaniesPage = new CreateCompaniesPage(getDriver());
			createUserPage = new CreateUserPage(getDriver());
			adminDashboardPage = new AdminDashboardPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
//			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
//			loginPage.clickOnLogInButton();
			adminDashboardPage.clickOnManagersLhsNavbar();
			companiesPage.clickOnPlusIconButton();
			createUserPage.clickOnCreateNewUserButton();
			String emailAddressFieldErrorMessage= createUserPage.getEmailValidationMessage();
			Assert.assertEquals(emailAddressFieldErrorMessage, "Please enter email address");
			String phoneValidationErrorMessage = createUserPage.getPhoneValidationMessage();
			Assert.assertEquals(phoneValidationErrorMessage, "Please enter phone no");
			String firstNameValidationErrorMessage = createUserPage.getFirstNameValidationMessage();
			Assert.assertEquals(firstNameValidationErrorMessage, "Please enter first name");
			String lastNameValidationErrorMessage = createUserPage.getLastNameValidationMessage();
			Assert.assertEquals(lastNameValidationErrorMessage, "Please enter last name");
			String roleValidationErrorMessage = createUserPage.getRoleValidationMessage();
			Assert.assertEquals(roleValidationErrorMessage, "Please select role");
			String passwordValidationErrorMessage = createUserPage.getPasswordValidationMessage();
			Assert.assertEquals(passwordValidationErrorMessage, "Please enter password");
			String confirmPasswordValidationErrorMessage = createUserPage.getPasswordConfirmationValidationMessage();
			Assert.assertEquals(confirmPasswordValidationErrorMessage, "Please enter confirm password");
		
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify_All_validation_message "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify_All_validation_message");
		}
	}
	
	
	@Test(priority = 2, description = "TC_CreateUser_004 To Verify Create User page With Enter Valid Data")
	public void Verify_Create_User_page_With_Enter_Valid_Data() {
	
		try {
			log.info("************************* TC-004*************************");
			extentTest.setDescription("TC_CreateUser_004 To Verify Create User page With Enter Valid Data");
			loginPage = new LoginPage(getDriver());
			companiesPage = new CompaniesPage(getDriver());
			createUserPage = new CreateUserPage(getDriver());
			createCompaniesPage = new CreateCompaniesPage(getDriver());
			adminDashboardPage = new AdminDashboardPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
			loginPage.clickOnLogInButton();
			adminDashboardPage.clickOnManagersLhsNavbar();
			companiesPage.clickOnPlusIconButton();
			Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(1000);  
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("username"+ randomInt +"@mailinator.com");  
			createCompaniesPage.enterPhoneNumber(config.getProperty("EnterPhone"));
			createUserPage.enterFirstName(config.getProperty("enterFirstName"));
			createUserPage.enterLastNameField(config.getProperty("enterLastNameField"));
			createUserPage.enterPasswordField(config.getProperty("UserPassword"));
			createUserPage.enterPasswordConfirmationField(config.getProperty("UserPassword"));
			createUserPage.clickOnSelectRoleFieldButton();
			Select designation = new Select(driver.findElement(By.id("role")));
			designation.selectByVisibleText("Manager");
			//designation.selectByIndex(1);
			createUserPage.clickOnCreateNewUserButton();
			createUserPage.clickOnSecondPaginationButton();
			createUserPage.clickOnEditButtonButton();
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify CreateCompany page UI fields " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Create Company UI fields");
		}
	}


	private String sendKeys(String string) {	
		return null;
	}
	
		
}
