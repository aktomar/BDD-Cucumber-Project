package stepsDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.OrangeHRM_LoginPage;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class orangeHRM_LoginSteps extends BaseClass{
	
	
	
	
	
	@Given("Launch Browser and Open Application")
	public void launch_browser_and_open_application() {
		
		System.setProperty("WebDriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		lp = new OrangeHRM_LoginPage(driver);
		driver.manage().window().maximize();
		
	}

	@When("Enter Username {string} and Password {string}")
	public void enter_username_and_password(String username, String password) {
	    lp.EnterUsername(username);
	    lp.EnterPassword(password);
	}

	@Then("Click on Login Button")
	public void click_on_login_button() {
	    lp.ClickLoginButton();
	}

	@Then("Navigate to Home Page")
	public void navigate_to_home_page() {
	    String title = lp.verifyHomePageTitle();
	    
	    
	    System.out.println("U R ON Home Page"+title);
	}

	@Then("close the browser")
	public void close_the_brower() {
	   
		lp.CloseBrowser();
	}


}
