package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.ConfigManager;
import Common.ActionMethods;

public class CreateUserPage extends ActionMethods{
	
	private String tableHeaderPrasent = "css:.content.table-responsive.table-full-width table.table-striped ";
	private String companyDetailsHeader= "xpath://div[text()='COMPANY DETAILS']";
	private String plusIcon = "css:i.fa-plus";
	private String phoneValidation = "css:input[id='phone'] + span[class='help-block input-error']";
	private String emailValidation = "css:input[id='email'] + span[class='help-block input-error']";
	private String firstNameValidation = "css:input[id='first_name'] + span[class='help-block input-error']";
	private String lastNameValidation = "css:input[id='last_name'] + span[class='help-block input-error']";
	private String roleValidation = "css:select[id='role'] + span[class='help-block input-error']";
	private String passwordValidation = "css:input[id='password'] + span[class='help-block input-error']";
	private String passwordConfirmationValidation = "css:input[id='password_confirmation'] + span[class='help-block input-error']";
	private String secondPagination= "xpath://a[text()='2']";
	private String editButton = "xpath://a[@class='btn btn-sm btn-info btn-block']//preceding-sibling::i[@class='fa fa-edit']";
	
	
	
	
	private String emailField = "css:input#email";
	private String phoneField = "css:input#phone";
	private String firstNameField = "css:input#first_name";
	private String lastNameField = "css:input#last_name";
	private String passwordField = "css:input#password";
	private String passwordConfirmationField = "css:input#password_confirmation";
	private String selectRoleField = "css:select#role";
	
	
	private String createNewUserButton = "css:button[type='submit']";
	
	
	static WebDriver driver;
	public Logger log = Logger.getLogger(LoginPage.class);
	ConfigManager config;
	
	public CreateUserPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}
	
	public boolean isCompanyDetailsHeaderPresent(String sections) {
		return isElementVisible(companyDetailsHeader, SHORTWAIT);
	}

	public boolean isTableHeaderPrasentPresent() {
		return isElementVisible(tableHeaderPrasent, SHORTWAIT);
	}
	
	public void clickOnPlusIconButton() {
		waitForElementClickable(plusIcon, SHORTWAIT);
		waitForElementVisible(plusIcon, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(plusIcon));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(plusIcon, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on name plusIcon button successfully");
	}
	
	public String getEmailValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(emailValidation, SHORTWAIT);
		emailValidation = safeGetText(emailValidation, SHORTWAIT);
		log.info("Get error message of 'Email' field");
		return emailValidation;
	}
	
	public String getFirstNameValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(firstNameValidation, SHORTWAIT);
		firstNameValidation = safeGetText(firstNameValidation, SHORTWAIT);
		log.info("Get error message of 'Email' field");
		return firstNameValidation;
	}
	
	public String getLastNameValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(lastNameValidation, SHORTWAIT);
		lastNameValidation = safeGetText(lastNameValidation, SHORTWAIT);
		log.info("Get error message of 'Email' field");
		return lastNameValidation;
	}
	
	public String getRoleValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(roleValidation, SHORTWAIT);
		roleValidation = safeGetText(roleValidation, SHORTWAIT);
		log.info("Get error message of 'Email' field");
		return roleValidation;
	}
	
	public String getPasswordValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(passwordValidation, SHORTWAIT);
		passwordValidation = safeGetText(passwordValidation, SHORTWAIT);
		log.info("Get error message of 'Email' field");
		return passwordValidation;
	}
	
	public String getPasswordConfirmationValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(passwordConfirmationValidation, SHORTWAIT);
		passwordConfirmationValidation = safeGetText(passwordConfirmationValidation, SHORTWAIT);
		log.info("Get error message of 'Email' field");
		return passwordConfirmationValidation;
	}
	
	
	
	public String getPhoneValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(phoneValidation, SHORTWAIT);
		phoneValidation = safeGetText(phoneValidation, SHORTWAIT);
		log.info("Get error message of 'Phone' field");
		return phoneValidation;
	}
	
	public void clickOnCreateNewUserButton() {
		waitForElementClickable(createNewUserButton, SHORTWAIT);
		waitForElementVisible(createNewUserButton, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(createNewUserButton));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(createNewUserButton, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on name save  button successfully");
	}
	
	public void enterEmail(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(emailField, SHORTWAIT);
		safeClearAndType(emailField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}

	public void enterPhoneNumber(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(phoneField, SHORTWAIT);
		safeClearAndType(phoneField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}
	
	public void enterFirstName(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(firstNameField, SHORTWAIT);
		safeClearAndType(firstNameField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}
	
	public void enterLastNameField(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(lastNameField, SHORTWAIT);
		safeClearAndType(lastNameField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}
	
	public void enterPasswordField(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(passwordField, SHORTWAIT);
		safeClearAndType(passwordField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}
	
	public void enterPasswordConfirmationField(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(passwordConfirmationField, SHORTWAIT);
		safeClearAndType(passwordConfirmationField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}
	
	public void clickOnSelectRoleFieldButton() {
		waitForElementClickable(selectRoleField, SHORTWAIT);
		waitForElementVisible(selectRoleField, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(selectRoleField));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(selectRoleField, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on role  button successfully");
	}
	
	public void clickOnEditButtonButton() {
		waitForElementClickable(editButton, SHORTWAIT);
		waitForElementVisible(editButton, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(editButton));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(editButton, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on role  button successfully");
	}
	
	public void clickOnSecondPaginationButton() {
		waitForElementClickable(secondPagination, SHORTWAIT);
		waitForElementVisible(secondPagination, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(secondPagination));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(secondPagination, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on second Pagination  button successfully");
	}
	
	
}
