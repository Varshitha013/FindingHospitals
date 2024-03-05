package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.ExcelUtility;

public class Surgeries extends BasePage {
	
	
	public Surgeries(WebDriver driver) {
		super(driver);
	}
	
	//elements 
	@FindBy(xpath="//div[@class='product-tab__title'][normalize-space()='Surgeries']")
	WebElement Surgeries;
		
	@FindBy(xpath = "//p[normalize-space()='Cataract']")
	WebElement cataract;
	
	@FindBy(xpath="//p[@class='mt-12px AilmentItem-module_itemText__XvCHL']")
	List<WebElement> Surgery_Names;
	
	
	// Action Methods 
	
	public void clickOnSurgeries() {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(Surgeries));
		Surgeries.click();
	}
	
	public void validateSurgeriesPage() {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(Surgeries));
		System.out.println(driver.getTitle());
		String title = driver.getTitle();
		Assert.assertEquals(title, "Practo Care Surgeries | End to end care from top surgeons in your city");
	}
	
	public void list_Of_Surgeries() throws IOException {
		int No_Of_Surgeries = Surgery_Names.size();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",cataract);
		for(int i=0;i< No_Of_Surgeries;i++) {
			
			String Surgery_name = Surgery_Names.get(i).getText();
			System.out.println(Surgery_name);
			ExcelUtility.writeData("Surgery Names", i+1, 0,Surgery_name );
			
			
		}
		System.out.println("------------------------------");
	}
	

}
