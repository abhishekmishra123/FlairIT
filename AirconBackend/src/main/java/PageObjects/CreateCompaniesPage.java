package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.ConfigManager;
import Common.ActionMethods;

public class CreateCompaniesPage extends ActionMethods{
	
	private String tableHeaderPrasent = "css:.content.table-responsive.table-full-width table.table-striped ";
	private String companyDetailsHeader= "xpath://div[text()='COMPANY DETAILS']";
	private String companiesLhsNavbar = "xpath://p[text()='Companies']";
	private String plusIcon = "css:i.fa-plus";
	private String companyValidation = "css:input[id='company_name'] + span[class='help-block input-error']";
	private String uploadButton = "css:input[name='company_logo']";
	
	private String phoneValidation = "css:input[id='phone'] + span[class='help-block input-error']";
	private String freeUntillValidation = "css:input[id='free_untill'] + span[class='input-error']";
	private String addressValidation = "css:input[id='address'] + span[class='help-block input-error']";
	private String cityValidation = "css:input[id='city'] + span[class='help-block input-error']";
	private String locationValidation = "css:input[id='pac-input'] + span[class='help-block input-error']";
	private String emailValidation = "css:input[id='email'] + span[class='help-block input-error']";
	private String saveButton = "xpath://button[text()='Save']";
	private String companyField = "css:input#company_name";
	private String emailField = "css:input#email";
	private String phoneField = "css:input#phone";
	private String addressField = "css:input#address";
	private String cityField = "css:input#city";
	private String locationField = "css:input#pac-input";
	
	
	
	
	
	
	
	
	
	
	static WebDriver driver;
	public Logger log = Logger.getLogger(LoginPage.class);
	ConfigManager config;
	
	public CreateCompaniesPage(WebDriver driver) {
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
	
	public String getCompanyValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(companyValidation, SHORTWAIT);
		companyValidation = safeGetText(companyValidation, SHORTWAIT);
		log.info("Get error message of 'Company' field");
		return companyValidation;
	}
	
	public String getEmailValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(emailValidation, SHORTWAIT);
		emailValidation = safeGetText(emailValidation, SHORTWAIT);
		log.info("Get error message of 'Email' field");
		return emailValidation;
	}
	
	
	
	public String getPhoneValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(phoneValidation, SHORTWAIT);
		phoneValidation = safeGetText(phoneValidation, SHORTWAIT);
		log.info("Get error message of 'Phone' field");
		return phoneValidation;
	}
	
	public String getFreeUntillValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(freeUntillValidation, SHORTWAIT);
		freeUntillValidation = safeGetText(freeUntillValidation, SHORTWAIT);
		log.info("Get error message of 'FreeUntil' field");
		return freeUntillValidation;
	}
	
	public String getAddressValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(addressValidation, SHORTWAIT);
		addressValidation = safeGetText(addressValidation, SHORTWAIT);
		log.info("Get error message of 'Address' field");
		return addressValidation;
	}
	
	public String getCityValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(cityValidation, SHORTWAIT);
		cityValidation = safeGetText(cityValidation, SHORTWAIT);
		log.info("Get error message of 'city' field");
		return cityValidation;
	}

	public String getLocationValidationMessage() {
		waitForPageToLoad();
		waitForElementPresent(locationValidation, SHORTWAIT);
		locationValidation = safeGetText(locationValidation, SHORTWAIT);
		log.info("Get error message of 'Location' field");
		return locationValidation;
	}
	
	public void clickOnSaveButton() {
		waitForElementClickable(saveButton, SHORTWAIT);
		waitForElementVisible(saveButton, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(saveButton));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(saveButton, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on name save  button successfully");
	}
	
	
	public void enterCompanyName(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(companyField, SHORTWAIT);
		safeClearAndType(companyField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}
	
	public void clickOnUploadButton() {
		waitForElementClickable(uploadButton, SHORTWAIT);
		waitForElementVisible(uploadButton, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(uploadButton));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(uploadButton, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on upload  button successfully");

	}

	
	public void enterEmail(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(emailField, SHORTWAIT);
		safeClearAndType(emailField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}
	
	
	 public String generateEmail(int length) {
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    "_-.";   //special characters
		  String email="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  email=temp.substring(0,temp.length()-9)+"@test.org";
		  return email;
		 }
	
	

	public void enterPhoneNumber(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(phoneField, SHORTWAIT);
		safeClearAndType(phoneField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}
	
	public void enterAddressField(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(addressField, SHORTWAIT);
		safeClearAndType(addressField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}
	
	public void enterCityField(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(cityField, SHORTWAIT);
		safeClearAndType(cityField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}
	
	public void enterLocationField(String strPass) {
		waitForPageToLoad();
		waitForElementPresent(locationField, SHORTWAIT);
		safeClearAndType(locationField, strPass, SHORTWAIT);
		log.info("Enter password successfully");
		needToWait(3);
	}
	
}
