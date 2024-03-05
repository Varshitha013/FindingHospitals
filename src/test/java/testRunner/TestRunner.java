package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//					features = {"Feature"},
//					features = {"Feature//Smoke.feature"},
//					features = {"Feature//Regression.feature"},
					features = {"Feature//Filters.feature"},
//					features= {"@target/rerun.txt"},
					glue="stepDefinitions",
					plugin= {"pretty", 
							 "html:reports/myreport.html", 
							 "rerun:target/rerun.txt",
							 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							
					dryRun=false,       
					publish=true  
		)
public class TestRunner {

		}
