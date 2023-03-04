@RegressionAll
Feature: Contact Us Regression tests
  As Customer, I can navigate to contact us page and submit my data.

  Background: Home page of Jupitor toys Shopping website
    Given User launches Jupitor toys shopping website

  Scenario Outline: validate error messages on contact us/Feedback page
    And User navigates from Home page to Contact Page
    When User clicks submit button on contact form
    Then Validate error messages for mandatory fields
    When User populate mandatory fields forename as "<forename>" and email as "<email>" and message as "<message>"
    Then Validate mandatory error messages are not visible to the user

    Examples: 
      | forename    | email                | message                           |
      | Steve Smith | stevesmith@gmail.com | My son loves to play Jupitor toys |

  Scenario Outline: submit contact form data and validate successful message
    And User navigates from Home page to Contact Page
    When User populate mandatory fields forename as "<forename>" and email as "<email>" and message as "<message>"
    And User clicks submit button on contact form
    Then Validate successful feedback message for user "<forename>"

    Examples: 
      | forename    | email                | message                           |
      | Steve Smith | stevesmith@gmail.com | My son loves to play Jupitor toys |
      | Eric Smith  | ericsmith@gmail.com  | My son loves to play Jupitor toys |
      | Will Smith  | willsmith@gmail.com  | My son loves to play Jupitor toys |
      | John Smith  | johnsmith@gmail.com  | My son loves to play Jupitor toys |
      | Green Smith | greensmith@gmail.com | My son loves to play Jupitor toys |
