@Capstone @myProduct
Feature: My Product
  Admin can manage My Product

  #Admin
  #Positive My Product
  @Admin @TC1
  Scenario Outline: Admin can add a product from My Product
    Given User is already on Middleman Website
    When  User clicks Sign In Button
    And   User input "<email>" in Email field, "<password>" in Password field
    And   User clicks Sign In button
    Then  User should see an Alert "login success"
    When  User clicks OK on alert
    Then  User redirected to Middleman Dashboard
    When  User clicks Add Product button
    Then  User should see Add Product Pop-Up
    When  User choose "<file>" for product image
    And   User input "<productName>" in Product Name Field, "<unit>" in Unit field, "<stock>" in Stock field, "<price>" in Price field
    And   User clicks Add Button
    Then  User should see an Alert "success adding a product"
    When  User clicks OK on alert
    Then  User should see the "<productName>" in My Product page

    #Change productName if internal error happens
    Examples:
      | email                     | password  | file         | productName                     | unit  | stock | price |
      | admin.middleman@gmail.com | Admin123$ | GulaAren.jpg | Gula Aren Bubuk Organik 500 gr  | 500gr | 10    | 25000 |
      | admin.middleman@gmail.com | Admin123$ | Indomie.jpg  | Sasa Tepung Ayam Kentucky 850gr | 850gr | 5     | 17000 |

  #Admin
  #Negative My Product
  @Admin @TC2
  Scenario Outline: Admin add product without completing Product details
    Given User is already on Middleman Website
    When  User clicks Sign In Button
    And   User input "<email>" in Email field, "<password>" in Password field
    And   User clicks Sign In button
    Then  User should see an Alert "login success"
    When  User clicks OK on alert
    Then  User redirected to Middleman Dashboard
    When  User clicks Add Product button
    Then  User should see Add Product Pop-Up
    When  User choose "<file>" for product image
    And   User input "<productName>" in Product Name Field, "<unit>" in Unit field, "<stock>" in Stock field, "<price>" in Price field
    And   User clicks Add Button
    Then  User should see product "<elementName>" HTML Required Validation Message

    Examples:
      | email                     | password  | file          | productName                   | unit | stock | price | elementName |
      | admin.middleman@gmail.com | Admin123$ | BerasRaja.jpg |                               | 1kg  | 50    | 15000 | name        |
      | admin.middleman@gmail.com | Admin123$ | BerasRaja.jpg | Raja Platinum White Rice 5 kg | 1kg  |       | 15000 | stock       |
      | admin.middleman@gmail.com | Admin123$ | BerasRaja.jpg | Raja Platinum White Rice 5 kg | 1kg  | 50    |       | price       |

  #Separated because for input image & unit appears alert instead of HTML validation message
  @Admin @TC2.1
  Scenario Outline: Admin add product without completing Product details
    Given User is already on Middleman Website
    When  User clicks Sign In Button
    And   User input "<email>" in Email field, "<password>" in Password field
    And   User clicks Sign In button
    Then  User should see an Alert "login success"
    When  User clicks OK on alert
    Then  User redirected to Middleman Dashboard
    When  User clicks Add Product button
    Then  User should see Add Product Pop-Up
    When  User choose "<file>" for product image
    And   User input "<productName>" in Product Name Field, "<unit>" in Unit field, "<stock>" in Stock field, "<price>" in Price field
    And   User clicks Add Button
    Then  User should see an Alert "<alert>"
    When  User clicks OK on alert
    Then  User redirected to Middleman Dashboard

    Examples:
      | email                     | password  | file          | productName                   | unit | stock | price | elementName | alert                      |
      | admin.middleman@gmail.com | Admin123$ |               | Raja Platinum White Rice 5 kg | 1kg  | 50    | 15000 | image       | TypeError: Failed to fetch |
      | admin.middleman@gmail.com | Admin123$ | BerasRaja.jpg | Raja Platinum White Rice 5 kg |      | 50    | 15000 | unit        | wrong input                |

  #Positive
  @Admin @TC3
  Scenario Outline: Admin can increase my product stock by clicking + button
    Given User is already on Middleman Website
    When  User clicks Sign In Button
    And   User input "<email>" in Email field, "<password>" in Password field
    And   User clicks Sign In button
    Then  User should see an Alert "login success"
    When  User clicks OK on alert
    Then  User redirected to Middleman Dashboard
    When  User clicks + button on the "<productName>"
    Then  User should see an Alert "success creating a cart"
    When  User clicks OK on alert
    And   User clicks Inbound Menu
    Then  User should see the "<productName>" that has just been added
    When  User clicks Submit Button
    Then  User should see an Alert "success input data"
    When  User clicks OK on alert
    Then  User redirected to Middleman Dashboard
    And   User should see that the "<productName>" stock is increased

    Examples:
      | email                     | password  | productName                   |
      | admin.middleman@gmail.com | Admin123$ | Beras Premium Lahap Lele 5 kg |