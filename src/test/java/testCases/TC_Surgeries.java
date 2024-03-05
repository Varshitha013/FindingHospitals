package testCases;


import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.Surgeries;
import testBase.BaseClass;


public class TC_Surgeries extends BaseClass {
	
	Surgeries Surgery1;
	
	
	@Test(priority = 1,groups = {"Surgery","master","Regression"})
	public void displaySurgeries() throws InterruptedException, IOException {
		logger.info("*** Starting TC_Surgeries ***");
		Surgery1 = new Surgeries(driver);
		Thread.sleep(10000);
		
		logger.info(" Clicked on Surgeries ");

		Surgery1.clickOnSurgeries();
		Thread.sleep(5000); 
	}
	
	@Test(priority = 2,groups = {"Surgery"})
	public void validatepage() {
		logger.info(" Validate  Surgeries Page ");
		Surgery1.validateSurgeriesPage();
	}
	
	@Test(priority = 3,groups = {"Regression","master"})
	public void printsurgery() throws IOException {
		logger.info(" Print Surgery Names ");
		Surgery1.list_Of_Surgeries();
		logger.info("*** Finished TC_Surgeries ***");
	}
}