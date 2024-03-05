package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchDoctors;
import pageObjects.Surgeries;
import testBase.BaseClass;

public class SurgeriesStep {
	
	Surgeries surgery = new Surgeries(BaseClass.getDriver());
	SearchDoctors sd = new SearchDoctors(BaseClass.getDriver());
	
	@Given("user navigates to practo home page")
	public void user_navigates_to_practo_home_page() {
	    sd.validateHomePage();
	}

	@When("user clicks on surgeries in the practo home page navigation bar")
	public void user_clicks_on_surgeries_in_the_practo_home_page_navigation_bar() {
	    surgery.clickOnSurgeries();
	}

	@Then("user validates the surgeries page")
	public void user_validates_the_surgeries_page() {
	    surgery.validateSurgeriesPage();
	}

	@Then("user stores the list of popular surgeries and print them")
	public void user_stores_the_list_of_popular_surgeries_and_print_them() throws IOException {
	    surgery.list_Of_Surgeries();
	}

	
}
