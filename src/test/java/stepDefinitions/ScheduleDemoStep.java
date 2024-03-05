package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ScheduleDemoForm;
import pageObjects.SearchDoctors;
import testBase.BaseClass;

public class ScheduleDemoStep {

	ScheduleDemoForm sdf = new ScheduleDemoForm(BaseClass.getDriver());
	SearchDoctors  sd = new SearchDoctors(BaseClass.getDriver());
	



	@Given("user navigates to the practo page")
	public void user_navigates_to_the_practo_page() {
		 sd.validateHomePage();
	    
	}
	
	@When("user clicks on for corporates dropdown in practo home page navigation bar")
	public void user_clicks_on_for_corporates_dropdown_in_practo_home_page_navigation_bar() {
		sdf.clickOnForCorporates();
	}

	@When("user selects health and wellness plans in for corporates dropdown")
	public void user_selects_health_and_wellness_plans_in_for_corporates_dropdown() {
	    sdf.selectHealthandWellnessPlans();
	}

	@Then("user navigates to health and wellness plans page and validate the page")
	public void user_navigates_to_health_and_wellness_plans_page_and_validate_the_page() {
	    sdf.validateScheduleDemoPage();
	}

	@When("user provide invalid email id and valid details for other fields in the form")
	public void user_provide_invalid_email_id_and_valid_details_for_other_fields_in_the_form() throws IOException, InterruptedException {
	    sdf.inValidEmailId();
	}

	@Then("user validates schedule a demo button is enabled in the health and wellness plans page")
	public void user_validates_schedule_a_demo_button_is_enabled_in_the_health_and_wellness_plans_page() {
	    sdf.scheduleBtn();
	    sdf.errormsg();
	}

	@When("user clears email field")
	public void user_clears_email_field() throws IOException, InterruptedException {
		sdf.clearInValidEmailId();
	}
	
	@When("user enters valid email id and clicks on schedule a demo button")
	public void user_enters_valid_email_id_and_clicks_on_schedule_a_demo_button() throws IOException, InterruptedException {
		sdf.ValidEmailId();
		sdf.scheduleBtn();
	}
	
	@When("user enters valid details and clicks on schedule a demo button")
	public void user_enters_valid_details_and_clicks_on_schedule_a_demo_button() throws IOException, InterruptedException {
		sdf.ValidDetails();
		sdf.scheduleBtn();
	}
	
	@When("user leaves name field empty and fill all other fields")
	public void user_leaves_name_field_empty_and_fill_all_other_fields() throws IOException, InterruptedException {
		sdf.emptyName();
	}
	
	@When("user leaves organization name field empty and fill all other fields")
	public void user_leaves_organization_name_field_empty_and_fill_all_other_fields() throws IOException {
		sdf.emptyOrganization();
	}
	
	@When("user leaves contact number field empty and fill all other fields")
	public void user_leaves_contact_number_field_empty_and_fill_all_other_fields() throws IOException {
		sdf.emptyContactNumber();
	}
		
	@When("user leaves official email field empty and fill all other fields")
	public void user_leaves_official_email_field_empty_and_fill_all_other_fields() throws IOException {
		sdf.emptyEmail();
	}
	
	@When("user does not select any option from oraganization size dropdown and fill all other fields")
	public void user_does_not_select_any_option_from_oraganization_size_dropdown_and_fill_all_other_fields() throws IOException {
		sdf.emptyOrgSize();
	}

	@When("user does not select any option from interested in dropdown and fill all other fields")
	public void user_does_not_select_any_option_from_interested_in_dropdown_and_fill_all_other_fields() throws IOException {
		sdf.emptyInterestedIn();
	}
	
	@Then("user validates the thank you message and print in console")
	public void user_validates_the_thank_you_message_and_print_in_console() {
	    sdf.thankYou();
	}
	

}

