package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.ExcelUtility;

public class ScheduleDemoForm extends BasePage {
	
	public ScheduleDemoForm(WebDriver driver) {
		super(driver);
	}
	
	//Elements 
	@FindBy(xpath = "//span[normalize-space()='For Corporates']")
	WebElement For_Corporates;
	
	@FindBy(xpath = "//a[normalize-space()='Health & Wellness Plans']")
	WebElement Health_and_Wellness_Plans ;
	
	
	@FindBy(xpath = "(//h2[@class='u-m-b--20 text-beta'])[1]")
	WebElement schedule_a_demo_title ;
	
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement Name ;
	
	@FindBy(xpath = "//input[@id='organizationName']")
	WebElement Organization_Name ;
	
	@FindBy(xpath = "//input[@id='contactNumber']")
	WebElement Contact_Number ;
	
	@FindBy(xpath = "//input[@id='officialEmailId']")
	WebElement Official_Email_Id ;

	@FindBy(xpath = "//select[@id='organizationSize']")
	WebElement Organization_Size ;
	
	@FindBy(xpath = "//select[@id='interestedIn']")
	WebElement Interested_In ;
	
	//header[contains(@class,'c-header-mobile u-position--relative dweb-hide')]//button[contains(@type,'submit')][normalize-space()='Schedule a demo']
	@FindBy(xpath="//button[contains(@type,'submit')][normalize-space()='Schedule a demo']")
	WebElement Schedule_a_demo;
	
