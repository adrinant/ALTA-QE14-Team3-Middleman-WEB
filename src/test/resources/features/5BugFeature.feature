@Capstone @Broken
Feature: My Product
  Admin / user can manage My Product

  #Broken-Feature (Only test menu button)
  #The menu isnt working and Admin cant see anything on the incoming order product page
  @Admin @Broken @TC1
  Scenario Outline: Admin should be able to see all incoming order and accept the order
    Given  User is already on Middleman Website
    When   User clicks Sign In Button
    And    User input "<email>" in Email field, "<password>" in Password field
    And    User clicks Sign In button
    Then   User should see an Alert "login success"
    When   User clicks OK on alert
    Then   User redirected to Middleman Dashboard
    When   User clicks Incoming Order button
    Then   User should be redirected to incoming order page
    And    User should see any order placed by Users

    Examples:
      | email                     | password  |
      | admin.middleman@gmail.com | Admin123$ |

  #Broken but still hitable via API
  #The menu isnt functional and Admin cant see anything on the history order page, the endpoint is working if we hit via API
  @Admin @Broken @TC2
  Scenario Outline: Admin should be able to see History of the Order that have been accepted in Incoming Order page
    Given  User is already on Middleman Website
    When   User clicks Sign In Button
    And    User input "<email>" in Email field, "<password>" in Password field
    And    User clicks Sign In button
    Then   User should see an Alert "login success"
    When   User clicks OK on alert
    Then   User redirected to Middleman Dashboard
    When   User clicks History order button
    Then   User should be redirected to History Order page
    And    Admin should see "<orderID>" in the History Order

    Examples:
      | email                     | password  | orderID    |
      | admin.middleman@gmail.com | Admin123$ | 1715092409 |

  #The menu isnt functional and User cant see anything on the history order page, the endpoint is working if we hit via API
  @Admin @Broken @TC3
  Scenario Outline: User should be able to see their order history on the History Order page
    Given  User is already on Middleman Website
    When   User clicks Sign In Button
    And    User input "<email>" in Email field, "<password>" in Password field
    And    User clicks Sign In button
    Then   User should see an Alert "login success"
    When   User clicks OK on alert
    Then   User redirected to Middleman Dashboard
    When   User clicks History order button
    Then   User should be redirected to History Order page
    And    User should see "<orderID>" in the History Order

    Examples:
      | email                    | password | orderID    |
      | shop1.middleman@mail.com | shop123  | 1715092409 |