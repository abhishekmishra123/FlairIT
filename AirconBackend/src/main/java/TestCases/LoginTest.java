package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.LoginPage;
import org.apache.log4j.Logger;

public class LoginTest extends BaseSetup {
	LoginPage loginPage;
	static Logger log = Logger.getLogger(LoginTest.class);

	@Test(priority = 0, description = "TC_Login_001 To verify login page title")
	public void Verify_login_page_title() {

		try {
			log.info("************************* TC-001*************************");
			extentTest.setDescription("TC_Login_001 To verify login page title");
			loginPage = new LoginPage(getDriver());
			String pageTitle = loginPage.getPageTitle();
			Assert.assertEquals(pageTitle, "Aircon");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify login page title " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify login page title");
		}
	}

	@Test(priority = 1, description = "TC_Login_002 To verify login page url")
	public void Verify_login_page_url() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription("TC_Login_002 To verify login page url");
			loginPage = new LoginPage(getDriver());
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("stage-aircon")) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify login page URL " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify login page URL");
		}
	}

	@Test(priority = 2, description = "TC_Login_003 To verify login page UI fields")
	public void Verify_login_page_UI_fields() {

		try {
			log.info("************************* TC-003*************************");
			extentTest.setDescription("TC_Login_003 To verify login page UI fields");
			loginPage = new LoginPage(getDriver());
			Assert.assertTrue(loginPage.isAirconLogoImagePresent());
			Assert.assertTrue(loginPage.isEmailfieldPresent());
			Assert.assertTrue(loginPage.isPasswordFieldPresent());
			Assert.assertTrue(loginPage.isSignInButtonPresent());
			Assert.assertTrue(loginPage.isForgotPasswordLinkPresent());
			Assert.assertTrue(loginPage.isRememberMeCheckboxPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify login page UI fields " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify login page UI fields");
		}
	}

	@Test(priority = 3, description = " TC_Login_004  To verify validation message with valid 'Email Address' and empty 'Password' field")
	public void Verify_validation_message_with_valid_EmailAddress_and_empty_Password_field() {

		try {
			log.info("************************* TC-004*************************");
			extentTest.setDescription(
					"TC_Login_004 To To verify validation message with valid 'Email Address' and empty 'Password' field");
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
			loginPage.clickOnLogInButton();
			String errorMsg = loginPage.getPasswordErrorMessage();
			Assert.assertEquals(errorMsg, "Please enter your password");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify validation message with valid 'Email Address' and empty 'Password' field "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify validation message with valid 'Email Address' and empty 'Password' field");
		}
	}

	@Test(priority = 4, description = "TC-005 To verify validation message with valid 'Password' and empty 'Email Address' field")
	public void Verify_validation_message_with_valid_password_and_empty_EmailAddress_field() {

		try {
			log.info("************************* TC-005*************************");
			extentTest.setDescription(
					"TC_Login_005 To verify validation message with valid 'Password' and empty 'Email Address' field");
			loginPage = new LoginPage(getDriver());
			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
			loginPage.clickOnLogInButton();
			String errorMsg = loginPage.getEmailAddressErrorMessage();
			Assert.assertEquals(errorMsg, "Please enter your email address");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify validation message with valid 'Password' and empty 'email address' field "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify validation message with valid 'Password' and empty 'email address' field");
		}
	}

	@Test(priority = 5, description = "TC_Login_006 To verify validation message with empty 'email address' and empty 'Password' field")
	public void Verify_validation_message_with_empty_email_address_and_empty_password_field() {

		try {
			log.info("************************* TC-006*************************");
			extentTest.setDescription(
					"TC_Login_006 To verify validation message with empty 'email address' and empty 'Password' field");
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess("");
			loginPage.enterPassword("");
			loginPage.clickOnLogInButton();
			String emailAddressFieldErrorMsg = loginPage.getEmailAddressErrorMessage();
			String passwordFieldErrorMsg = loginPage.getPasswordErrorMessage();
			Assert.assertEquals(emailAddressFieldErrorMsg, "Please enter your email address");
			Assert.assertEquals(passwordFieldErrorMsg, "Please enter your password");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify validation message with empty 'email address' and empty 'Password' field "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify validation message with empty 'email address' and empty 'Password' field");
		}
	}

	@Test(priority = 6, description = "TC_Login_007 To verify validation message with invalid 'Email address' and invalid 'Password'")
	public void Verify_validation_message_with_invalid_email_address_and_invalid_Password_field() {

		try {
			log.info("************************* TC-007*************************");
			extentTest.setDescription(
					"TC_Login_007 To verify validation message with invalid 'Email address' and invalid 'Password' field");
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("InvalidUsername"));
			loginPage.enterPassword(config.getProperty("InvalidPassword"));
			loginPage.clickOnLogInButton();
			String errorMsg = loginPage.getInvalidCredentialsErrorMessage();
			System.out.println("errorMsg ->" + errorMsg);
			Assert.assertEquals(errorMsg,
					"This combination of email address and password is incorrect. Please try again");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify validation message with invalid 'email address' and invalid 'Password' field "
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable to verify validation message with invalid 'email address' and invalid 'Password' field");
		}
	}

	@Test(priority = 7, description = "TC_Login_08 To verify css value of login page fields")
	public void Verify_CSS_value_of_login_page_fields() {

		try {
			log.info("************************* TC-08*************************");
			extentTest.setDescription("TC_Login_08 To verify css value of login page fields");
			loginPage = new LoginPage(getDriver());
			String browserName = config.getProperty("Browser.Name");
			if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("ie")) {
				 Assert.assertEquals(loginPage.getlogInButtonBackgroundColor(), "rgba(44, 94, 1, 1)");
				 Assert.assertEquals(loginPage.getlogInButtonTextColor(), "rgba(255, 255, 255, 1)");
				 loginPage.clickOnLogInButton();
				 Assert.assertEquals(loginPage.getEmailAddressErrorMessage(), "Please enter your email address");
				 Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Please enter your password");
				 Assert.assertEquals(loginPage.getEmailAddresssErrorMsgTextColor(), "rgba(220, 53, 69, 1)");
				 Assert.assertEquals(loginPage.getPasswordErrorMsgTextColor(), "rgba(220, 53, 69, 1)");
			} else {
				 Assert.assertEquals(loginPage.getlogInButtonBackgroundColor(), "rgb(44, 94, 1,)");
				 Assert.assertEquals(loginPage.getlogInButtonTextColor(), "rgb(255, 255,255)");		   
				 loginPage.clickOnLogInButton();
				 Assert.assertEquals(loginPage.getEmailAddressErrorMessage(), "Please enter your email address");
				 Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Please enter your password");
				 Assert.assertEquals(loginPage.getEmailAddresssErrorMsgTextColor(), "rgb(220, 53, 69)");
				 Assert.assertEquals(loginPage.getPasswordErrorMsgTextColor(), "rgb(220, 53, 69)");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify css value of login page fields " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify css value of login page fields");
		}
	}

	@Test(priority = 8, description = "TC_Login_09 To verify login functionality with valid credentials of administrator")
	public void Verify_login_functionality_with_valid_credentials_of_administrator() {
		try {
			log.info("************************* TC-09*************************");
			extentTest.setDescription(
					"TC_Login_014 To verify login functionality with valid credentials of administrator");
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmail"));
			loginPage.enterPassword(config.getProperty("AdministratorPassword"));
			loginPage.clickOnLogInButton();
			String currentUrl = loginPage.getCurrentWebpageURL();
			Assert.assertTrue(currentUrl.contains("home"));
			loginPage.clickOnNameDropDownButton();
			loginPage.clickOnLogoutButton();
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify login functionality with valid credentials of administrator "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify login functionality with valid credentials of administrator");
		}
	}

}
