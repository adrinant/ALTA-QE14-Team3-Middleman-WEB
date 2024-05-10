@Capstone @myProduct
Feature: My Product
  User can manage My Product

  #Positive - Supposed to be Fail
  @User @TC1
  Scenario Outline: User can Add product to cart based on Admin products
    Given User is already on Middleman Website
    When  User clicks Sign In Button
    And   User input "<email>" in Email field, "<password>" in Password field
    And   User clicks Sign In button
    Then  User should see an Alert "login success"
    When  User clicks OK on alert
    Then  User redirected to Middleman Dashboard
    When  User clicks Add button of "<productName>"
    Then  User should see an Alert "success"
    When  User clicks OK on alert
    And  User clicks My Cart
    Then  User should see the product that have been just added

    Examples:
      | email                    | password | productName                   |
      | shop1.middleman@mail.com | shop123  | Beras Premium Lahap Lele 5 kg |

  #Negative - Because User should not be able to add any product
  @User @TC2
  Scenario Outline: User can add a product from My Product
    Given  User is already on Middleman Website
    When   User clicks Sign In Button
    And    User input "<email>" in Email field, "<password>" in Password field
    And    User clicks Sign In button
    Then   User should see an Alert "login success"
    When   User clicks OK on alert
    Then   User redirected to Middleman Dashboard
    When   User refresh the Middleman Dashboard
    And    User clicks Add Product button
    Then   User should see Add Product Pop-Up
    When   User choose "<file>" for product image
    And    User input "<productName>" in Product Name Field, "<unit>" in Unit field, "<stock>" in Stock field, "<price>" in Price field
    And    User clicks Add Button
    Then   User should see an Alert "success adding a product"
    When   User clicks OK on alert
    Then   User should see the "<productName>" in My Product page

    Examples:
      | email                    | password | file        | productName              | unit | stock | price |
      | shop1.middleman@mail.com | shop123  | Harumas.jpg | HARUMAS Minyak Goreng 2L | 2L   | 10    | 30000 |

  #Negative
  @User @TC3
  Scenario Outline: User can decrease my product stock by clicking + button
    Given  User is already on Middleman Website
    When   User clicks Sign In Button
    And    User input "<email>" in Email field, "<password>" in Password field
    And    User clicks Sign In button
    Then   User should see an Alert "login success"
    When   User clicks OK on alert
    Then   User redirected to Middleman Dashboard
    When   User refresh the Middleman Dashboard
    And    User clicks + button on the "<productName>"
    Then   User should see an Alert "success creating a cart"
    When   User clicks OK on alert
    And    User clicks Outbound Menu
    Then   User should see the "<productName>" that has just been added
    When   User clicks Submit Button
    Then   User should see an Alert "success input data"
    When   User clicks OK on alert
    Then   User redirected to Middleman Dashboard
    And    User should see that the "<productName>" stock is decreased

    Examples:
      | email                    | password | productName                   |
      | shop1.middleman@mail.com | shop123  | Raja Platinum White Rice 5 kg |