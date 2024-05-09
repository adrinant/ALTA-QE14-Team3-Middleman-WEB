@Capstone @Auth
Feature: Authentication
  User can sign up to Middleman Web App

  @SignUp @TC1
  #Sign Up Positive
  Scenario Outline: User sign up to Middleman
    Given User is already on Middleman Website
    When  User clicks the sign-up button
    Then  User is redirected to the registration page
    When  User inputs "<shopName>" in Shop Name field, "<email>" in Email field, "<phoneNumber>" in Phone Number field, "<password>" in Password field, "<address>" in Address field
    And   User clicks the sign-up button
    Then  User should see an Alert "register success"
    When  User clicks OK on alert
    Then  User is redirected to login page

    Examples:
      | shopName | email                     | phoneNumber  | password | address |
      | shop20   | shop20.middleman@mail.com | 082010112230 | shop123  | Jakarta |