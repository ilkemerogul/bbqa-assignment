Feature: Navigating Through The Computer List (Previous)
  As a user
  I want to navigate through the computer list
  So that I can view the computers in the previous page

  Background:
    Given I open computer database website
    And I click on the next button at the bottom of the page

  @P1
  Scenario: Navigate to the previous page
    Given I locate previous button at the bottom of the page
    When I click on the previous button
    Then previous page should be displayed