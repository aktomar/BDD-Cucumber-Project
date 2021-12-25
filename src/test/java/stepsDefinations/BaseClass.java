package stepsDefinations;

import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import PageObjects.OrangeHRM_LoginPage;
import PageObjects.OrangeHRM_MyInfoPage;
import PageObjects.OrangeHRM_SearchEmployePage;


public class BaseClass {
	
	
	public WebDriver driver;
	public OrangeHRM_LoginPage lp ;
	public OrangeHRM_MyInfoPage ip;
	public OrangeHRM_SearchEmployePage se;
	public static Logger logger;
	public Properties configprop;

}
