package testBase;
 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
 
import org.apache.logging.log4j.LogManager;			//log4j
import org.apache.logging.log4j.Logger;				//log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
 
public class BaseClass {
	static public WebDriver driver;
	public Logger logger;
	public Properties p;

		@BeforeClass
		public void setup() throws IOException {
			logger=LogManager.getLogger(this.getClass());		//Loading log4j2 File


			if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		 	{	
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(getProperties().getProperty("os").equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(p.getProperty("os").equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
			//browser
			switch(getProperties().getProperty("browser").toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		    }
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(getProperties().getProperty("browser").toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); logger.info("Chrome browser opened successfully"); break;
			case "edge": driver=new EdgeDriver(); logger.info("Chrome browser opened successfully"); break;
			default: System.out.println("No matching browser.."); logger.info("no matching browser......");
						return;
			}
		}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			driver.get(getProperties().getProperty("appURL"));
			driver.manage().window().maximize();
		}
		public Properties getProperties() {
			try {
	    		//creating a FileReader object to read config file
	    		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");      //path of config.properties file
	    		p=new Properties();			  //Creating an object for Properties
	    		p.load(file);				  //Loading the properties from configuration file
	    	}
	    	catch(Exception e) {
			    //catch the exception that occur during file reading and loading properties
	    	}
	    	return p;
		}

		public static WebDriver getDriver() {
					return driver;
		}
 
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
				
 
		public String captureScreen(String tname) {
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			sourceFile.renameTo(targetFile);
			return targetFilePath;
		}		
}