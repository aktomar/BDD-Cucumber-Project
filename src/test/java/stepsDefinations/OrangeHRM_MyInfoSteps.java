package stepsDefinations;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import PageObjects.OrangeHRM_MyInfoPage;
import PageObjects.OrangeHRM_SearchEmployePage;
import io.cucumber.java.*;
import io.cucumber.java.en.*;


public class OrangeHRM_MyInfoSteps extends BaseClass{
	
	@Before
	public void Setup() throws IOException{
		
		//Reading properties file........
		configprop = new Properties();
		FileInputStream configProfile = new FileInputStream("Config.properties");
		configprop.load(configProfile);
		
		//Logger configuration......
		logger = Logger.getLogger("BDDCucumber");
		PropertyConfigurator.configure("log4j.properties");
		
		//Checking with different browsers............
		
		String br = configprop.getProperty("Browser");
		if(br.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver",configprop.getProperty("ChromePath"));
		driver = new ChromeDriver();
		logger.info(" Launched Chrome Browser...................");
		}
		else if(br.equals("firefox")) 
		{
			System.setProperty("WebDriver.gecko.driver",configprop.getProperty("firefox"));
			driver = new FirefoxDriver();
			logger.info("Launching Firefox Browser....................");
		}
		else if(br.equals("IE"))
		{
			System.setProperty("WebDriver.ie.driver",configprop.getProperty("IE"));
			driver = new InternetExplorerDriver();
			logger.info("Launching IE Browser.......................");
		}
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		logger.info("Maximised Browser..................");
	}	
	
	
	@Given("Launch Browser and Open OrangeHRM Application")
	public void launch_browser_and_open_application() {
		     
		ip = new OrangeHRM_MyInfoPage(driver);
		
	}

	@When("Enter Uname {string} and Paswrd {string}")
	public void enter_username_and_password(String username, String password) {
	    ip.EnterUsername(username);
	    ip.EnterPassword(password);
	    logger.info("Entered username and password..................");
	}

	@Then("Click on application Login Button")
	public void click_on_login_button() {
	    ip.ClickLoginButton();
	    logger.info("Clicked On login button..................");
	}

	@Then("Navigate to Home PageUI")
	public void navigate_to_home_page() {
	    String title = ip.verifyHomePageTitle();
	    logger.info("Navigated to home page..................");
	    System.out.println("U R ON Home Page"+title);
	}
	
	//Adding New Employee Personal Details Step Definitions............................................
	
	@Then("click on MyInfo tab and navigate to employee details UI")
	public void click_on_my_info_tab_and_navigate_to_employee_details_ui() {
	    ip.ClickOnMyInfoTab();
	    logger.info("Clicked on MyInfo tab............");
	}

	@And("Click on Edit button")
	public void click_on_edit_button() {
	   ip.ClickOnEditButton();
	   logger.info("Clicked on Edit button...............");
	}

	@And("Enter the employee details")
	public void enter_the_employee_details() throws InterruptedException {
	    ip.EnterFirstname("Akshay");
	    ip.EnterLastname("Tomar");
	    Thread.sleep(3000);
	    ip.EnterEmployeeID();
	    Thread.sleep(2000);
	    ip.SelectGender();
	    ip.SelectNationality();
	    Thread.sleep(2000);
	    logger.info("Entered employee details.............");
	    
	}
	
   @Then("click on save button")
	public void click_on_save_button() throws InterruptedException {
	    ip.ClickOnSaveButton();
	    Thread.sleep(3000);
	    logger.info("Saved employee details...........");
	}
   
   @And("close browser")
  	public void close_the_brower() {
  	    ip.CloseBrowser();
  	    logger.info("Browser Closed...................");
  	}
   
   //Search Employee Step Definitions.............................................................
   
   
   @When("Click on PIM tab")
   public void click_on_pim_tab() throws InterruptedException {
       
	   se = new OrangeHRM_SearchEmployePage(driver);
	   se.HoverToPIMtab();
	   Thread.sleep(2000);
	   logger.info("Clicked on PIM tab..........");

   }

   @And("Click on Employee tab")
   public void click_on_employee_tab() throws InterruptedException {
       se.ClickOnEmployeeList();
       Thread.sleep(2000);
       logger.info("Clicked on EmployeeList tab...............");
   }

   @And("Search employee details by passing name")
   public void search_employee_details_by_passing_name() throws InterruptedException {
       se.EnterEmployeeNameToSearch("Akshay");
       Thread.sleep(2000);
       logger.info("Passed employeeName to search...........");
       
   
   }

   @Then("click on search button")
   public void click_on_search_button() throws InterruptedException {
     se.ClickOnSearchButton();
     Thread.sleep(3000);
     boolean status = se.SearchByEmployeeName("Akshay");
     Assert.assertEquals(true, status);
     System.out.println("EMPLOYEE EXIST....................");
     logger.info("Employee verified.............");
   
   }

   
  


}
