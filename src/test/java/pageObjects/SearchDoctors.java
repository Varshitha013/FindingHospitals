package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtility;

public class SearchDoctors extends BasePage {

	// Constructor for driver
	public SearchDoctors(WebDriver driver) {
		super(driver);
	}
	
	//Elements 
	
	@FindBy(xpath="//span[@class='practo-logo']/a")
	WebElement practo_homepage_link;
	
	@FindBy(xpath = "//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
	WebElement Search_Doc;
	
	@FindBy(xpath="(//span[@class='c-omni-suggestion-item__content'])[1]")
	WebElement speciality;
	
	@FindBy(xpath = "//input[@placeholder='Search location']")
	WebElement loc;
	
	@FindBy(xpath="(//div[@class='c-omni-suggestion-item'])[1]")
	WebElement First_Loc;
	
	@FindBy(xpath = "//*[@data-qa-id='doctor_review_count_section']")
	WebElement Patient_stories;
	
	@FindBy(xpath="//li[@tabindex='0'][1]")
	WebElement First_Patient_stories;
	
	//@FindBy(xpath = "//div[@data-qa-id='years_of_experience_section']")
	@FindBy(xpath = "//div[@class='c-filter__top']//div[3]")
	WebElement experience;
	
	//@FindBy(xpath="//li[@aria-label='5+ Years of experience']")
	@FindBy(xpath="//li[@class='c-dropdown__list__item'][@tabindex='0'][1]")
	WebElement experience_years;
	
	@FindBy(xpath = "//span[@data-qa-id='all_filters']")
	WebElement all_filters;
	
	@FindBy(xpath="//label[@for='Fees1']")
	WebElement Above_500_Fee;
	
	@FindBy(xpath="//label[@for='Availability2']")
	WebElement Available_Tomorrow;
	
	@FindBy(xpath="//div[@data-qa-id='sort_by_section']")
	WebElement Sort;
	
	@FindBy(xpath="//li[@aria-label='Experience - High to Low']")
	WebElement Exp_High_to_Low;
	
	@FindBy(xpath="(//div[@class='reach-v2-card u-border-general--top'])[1]")
	WebElement Scroll;
	
	@FindBy(xpath="//div[@class='u-border-general--bottom']")
	List<WebElement> Doctor_Details;
	
	
	@FindBy(xpath="//div[@class='info-section']/a")
	List<WebElement> doctor_names; 
	
//Action Methods
	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public void practoHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable((practo_homepage_link)));
		practo_homepage_link.click();

	}
	
	public String validateHomePage() {
		return driver.getTitle();
	}
	
	public void searchSpeciality() throws IOException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable((Search_Doc)));
		Search_Doc.sendKeys(ExcelUtility.readExcelData("Fields", 0, 1));
		Thread.sleep(3000);
		speciality.click();
	}
	
	public void clearloc() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable((loc)));
		loc.clear();
		Thread.sleep(4000);
	}
	public void searchCity() throws  IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(loc));
		loc.sendKeys(ExcelUtility.readExcelData("Fields", 1, 1));
		Thread.sleep(5000);
		First_Loc.click();
	}
	
	public void filterForPatientStories() throws InterruptedException 
	{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(Patient_stories));
		js.executeScript("arguments[0].click();", Patient_stories);
		//To select first patient Story
		First_Patient_stories.click();
		
	}
	
	public void filterForExperience() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf( experience));
		Thread.sleep(3000);
		experience.click();
		//To select 5+ Years of experience.
		experience_years.click();
		Thread.sleep(2000);
	}
	
	public void filterForFees() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf( all_filters));
		// To Click On All Filters
		all_filters.click();
		//To select Above ₹500 Fees
		js.executeScript("arguments[0].click();", Above_500_Fee);
		Thread.sleep(2000);
		
	}
	
	public void filterForAvailability() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf( all_filters));
		// To Click On All Filters
		all_filters.click();
		//To select Available Tomorrow button
		js.executeScript("arguments[0].click();", Available_Tomorrow);
		
		Thread.sleep(5000);
	}
	
	public void sortBy() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(Sort));
		// To Click On Sort By
		Sort.click();
		//To select Experience - High to Low
		js.executeScript("arguments[0].click();", Exp_High_to_Low);
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView()",Scroll);
	}
	
	public void fetchDoctorDetails() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(Doctor_Details));
		for(int i = 0;i<5;i++) {
			String data =  Doctor_Details.get(i).getText();
			System.out.println(data);
			System.out.println("------------------------------------");
			ExcelUtility.writeData("Doctor_Details", i+1, 0, data);
		}
		
	}
	public void listOfDermatologists() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(Doctor_Details));
		System.out.println("Total doctors available : " + doctor_names.size());
		for (WebElement doc : doctor_names) {
			System.out.println(doc.getText());
		}
	}

	public void emptyDoctor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(Search_Doc));
		Search_Doc.click();
		Actions act = new Actions(driver);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}

	public void emptyDoctorDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(Search_Doc));
		System.out.println("Invalid value taken automatically" + Search_Doc.getAttribute("value"));
		
	}

}