	@FindBy(xpath="(//div[@class='u-text--bold text-alpha'][normalize-space()='THANK YOU'])")
	WebElement Thank_You;
	
	
	public void clickOnForCorporates()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(For_Corporates));
		For_Corporates.click();
	}
	
	public void selectHealthandWellnessPlans()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(Health_and_Wellness_Plans));
		Health_and_Wellness_Plans.click();
	}
	
	public void validateScheduleDemoPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(schedule_a_demo_title));
		String title = schedule_a_demo_title.getText();
		Assert.assertEquals(title, "Schedule a Demo");
		System.out.println(title);
	}
	
	public void inValidEmailId() throws IOException, InterruptedException 
	{
		Name.sendKeys(ExcelUtility.readExcelData("Form Details", 1, 0));
		Organization_Name.sendKeys(ExcelUtility.readExcelData("Form Details", 1, 1));
		Contact_Number.sendKeys(ExcelUtility.readExcelData("Form Details", 1, 2));
		Official_Email_Id.sendKeys(ExcelUtility.readExcelData("Form Details", 1, 3));
		Select orgSize = new Select(Organization_Size);
		orgSize.selectByValue(ExcelUtility.readExcelData("Form Details", 1, 4));
		Select interestIn = new Select(Interested_In);
		interestIn.selectByValue(ExcelUtility.readExcelData("Form Details", 1, 5));
		Thread.sleep(3000);

	}
	
	public void clearInValidEmailId() throws IOException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(schedule_a_demo_title));
		Official_Email_Id.clear();
		//Thread.sleep(3000);

	}
	
	public void emptyName() throws IOException 
	{
		Organization_Name.sendKeys(ExcelUtility.readExcelData("Form Details", 2, 1));
		Contact_Number.sendKeys(ExcelUtility.readExcelData("Form Details", 2, 2));
		Official_Email_Id.sendKeys(ExcelUtility.readExcelData("Form Details", 1, 6));
		Select orgSize = new Select(Organization_Size);
		orgSize.selectByValue(ExcelUtility.readExcelData("Form Details", 2, 4));
		Select interestIn = new Select(Interested_In);
		interestIn.selectByValue(ExcelUtility.readExcelData("Form Details", 2, 5));

	}

	public void ValidEmailId() throws InterruptedException, IOException
	{
		
		Official_Email_Id.sendKeys(ExcelUtility.readExcelData("Form Details", 1, 6));
	
		//Thread.sleep(3000);

	}
	public void ValidDetails() throws IOException, InterruptedException 
	{
		Name.sendKeys(ExcelUtility.readExcelData("Form Details", 1, 0));
		Organization_Name.sendKeys(ExcelUtility.readExcelData("Form Details", 1, 1));
		Contact_Number.sendKeys(ExcelUtility.readExcelData("Form Details", 1, 2));
		Official_Email_Id.sendKeys(ExcelUtility.readExcelData("Form Details", 1, 6));
		Select orgSize = new Select(Organization_Size);
		orgSize.selectByValue(ExcelUtility.readExcelData("Form Details", 1, 4));
		Select interestIn = new Select(Interested_In);
		interestIn.selectByValue(ExcelUtility.readExcelData("Form Details", 1, 5));
		Thread.sleep(3000);

	}
	public void emptyOrganization() throws IOException 
	{
		Name.sendKeys(ExcelUtility.readExcelData("Form Details", 3, 0));
		Contact_Number.sendKeys(ExcelUtility.readExcelData("Form Details", 3, 2));
		Official_Email_Id.sendKeys(ExcelUtility.readExcelData("Form Details", 3, 6));
		Select orgSize = new Select(Organization_Size);
		orgSize.selectByValue(ExcelUtility.readExcelData("Form Details", 3, 4));
		Select interestIn = new Select(Interested_In);
		interestIn.selectByValue(ExcelUtility.readExcelData("Form Details", 3, 5));
		
	}

	public void emptyContactNumber() throws IOException 
	{
		Name.sendKeys(ExcelUtility.readExcelData("Form Details", 4, 0));
		Organization_Name.sendKeys(ExcelUtility.readExcelData("Form Details", 4, 1));
		Official_Email_Id.sendKeys(ExcelUtility.readExcelData("Form Details", 4, 6));
		Select orgSize = new Select(Organization_Size);
		orgSize.selectByValue(ExcelUtility.readExcelData("Form Details", 4, 4));
		Select interestIn = new Select(Interested_In);
		interestIn.selectByValue(ExcelUtility.readExcelData("Form Details", 4, 5));
		
	}
	public void emptyEmail() throws IOException 
	{
		Name.sendKeys(ExcelUtility.readExcelData("Form Details", 5, 0));
		Organization_Name.sendKeys(ExcelUtility.readExcelData("Form Details", 5, 1));
		Contact_Number.sendKeys(ExcelUtility.readExcelData("Form Details", 5, 2));
		Select orgSize = new Select(Organization_Size);
		orgSize.selectByValue(ExcelUtility.readExcelData("Form Details", 5, 4));
		Select interestIn = new Select(Interested_In);
		interestIn.selectByValue(ExcelUtility.readExcelData("Form Details", 5, 5));
	}
	
	public void emptyOrgSize() throws IOException 
	{
		Name.sendKeys(ExcelUtility.readExcelData("Form Details", 6, 0));
		Organization_Name.sendKeys(ExcelUtility.readExcelData("Form Details", 6, 1));
		Contact_Number.sendKeys(ExcelUtility.readExcelData("Form Details", 6, 2));
		Official_Email_Id.sendKeys(ExcelUtility.readExcelData("Form Details", 6, 6));
		Select interestIn = new Select(Interested_In);
		interestIn.selectByValue(ExcelUtility.readExcelData("Form Details", 6, 5));

	}
	public void emptyInterestedIn() throws IOException 
	{
		Name.sendKeys(ExcelUtility.readExcelData("Form Details", 7, 0));
		Organization_Name.sendKeys(ExcelUtility.readExcelData("Form Details", 7, 1));
		Contact_Number.sendKeys(ExcelUtility.readExcelData("Form Details", 7, 2));
		Official_Email_Id.sendKeys(ExcelUtility.readExcelData("Form Details", 7, 6));
		Select orgSize = new Select(Organization_Size);
		orgSize.selectByValue(ExcelUtility.readExcelData("Form Details", 7, 4));

	}
	public void scheduleBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(schedule_a_demo_title));
		if (Schedule_a_demo.isEnabled()) {
			Schedule_a_demo.click();
		} else {
			System.out.println("Cannot schedule a demo, please Enter valid details!");
		}
	}
	
	
	
	public void errormsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(schedule_a_demo_title));
		List<WebElement> form = driver.findElements(By.xpath("//div[@class='corporate-form']//div//input"));
		for (int i = 0; i < 6; i++) {
			String color = form.get(i).getCssValue("color");
			if (color.equals("rgba(159, 58, 56, 1)")) {
				System.out.println(
						"invalid " + form.get(i).getAttribute("placeholder") + ", please provide valid details");
			}
		}
	}
	public void thankYou()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(Thank_You));
		System.out.println(Thank_You.getText());
		Assert.assertEquals(Thank_You.getText(), "THANK YOU");
		//return Thank_You.getText();
	}
}
