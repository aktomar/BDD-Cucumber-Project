package PageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uitilities.WaitHelper;



public class OrangeHRM_SearchEmployePage {
	
	
	WebDriver ldriver;
	WaitHelper waithelper;
	WebElement name;
	
	public OrangeHRM_SearchEmployePage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		waithelper = new WaitHelper(ldriver);
	}
	
	@FindBy(xpath="//*[text()='PIM']")
	@CacheLookup
	WebElement PIMTab;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	@CacheLookup
	WebElement EmpList;
	
	@FindBy(id="empsearch_employee_name_empName")
	@CacheLookup
	WebElement PassEmpName;
	
	@FindBy(id="searchBtn")
	@CacheLookup
	WebElement ClickSearch;
	
	@FindBy(id="resultTable")
	@CacheLookup
	WebElement table;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/thead/tr")
	@CacheLookup
	List<WebElement> GetRows;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr/td")
	@CacheLookup
	List<WebElement> GetColumns;
	
	
	//Implementing methods.......
	
	public void HoverToPIMtab() {
		PIMTab.click();
		
	}
	
	public void ClickOnEmployeeList() {
		waithelper.WaitForElement(EmpList, 20);
		EmpList.click();
	}
	
	public void EnterEmployeeNameToSearch(String name) {
		waithelper.WaitForElement(PassEmpName, 30);
		PassEmpName.clear();
		PassEmpName.sendKeys(name);
		
	}
	
	public void ClickOnSearchButton() {

		waithelper.WaitForElement(ClickSearch, 30);
		ClickSearch.click();
	}
	
	
 public int getRows() {
		return (GetRows.size());
	}
	
	public int getColumns() {
		return (GetColumns.size());
	}
	
	public boolean SearchByEmployeeName(String name) {
		
		boolean flag=false;
		
		for(int i=1;i<=getRows();i++) {
			
			String PassEmpName = table.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+i+"]/td[3]")).getText();
		
		if(PassEmpName.equals(name)) {
			flag=true;
		       }
		}
		return flag;
	}
	
	
	

}
