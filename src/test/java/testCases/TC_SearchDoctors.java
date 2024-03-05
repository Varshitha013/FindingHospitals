package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.SearchDoctors;
import testBase.BaseClass;

public class TC_SearchDoctors extends BaseClass
{
	SearchDoctors Search_Doc;
	
	@Test(priority = 1)
	public void validatePractoPage() throws InterruptedException, IOException
	{
		logger.info("*** Starting TC_01_SearchDoctors ***");
		Search_Doc = new SearchDoctors(driver);
		Search_Doc.validateHomePage();
	}
	
	@Test(priority = 2)
	public void searchDoctorSpeciality() throws  IOException, InterruptedException
	{
		logger.info(" Search Doc Speciality ");
		Search_Doc.searchSpeciality();
	}
	
	@Test(priority = 3)
	public void searchLocation() throws InterruptedException, IOException
	{
		Search_Doc.clearloc();
		logger.info(" Search Location ");
		Search_Doc.searchCity();
		System.out.println("Enter Doctor Speciality");
	}
	
	@Test(priority = 4)
	public void patientStoriesFilter() throws InterruptedException 
	{
		logger.info(" Applying filter for Patient Stories ");
		Search_Doc.filterForPatientStories();
	}
	
	@Test(priority = 5)
	public void experienceFilter() throws InterruptedException 
	{
		
		logger.info(" Applying filter for Experience ");
		Search_Doc.filterForExperience();
	}
	
	@Test(priority = 6)
	public void feesandAvailabilityFilters() throws InterruptedException, IOException
	{
		Search_Doc.filterForFees();
		
		logger.info(" Applying filter for Availabilty ");
		
		Search_Doc.filterForAvailability();
		
	}
	
	@Test(priority = 7)
	public void sorting() throws InterruptedException
	{
		logger.info(" Applying Sorting ");
		
		Search_Doc.sortBy();
	}
	
	@Test(priority =8)
	public void PrintDoctorDetails() throws IOException  
	{
		logger.info(" Display Doctor Details ");
		
		Search_Doc.fetchDoctorDetails();
		
		logger.info("*** Finished TC_SearchDoctors ***");
	}

}