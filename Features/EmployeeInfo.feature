Feature: Registor Employee 

	
Background: Below are comman steps used in all scenario
	Given Launch Browser and Open OrangeHRM Application
	When Enter Uname "Admin" and Paswrd "admin123" 
	Then Click on application Login Button 
	And Navigate to Home PageUI

@sanity
Scenario: Add new Employee details
	Then click on MyInfo tab and navigate to employee details UI
	And Click on Edit button 
	And Enter the employee details 
	Then click on save button
	And close browser
		

Scenario: Search Added Employee	
	When Click on PIM tab
	And Click on Employee tab
	And Search employee details by passing name
	Then click on search button
	And close browser