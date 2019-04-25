package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.ConfigManager;
import Common.ActionMethods;

public class LoginPage extends ActionMethods {

	private String emailAddessField = "css:input[id='email']";
	private String passwordField = "css:input[id='password']";
	//private String signInBtn = "xpath://button[text()='Sign In']";
	private String logInBtn = "css:button.btn-primary";
	private String nameDropDown = "css:a.dropdown-toggle ";
    private String forgotPasswordLink = "css:a.btn-link";
	private String rememberMeCheckbox = "css:div.checkbox input[name='remember']";
	private String contactSupportLink = "css:a#contactSupport";
	private String emailErrorMsg = "css:input[id='email'] + span[class='invalid-feedback']";
	private String passwordErrorMsg = "css:input[id='password']+ span[class='invalid-feedback']";
	private String airconLogoImage = "css:div.login-logo";
	private String loginFromText = "css:form[name='loginForm'] h5";
	private String logoutBtn = "css:ul.dropdown-menu a";
	//private String errorMessage = "xpath://button[text()='Sign In']//following-sibling::span";
	public String hrefAttribute;
	public String errorMsg;
	public String webPageTitle;
	public String loginFromTexts;
	public String currentURL;
	public String backgroundColor, color, fontFamily;

	static WebDriver driver;
	public Logger log = Logger.getLogger(LoginPage.class);
	ConfigManager config;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}

	public String getContactSupportHrefAttribute() {

		waitForPageToLoad();
		waitForElementPresent(contactSupportLink, SHORTWAIT);
		hrefAttribute = safeGetAttribute(contactSupportLink, "href", SHORTWAIT);
		log.info("Get href attribute of 'Contact Support' link");
		return hrefAttribute;
	}


	public void enterEmailAddess(String strEmailAdd) {
		waitForPageToLoad();
		waitForElementPresent(emailAddessField, SHORTWAIT);
		safeClearAndType(emailAddessField, strEmailAdd, SHORTWAIT);
		log.info("Enter Username successfully");

	}

	public void enterPassword(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(passwordField, SHORTWAIT);
		safeClearAndType(passwordField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}

	public void enterCredentials(String strEmailAdd, String strPass) {
		waitForPageToLoad();
		waitForElementPresent(emailAddessField, SHORTWAIT);
		safeClearAndType(emailAddessField, strEmailAdd, SHORTWAIT);
		safeClearAndType(passwordField, strPass, SHORTWAIT);
		log.info("UserName and Password enter successfully");
	}

	public void clickOnLogInButton() {
		waitForElementClickable(logInBtn, SHORTWAIT);
		waitForElementVisible(logInBtn, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			//WebElement element = driver.findElement(By.xpath("//button[text()='Sign In']"));
			WebElement element = driver.findElement(findLocator(logInBtn));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(logInBtn, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on sign-in button successfully");

	}
	
	public void clickOnNameDropDownButton() {
		waitForElementClickable(nameDropDown, SHORTWAIT);
		waitForElementVisible(nameDropDown, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			//WebElement element = driver.findElement(By.xpath("//button[text()='Sign In']"));
			WebElement element = driver.findElement(findLocator(nameDropDown));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(nameDropDown, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on name Drop Down button successfully");
	}

	public void clickOnLogoutButton() {
		waitForElementClickable(logoutBtn, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(logoutBtn));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(logoutBtn, SHORTWAIT);
			needToWait(4);
		}
		log.info("Click on logout button successfully");
	}

	public void authLogin(String authname, String authpwd) {
		enterCredentials(config.getProperty(authname), config.getProperty(authpwd));
		clickOnLogInButton();

	}

	public String getEmailAddressErrorMessage() {
		waitForPageToLoad();
		waitForElementPresent(emailErrorMsg, SHORTWAIT);
		errorMsg = safeGetText(emailErrorMsg, SHORTWAIT);
		log.info("Get error message of 'Username' field");
		return errorMsg;
	}

	public String getPasswordErrorMessage() {
		waitForPageToLoad();
		waitForElementPresent(passwordErrorMsg, SHORTWAIT);
		errorMsg = safeGetText(passwordErrorMsg, SHORTWAIT);
		log.info("Get error message of 'Password' field");
		return errorMsg;
	}

	public String getInvalidCredentialsErrorMessage() {
		waitForPageToLoad();
		waitForElementPresent(emailErrorMsg, SHORTWAIT);
		errorMsg = safeGetText(emailErrorMsg, SHORTWAIT);
		log.info("Get error message for invalid credentials.");
		return errorMsg;
	}


	public boolean isAirconLogoImagePresent() {
		return isElementVisible(airconLogoImage, SHORTWAIT);
	}

	public boolean isEmailfieldPresent() {
		return isElementVisible(emailAddessField, SHORTWAIT);
	}

	public boolean isPasswordFieldPresent() {
		return isElementVisible(passwordField, SHORTWAIT);
	}

	public boolean isSignInButtonPresent() {
		return isElementVisible(logInBtn, SHORTWAIT);
	}

	public boolean isForgotPasswordLinkPresent() {
		return isElementVisible(forgotPasswordLink, SHORTWAIT);
	}
	
	public boolean isRememberMeCheckboxPresent() {
		return isElementVisible(rememberMeCheckbox, SHORTWAIT);
	}
	
	public boolean isContactRequestLinkPresent() {
		return isElementVisible(contactSupportLink, SHORTWAIT);
	}

	public String getPageTitle() {
		waitForPageToLoad();
		webPageTitle = getTitle();
		return webPageTitle;
	}

	public String getCurrentWebpageURL() {
		waitForPageToLoad();
		needToWait(3);
		currentURL = getCurrentURL();
		return currentURL;
	}

	public String getLoginFormText() {
		waitForPageToLoad();
		waitForElementPresent(loginFromText, SHORTWAIT);
		loginFromTexts = safeGetText(loginFromText, SHORTWAIT);
		return loginFromTexts;
	}

	public String getlogInButtonBackgroundColor() {
		waitForPageToLoad();
		waitForElementPresent(logInBtn, SHORTWAIT);
		backgroundColor = getCssValue(logInBtn, "background-color", SHORTWAIT);
		return backgroundColor;
	}

	public String getlogInButtonTextColor() {
		color = getCssValue(logInBtn, "color", SHORTWAIT);
		return color;
	}
	
	public String getContactSupportLinkColor() {
		color = getCssValue(contactSupportLink, "color", SHORTWAIT);
		return color;
	}

	public String getEmailAddresssErrorMsgTextColor() {
		color = getCssValue(emailErrorMsg, "color", SHORTWAIT);
		return color;
	}

	public String getPasswordErrorMsgTextColor() {
		color = getCssValue(passwordErrorMsg, "color", SHORTWAIT);
		return color;
	}

	public String getLoginFormTextColor() {
		color = getCssValue(loginFromText, "color", SHORTWAIT);
		return color;
	}

	public String getMapfreLogoBackgroundColor() {
		waitForPageToLoad();
		waitForElementPresent(airconLogoImage, SHORTWAIT);
		backgroundColor = getCssValue(airconLogoImage.replace(" a img", ""), "background-color", SHORTWAIT);
		return backgroundColor;
	}
}
