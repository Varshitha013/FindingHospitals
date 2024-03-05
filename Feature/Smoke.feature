Feature: Smoke sutie for finding hospitals

  @smoke
  Scenario: empty search in Bangalore location in doctors specification page of practo website
    Given the User Navigates to Practo Page
    When user clear the location field in practo home page
    And user enters loc in location field of practo home page
    When user search without providing any value in the search bar in doctors speciality page
    Then user should not see invalid results


  @smoke
  Scenario: search for dermatologists in bangalore location in practo website
    Given the User Navigates to Practo Page
    When user clear the location field in practo home page
    And user enters loc in location field of practo home page
    And user enters speciality in speciality bar of practo home page
    Then user should see a list of dermatologists in bangalore location of relevant filter

  @smoke
  Scenario: Surgeries Page Navigation in practo website
    Given user navigates to practo home page
    When user clicks on surgeries in the practo home page navigation bar
    Then user validates the surgeries page

  @smoke
  Scenario: store and print popular surgeries listed in surgeries Page
    Given user navigates to practo home page
    When user clicks on surgeries in the practo home page navigation bar
    Then user stores the list of popular surgeries and print them

  @smoke
  Scenario: Corporate Health and Wellness Form Validation with invalid email
    Given user navigates to the practo page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates to health and wellness plans page and validate the page
    When user provide invalid email id and valid details for other fields in the form
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @smoke
  Scenario: Corporate Health and Wellness Form Validation with valid details
    Given user navigates to the practo page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates to health and wellness plans page and validate the page
    When user enters valid details and clicks on schedule a demo button
    Then user validates the thank you message and print in console
