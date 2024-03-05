Feature: Finding hospitals

  Scenario: Display First 5 Dermatologist Doctor Details
    Given the User Navigates to Practo Page
    Then user validates the practo home page title
    When user enters speciality in speciality bar of practo home page
    And user clear the location field in practo home page
    And user enters loc in location field of practo home page
    And user select filter in the patient stories field for dermatologists
    And user select filter in the experience field for dermatologists
    And user select filter in the availability field for dermatologists
    And user select filter in the fees field for dermatologists
    And user select filter in the sort by field for dermatologists
    Then user stores the top five doctors in a list and print their details

  Scenario: Display Popular Surgeries in Surgeries page
    Given user navigates to practo home page
    When user clicks on surgeries in the practo home page navigation bar
    Then user validates the surgeries page
    And user stores the list of popular surgeries and print them

  Scenario: Schedule a demo in health and wellness plans for corporates
    Given user navigates to the practo page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates to health and wellness plans page and validate the page
    When user provide invalid email id and valid details for other fields in the form
    Then user validates schedule a demo button is enabled in the health and wellness plans page
    When user clears email field
    When user enters valid email id and clicks on schedule a demo button
    Then user validates the thank you message and print in console
