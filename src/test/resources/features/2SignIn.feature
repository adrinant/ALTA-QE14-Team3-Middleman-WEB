@Capstone @Auth
Feature: Authentication
  User can sign in to Middleman Web App

  @Login @TC1
  #Positive Sign In
  Scenario Outline: User sign in / log in to Middleman
    Given User is already on Middleman Website
    When  User clicks Sign In Button
    And   User input "<email>" in Email field, "<password>" in Password field
    And   User clicks Sign In button
    Then  User should see an Alert "login success"
    When  User clicks OK on alert
    Then  User redirected to Middleman Dashboard

    Examples:
      | email                     | password  |
      | admin.middleman@gmail.com | Admin123$ |
      | shop1.middleman@mail.com  | shop123   |

  @Login @TC2
  #Negative Sign In
  Scenario Outline: User sign in / log in to Middleman without completing form
    Given User is already on Middleman Website
    When  User clicks Sign In Button
    And   User input "<email>" in Email field, "<password>" in Password field
    And   User clicks Sign In button
    Then  User should see form "<elementName>" HTML Required Validation Message

    Examples:
      | email                    | password | elementName |
      |                          | shop123  | email       |
      | shop1.middleman@mail.com |          | password    |

  @Login @TC3
  #Positive Sign Out
  Scenario Outline: User can sign out from Middleman App
    Given User is already on Middleman Website
    When  User clicks Sign In Button
    And   User input "<email>" in Email field, "<password>" in Password field
    And   User clicks Sign In button
    Then  User should see an Alert "login success"
    When  User clicks OK on alert
    Then  User redirected to Middleman Dashboard
    When  User clicks profile button
    And   User clicks logout button
    Then  User should see Logout confirmation Pop-Up
    When  User clicks Yes Button
    Then  User redirected back to welcome page

    Examples:
      | email                     | password  |
      | admin.middleman@gmail.com | Admin123$ |