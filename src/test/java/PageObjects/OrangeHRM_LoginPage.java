package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_LoginPage {
	
	
	WebDriver ldriver;
	
	public OrangeHRM_LoginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	@FindBy(id="txtUsername")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="txtPassword")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="Submit")
	@CacheLookup
	WebElement Submit;
	
	@FindBy(xpath="//*[text()=\"OrangeHRM\"]")
	@CacheLookup
	WebElement title;
	
	public void EnterUsername(String uname) {
		username.sendKeys(uname);
	}
	public void EnterPassword(String pass) {
		password.sendKeys(pass);
	}
	public void ClickLoginButton() {
		Submit.click();
	}
	public String verifyHomePageTitle() {
		String str = title.getText();
		return str;
	}
	public void CloseBrowser() {
		ldriver.quit();
	}
	
	
}
