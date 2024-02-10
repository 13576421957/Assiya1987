Feature: User Login
  As a user
  I want to be able to log in to the website
  So that I can access the features on the platform using the profile I created before

  Background:
    Given I am on the homepage of the website

  Scenario: User can log in with valid credentials
    When I click the "Login" button
    And I enter valid email and password
    And I click the "Login" button
    Then I should be successfully logged in

  @LoginNegative
  Scenario: User cannot log in with invalid credentials
    When I click the "Login" button
    And I enter invalid email and password
    And I click the "Login" button
    Then I should see an error message