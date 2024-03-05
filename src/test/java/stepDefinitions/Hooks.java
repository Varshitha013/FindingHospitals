package stepDefinitions;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import testBase.BaseClass;


public class Hooks {

	 WebDriver driver;
	 Properties prop;
     
	@Before
    public void setup() throws IOException
    {
		BaseClass baseClass = new BaseClass();
		baseClass.setup(); 
    			
	}
		
    
    @After
    public void tearDown() {
        		
    	BaseClass.getDriver().quit();
       
    }
   
}