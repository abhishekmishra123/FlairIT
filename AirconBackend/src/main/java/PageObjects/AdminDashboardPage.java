package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.ConfigManager;
import Common.ActionMethods;

public class AdminDashboardPage extends ActionMethods{
	
	private String pageHeader = "css:a.navbar-brand";
	private String dashboardSection = "xpath://p[text()='sections']";
	private String companiesLhsNavbar = "xpath://p[text()='Companies']";
	private String managersLhsNavbar = "xpath://p[text()='Managers']";
	
	
	
	static WebDriver driver;
	public Logger log = Logger.getLogger(LoginPage.class);
	ConfigManager config;
	
	public AdminDashboardPage(WebDriver driver) {
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
		waitForElementClickable(companiesLhsNavbar, SHORTWAIT);
		waitForElementVisible(companiesLhsNavbar, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(companiesLhsNavbar));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(companiesLhsNavbar, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on name companies LHS Navbar button successfully");
	}
	
	public void clickOnManagersLhsNavbar() {
		waitForElementClickable(managersLhsNavbar, SHORTWAIT);
		waitForElementVisible(managersLhsNavbar, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(managersLhsNavbar));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}else {
			safeClick(managersLhsNavbar, SHORTWAIT);
		}
		needToWait(3);
		log.info("Click on name companies LHS Navbar button successfully");
	}
}
