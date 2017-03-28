Feature: Update Existing Computer
  As a user
  I want to able to update an existing computer
  So that I can change computer information

  Background:
    Given I open computer database website
    And there is a computer with name 'MyComputerToBeUpdated'


  @P1
  Scenario: Update existing computer
    Given I search computer with name `MyComputerToBeUpdated`
    When I update existing information
    Then computer information is updated