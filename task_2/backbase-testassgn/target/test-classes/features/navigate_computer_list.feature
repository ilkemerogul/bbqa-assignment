Feature: Navigating Through The Computer List (Next)
  As a user
  I want to navigate through the computer list
  So that I can view the computers in the next page

  @P1
  Scenario: Navigate to the next page
    Given I open computer database website
    When I click on the next button at the bottom of the page
    Then next page should be displayed