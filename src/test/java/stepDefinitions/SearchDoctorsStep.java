package stepDefinitions;

import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchDoctors;
import testBase.BaseClass;

public class SearchDoctorsStep {
	
	SearchDoctors sd = new SearchDoctors(BaseClass.getDriver());

	@Given("the User Navigates to Practo Page")
	public void the_user_navigates_to_practo_page() {
    
		sd.practoHomePage();
		
	}

	@Then("user validates the practo home page title")
	public void user_validates_the_practo_home_page_title() {
    
		sd.validateHomePage();
		
	}

	@When("user enters speciality in speciality bar of practo home page")
	public void user_enters_speciality_in_speciality_bar_of_practo_home_page() throws InterruptedException, IOException {
		sd.searchSpeciality();
		
	}
	

	@When("user clear the location field in practo home page")
	public void user_clear_the_location_field_in_practo_home_page() throws InterruptedException {
		sd.clearloc();
		
	}

	@When("user enters loc in location field of practo home page")
	public void user_enters_loc_in_location_field_of_practo_home_page() throws InterruptedException, IOException {
		sd.searchCity();
		
	}
	
	@When("user search without providing any value in the search bar in doctors speciality page")
	public void user_search_without_providing_any_value_in_the_search_bar_in_doctors_speciality_page(){
		sd.emptyDoctor();
	}
	
	@Then("user should not see invalid results")
	public void user_should_not_see_invalid_results() {
		sd.emptyDoctorDetails();
	}

	@When("user select filter in the patient stories field for dermatologists")
	public void user_select_filter_in_the_patient_stories_field_for_dermatologists() throws InterruptedException {
		sd.filterForPatientStories();
		
	}

	@When("user select filter in the experience field for dermatologists")
	public void user_select_filter_in_the_experience_field_for_dermatologists() throws InterruptedException {
		sd.filterForExperience();
		
		
	}

	@When("user select filter in the availability field for dermatologists")
	public void user_select_filter_in_the_availability_field_for_dermatologists() throws InterruptedException {
		sd.filterForAvailability();
		
	}

	@When("user select filter in the fees field for dermatologists")
	public void user_select_filter_in_the_fees_field_for_dermatologists() throws InterruptedException {
		sd.filterForFees();
		
	}

	@When("user select filter in the sort by field for dermatologists")
	public void user_select_filter_in_the_sort_by_field_for_dermatologists() throws InterruptedException {
		sd.sortBy();
		
	}
	

	@Then("user stores the top five doctors in a list and print their details")
	public void user_stores_the_top_five_doctors_in_a_list_and_print_their_details() throws IOException {
		sd.fetchDoctorDetails();
		
	}
	
	@Then("user should see a list of dermatologists in bangalore location of relevant filter")
	public void user_should_see_a_list_of_dermatologists_in_bangalore_location_of_relevant_filter() {
		sd.listOfDermatologists();
	}

	
}