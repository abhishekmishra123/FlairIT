package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.AdminIcareDashboardPage;
import PageObjects.CompaniesPage;
import PageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;


public class LoginIcareTest extends BaseSetup {
	LoginPage loginPage;
	AdminIcareDashboardPage adminIcareDashboardPage;
	CompaniesPage companiesPage;
	
	
	static Logger log = Logger.getLogger(LoginIcareTest.class);

	@Test(priority = 8, description = "TC_Login_09 To verify login functionality with valid credentials of administrator")
	public void Verify_login_functionality_with_valid_credentials_of_administrator() {
		try {
			log.info("************************* TC-09*************************");
			extentTest.setDescription(
					"TC_Login_014 To verify login functionality with valid credentials of administrator");
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmailIcare"));
			loginPage.enterPassword(config.getProperty("AdministratorPasswordIcare"));
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
	
	
	@Test(priority = 8, description = "")
	public void Verify_Create_Company_page_With_Enter_Valid_Data() {
		try {
			log.info("************************* TC-09*************************");
			extentTest.setDescription(
					"TC_Login_02 To Verify_Create_Company_page_With_Enter_Valid_Data");
			loginPage = new LoginPage(getDriver());
			companiesPage = new CompaniesPage(getDriver());
			adminIcareDashboardPage = new AdminIcareDashboardPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("AdministratorEmailIcare"));
			loginPage.enterPassword(config.getProperty("AdministratorPasswordIcare"));
			loginPage.clickOnLogInButton();
		    adminIcareDashboardPage.clickOnCompaniesLhsNavbar();
		    adminIcareDashboardPage.clickOnUnitNavbar();
		    adminIcareDashboardPage.clickOnViewNavbar();
		    driver.findElement(By.xpath("//span[@class='btn btn-default  my_btn']")).click();
		    driver.findElement(By.id("unit_ptd")).sendKeys(adminIcareDashboardPage.generateRandomNumber(2));  
		    driver.findElement(By.id("block_number")).sendKeys(adminIcareDashboardPage.generateRandomNumber(2));  
		    driver.findElement(By.id("house_number")).sendKeys(adminIcareDashboardPage.generateRandomAlphaNumeric(3)); 
		    driver.findElement(By.id("address")).sendKeys(adminIcareDashboardPage.generateRandomString(10));
		    driver.findElement(By.id("maintenance_amount")).sendKeys(adminIcareDashboardPage.generateRandomNumber(2));
		    driver.findElement(By.id("sinking_amount")).sendKeys(adminIcareDashboardPage.generateRandomNumber(2));
		    driver.findElement(By.xpath("//input[@class='btn btn-default my_btn']")).click();
		    driver.findElement(By.xpath("//a[@class='paginate_button next']")).click();

		    adminIcareDashboardPage.clickOnIMembers();
		    driver.findElement(By.xpath("//span[@class='btn btn-default  my_btn']")).click();
		    adminIcareDashboardPage.clickOnSelectCodeButton();
			Select designation = new Select(driver.findElement(By.id("country_code")));
			designation.selectByVisibleText("IN");
		    driver.findElement(By.xpath("//input[@id='cell_number']")).sendKeys(adminIcareDashboardPage.generateRandomNumber(10));
		    Thread.sleep(2000);
//		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		    driver.findElement(By.xpath("//input[@id='cell_number']")).sendKeys(Keys.ENTER);
//		    Thread.sleep(2000);
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys(adminIcareDashboardPage.generateRandomString(10));
		    Thread.sleep(2000);
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//input[@id='nickname']")).sendKeys(adminIcareDashboardPage.generateRandomString(5));
		    Thread.sleep(2000);
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//input[@id='nric']")).sendKeys(adminIcareDashboardPage.generateRandomString(4));
		    Thread.sleep(2000);
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(adminIcareDashboardPage.generateEmail(30));
		    Thread.sleep(2000);
		    
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//input[@class='btn btn-success my_btn']")).click();
		    driver.findElement(By.xpath("//input[@class='btn btn-success my_btn']")).click();
		    
		    // Switching to Alert        
	        driver.switchTo().alert().accept();
 	       Thread.sleep(2000);
		   
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify login functionality with valid credentials of administrator "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify login functionality with valid credentials of administrator");
		}
	}
	
	
	
	
	
	

}
