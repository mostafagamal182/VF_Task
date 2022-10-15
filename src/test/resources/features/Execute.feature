Feature: User open twitter then try to login

  Scenario:User navigate to amazon page and add item to cart
    Given user open twitter link
    When User type valid Email on login page 'Mahmoud3333@gmail.com'
    Then User click next button
    And User enter valid password in password field
    And Click on Login button


  Scenario:User navigate to amazon page and add item to cart
    Given user open twitter link
    When User type invalid Email on login page 'Mahmoud3'
    Then User click next button
    And User enter valid password in password field
    And Click on Login button

  Scenario:User navigate to amazon page and add item to cart
    Given user open twitter link
    When User type valid Email on login page 'Mahmoud3333@gmail.com'
    Then User click next button
    And User enter invalid password in password field
    And Click on Login button

  Scenario:User navigate to amazon page and add item to cart
    Given user open twitter link
    When User type invalid Email on login page 'Mahmoud3'
    Then User click next button
    And User enter invalid password in password field
    And Click on Login button
