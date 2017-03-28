Feature: Can't Find Any Computers
  As a user
  I want to display 0 results
  So that I can see the information message when there isn't any match

  Background:
    Given I open computer database website

  @P2
  Scenario: Can't find any computers
    Given I search non-existent computer
    When there is not any search results
    Then information message is displayed