package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.ConfigManager;
import Common.ActionMethods;

public class UserPage extends ActionMethods{
	
	private String tableHeaderPrasent = "css:.content.table-responsive.table-full-width table.table-striped ";
	private String dashboardSection = "xpath://p[text()='sections']";
	private String companiesLhsNavbar = "xpath://p[text()='Companies']";
	private String plusIcon = "xpath://a[@class='btn'] //i[@class='fa fa-plus']";
	
	
	
	
	
	
	
	
	static WebDriver driver;
	public Logger log = Logger.getLogger(LoginPage.class);
	ConfigManager config;
	
	public UserPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}
	
	public boolean isDashboardSectionPresent(String sections) {
		return isElementVisible(dashboardSection.replace("sections", sections), SHORTWAIT);
	}

	public boolean isTableHeaderPrasentPresent() {
		return isElementVisible(tableHeaderPrasent, SHORTWAIT);
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
	
	
}
