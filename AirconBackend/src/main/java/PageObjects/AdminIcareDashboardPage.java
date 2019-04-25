package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.ConfigManager;
import Common.ActionMethods;

public class AdminIcareDashboardPage extends ActionMethods{
	
	private String pageHeader = "css:a.navbar-brand";
	private String dashboardSection = "xpath://p[text()='sections']";
	private String unitmanagementLhsNavbar = "xpath://a[text()=' UNITS MANAGEMENT']";
	private String unitNavbar = "xpath://a[text()='Unit  ']";
	private String viewNavbar = "xpath://a[text()='View']";
	private String ptdNumber = "css:input#unit_ptd";
	private String blockNumber = "css:input#block_number";
	private String houseNumber = "css:input#house_number";
	private String address = "css:input#address";
	private String maintenanceAmount = "css:input#maintenance_amount";
	private String sinkingAmount = "css:input#sinking_amount";
	private String saveButton = "css:input[value='Save']";
	private String iMembers = "css:.btn-info.btn-circle.details-control";
	
	private String selectCode = "css:select#country_code";
	
	
	
	
	
	
	
	
	static WebDriver driver;
	public Logger log = Logger.getLogger(LoginPage.class);
	ConfigManager config;
	
	public AdminIcareDashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}
	
	public boolean isDashboardSectionPresent(String sections) {
		return isElementVisible(dashboardSection.replace("sections", sections), SHORTWAIT);
	}

	public boolean isCompanyNamePresent() {
		return isElementVisible(pageHeader, SHORTWAIT);
	}
	
	public boolean isPageHeaderPresent() {
		return isElementVisible(pageHeader, SHORTWAIT);
	}
	
	
	public void clickOnCompaniesLhsNavbar() {
		waitForElementClickable(unitmanagementLhsNavbar, SHORTWAIT);
		waitForElementVisible(unitmanagementLhsNavbar, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(unitmanagementLhsNavbar));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(unitmanagementLhsNavbar, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on name unit management LHS Navbar button successfully");
	}
	
	public void clickOnUnitNavbar() {
		waitForElementClickable(unitNavbar, SHORTWAIT);
		waitForElementVisible(unitNavbar, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(unitNavbar));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(unitNavbar, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on name Unit Navbar button successfully");
	}
	
	public void clickOnViewNavbar() {
		waitForElementClickable(viewNavbar, SHORTWAIT);
		waitForElementVisible(viewNavbar, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(viewNavbar));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(viewNavbar, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on name view Navba Navbar button successfully");
	}
	
	
	public void clickOnIMembers() {
		waitForElementClickable(iMembers, SHORTWAIT);
		waitForElementVisible(iMembers, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(iMembers));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(iMembers, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on name view Navba Navbar button successfully");
	}
	
	

	    public String generateRandomString(int length){
		  return RandomStringUtils.randomAlphabetic(length);
		  
		 }
		 
		 public String generateRandomNumber(int length){
		  return RandomStringUtils.randomNumeric(length);
		 }
		 
		 
		 public String getPtdNumber() {
				waitForPageToLoad();
				waitForElementPresent(ptdNumber, SHORTWAIT);
				ptdNumber = safeGetText(ptdNumber, SHORTWAIT);
				//log.info("Get error message of 'Username' field");
				return ptdNumber;
			}

		 
		 public String generateRandomAlphaNumeric(int length){
		  return RandomStringUtils.randomAlphanumeric(length);
		 }
		 
		 public String generateStringWithAllobedSplChars(int length,String allowdSplChrs){
			  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
			    "1234567890" +   //numbers
			    allowdSplChrs;
			  return RandomStringUtils.random(length, allowedChars);
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
			 
			 
			 public void clickOnSelectCodeButton() {
					waitForElementClickable(selectCode, SHORTWAIT);
					waitForElementVisible(selectCode, SHORTWAIT);
					String browserName = config.getProperty("Browser.Name");
					needToWait(2);
					if (browserName.equalsIgnoreCase("ie")) {
						WebElement element = driver.findElement(findLocator(selectCode));
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", element);
					}else {
						safeClick(selectCode, SHORTWAIT);
					}
					needToWait(3);
					log.info("Click on code  button successfully");
				}
				
	
	
	
}
