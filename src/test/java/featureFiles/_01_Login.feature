Feature: User Registration

  As a user
  I want to register on the website
  So that I can access personalized content, view special offers, and enjoy other advantages

  Background:
    Given I am on the registration page of the website

  Scenario: User can register with valid information
    When I fill in all required information correctly
    And I click the "Register" button
    Then I should see a message confirming successful registration
