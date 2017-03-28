Feature: Add New Computer
  As a user
  I want to add a new computer to the computer database
  So that I can register new computer

  Background:
    Given I open computer database website

  @P1
  Scenario: Add a new computer
    When I click to add a new computer
    And I enter valid computer information
    And I click create this computer
    Then the computer is registered

  @P2
  Scenario Outline: Add an invalid computer
    When I click to add a new computer
    And I enter valid computer name
    And '<introduced>' and '<discontinued>' as introduced and discontinued dates
    And I click create this computer
    Then I got error for date fields
    Examples:
      | introduced | discontinued |
      | 1990-13-01 | 1991-13-01   |
      | 1990-12-32 | 1991-12-32   |
      | 1990/01/01 | 1991/01/01   |
      | 05-07-1990 | 05-07-1991   |
      | 07-25-1990 | 07-25-1991   |
      | 5th March 1990 | 5th March 1990 |
      | AAA | AAA   |
      | 123 | 123   |


