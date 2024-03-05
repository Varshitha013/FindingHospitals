package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.ScheduleDemoForm;
import testBase.BaseClass;

public class TC_ScheduleDemoForm extends BaseClass{
	
	ScheduleDemoForm sdf;
	
	@Test(priority=1)
	public void ForCorporatesDrpDown() {
		logger.info("*** Starting TC_ScheduleDemoForm ***");
		sdf= new ScheduleDemoForm(driver);
		sdf.clickOnForCorporates();
	}
	
	@Test(priority=2)
	public void selectHealthandWellnessPlans() {
		sdf.selectHealthandWellnessPlans();
	}
	
	@Test(priority=3)
	public void validatePage() {
		logger.info("Schedule Demo page is Displayed");
		sdf.validateScheduleDemoPage();
	}
	
	@Test(priority=4)
	public void inValidDetails() throws IOException, InterruptedException {
		logger.info("InValid Email Id");
		sdf.inValidEmailId();
		
	}

	@Test(priority=5)
	public void validateScheduleButtonEnabled() {
		logger.info("Is Schedule Button Enabled? ");
		sdf.scheduleBtn();
	}
	
	@Test(priority=6)
	public void printErrorMessage() {
		logger.info("Error Message");
		sdf.errormsg();
	}
	
	@Test(priority=7)
	public void clearEmailId() throws IOException, InterruptedException {
		logger.info("Clear InValid Email Id");
		sdf.clearInValidEmailId();
	}
	
	@Test(priority=8)
	public void validEmailId() throws InterruptedException, IOException {
		logger.info("Valid Email Id");
		sdf.ValidEmailId();
	}
	
	@Test(priority=9)
	public void clickScheduleButtonEnabled() {
		sdf.scheduleBtn();
	}
	
	@Test(priority=10)
	public void validateThankYouMessage() {
		logger.info("Thank you message is displayed");
		sdf.thankYou();
		logger.info("*** Finished TC_ScheduleDemoForm ***");
	}

}