package MyTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features={".//Features/EmployeeInfo.feature"},
		glue = "stepsDefinations",
		dryRun = false, 
		monochrome= true,
		publish = true,
		tags = "@sanity",
		plugin = {"pretty","json:target/cucumber-report/cucumber.json",
			"html:target/cucumber-report/cucumber.html"}
		

		) 



public class MyRun {
	
	
	

}


//tags = {"@senity,@regression"}  -> Represent OR condition(Run both scenario)
//tags = {"@senity","@regression"} -> Represent And condition
