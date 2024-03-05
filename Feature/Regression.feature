Feature: Regression sutie for finding hospitals

  @regression
  Scenario: Applying patient stories filter for the doctors
    Given the User Navigates to Practo Page
    When user enters speciality in speciality bar of practo home page
    And user clear the location field in practo home page
    And user enters loc in location field of practo home page
    And user select filter in the patient stories field for dermatologists
    Then user should see a list of dermatologists in bangalore location of relevant filter

  @regression
  Scenario: Applying experience filter for the doctors
    Given the User Navigates to Practo Page
    When user enters speciality in speciality bar of practo home page
    And user clear the location field in practo home page
    And user enters loc in location field of practo home page
    And user select filter in the experience field for dermatologists
    Then user should see a list of dermatologists in bangalore location of relevant filter

  @regression
  Scenario: Applying availability filter for the doctors
    Given the User Navigates to Practo Page
    When user enters speciality in speciality bar of practo home page
    And user clear the location field in practo home page
    And user enters loc in location field of practo home page
    And user select filter in the availability field for dermatologists
    Then user should see a list of dermatologists in bangalore location of relevant filter

  @regression
  Scenario: Applying fee filter for the doctors
    Given the User Navigates to Practo Page
    When user enters speciality in speciality bar of practo home page
    And user clear the location field in practo home page
    And user enters loc in location field of practo home page
    And user select filter in the fees field for dermatologists
    Then user should see a list of dermatologists in bangalore location of relevant filter

  @regression
  Scenario: Applying sort by filter for the doctors
    Given the User Navigates to Practo Page
    When user enters speciality in speciality bar of practo home page
    And user clear the location field in practo home page
    And user enters loc in location field of practo home page
    And user select filter in the sort by field for dermatologists
    Then user should see a list of dermatologists in bangalore location of relevant filter

  @regression
  Scenario: navigate to surgeries page in practo website
    Given user navigates to practo home page
    When user clicks on surgeries in the practo home page navigation bar
    Then user validates the surgeries page

  @regression
  Scenario: Corporate Health and Wellness Form Validation with valid details
    Given user navigates to the practo page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates to health and wellness plans page and validate the page
    When user enters valid details and clicks on schedule a demo button
    Then user validates the thank you message and print in console

  @regression
  Scenario: Corporate Health and Wellness Form Validation without providing name
    Given user navigates to the practo page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates to health and wellness plans page and validate the page
    When user leaves name field empty and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation without providing organization name
    Given user navigates to the practo page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates to health and wellness plans page and validate the page
    When user leaves organization name field empty and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation without providing contact number
    Given user navigates to the practo page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates to health and wellness plans page and validate the page
    When user leaves contact number field empty and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation without providing email
    Given user navigates to the practo page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates to health and wellness plans page and validate the page
    When user leaves official email field empty and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation with invalid email
    Given user navigates to the practo page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates to health and wellness plans page and validate the page
    When user provide invalid email id and valid details for other fields in the form
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation without selecting organization size dropdown
    Given user navigates to the practo page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates to health and wellness plans page and validate the page
    When user does not select any option from oraganization size dropdown and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation without selecting interested dropdown
    Given user navigates to the practo page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates to health and wellness plans page and validate the page
    When user does not select any option from interested in dropdown and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page
