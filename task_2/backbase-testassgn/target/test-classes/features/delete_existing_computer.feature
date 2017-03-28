Feature: Delete Existing Computer
  As a user
  I want to able to delete an existing computer
  So that I can remove computer information from the list

  Background:
    Given I open computer database website
    And there is a computer with name 'MyComputerToBeDeleted'

  @P1
  Scenario: Delete existing computer
    Given I search computer with name `MyComputerToBeDeleted`
    When I delete an existing computer
    Then computer is removed from the list