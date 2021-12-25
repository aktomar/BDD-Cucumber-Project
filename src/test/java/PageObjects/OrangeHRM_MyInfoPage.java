package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM_MyInfoPage {
	
	WebDriver ldriver;
	
	public OrangeHRM_MyInfoPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	//WebPages elements.... 
	
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
	
	@FindBy(xpath="//*[text()='My Info']")
	@CacheLookup
	WebElement ClickMyInfotab;
	
	@FindBy(id="btnSave")
	@CacheLookup
	WebElement Clickedit;
	
	@FindBy(id="personal_txtEmpFirstName")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(id="personal_txtEmpLastName")
	@CacheLookup
	WebElement lastname;
	
	@FindBy(id="personal_txtEmployeeId")
	@CacheLookup
	WebElement EmpId;
	
	@FindBy(id="personal_optGender_1")
	@CacheLookup
	WebElement gender;
	
	@FindBy(id="personal_cmbMarital")
	@CacheLookup
	WebElement maritalStatus;
	
	@FindBy(id="personal_cmbNation")
	@CacheLookup
	WebElement nationality;
	
	@FindBy(id="btnSave")
	@CacheLookup
	WebElement SaveDetails;
	
	
	//Implementing methods 
	
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
	public void ClickOnMyInfoTab() {
		ClickMyInfotab.click();
	}
	public void ClickOnEditButton() {
		Clickedit.click();
	}
	public void EnterFirstname(String fname) {
		firstname.clear();
		firstname.sendKeys(fname);
	}
	public void EnterLastname(String lname) {
		lastname.clear();
		lastname.sendKeys(lname);
		
	}
	public void EnterEmployeeID() {
		EmpId.clear();
		EmpId.sendKeys("0012");
	}
	public void SelectGender() {
		gender.click();
		
	}
	public void SelectNationality() {
		Select nt =new Select(nationality);
		nt.selectByVisibleText("Indian");
		
	}
	public void ClickOnSaveButton() {
		SaveDetails.click();
	}
	
	public void CloseBrowser() {
		ldriver.quit();
	}

}
