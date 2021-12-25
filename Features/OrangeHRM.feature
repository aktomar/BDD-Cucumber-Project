Feature: Verify OrangeHRM Application

	Scenario: Test LoginPage Functionality
		Given Launch Browser and Open Application
		When Enter Username "Admin" and Password "admin123" 
		Then Click on Login Button
		And Navigate to Home Page
		Then close the browser
		
   
   Scenario Outline: Test LoginPage Functionality with DDT
   		Given Launch Browser and Open Application
		When Enter Username "<username>" and Password "<password>"
		Then Click on Login Button
		And Navigate to Home Page
		Then close the browser
		
	Examples:
		|username| password |
		|Admin | admin123 |
		|Admin | admin321 |