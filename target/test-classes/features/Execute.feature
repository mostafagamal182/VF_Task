Feature: User open link then go to card then check item

  Scenario:User navigate to amazon page and add item to cart
    Given user open twitter link
    When User type Gmail on login page 'Ahmed122@gmail.com'
    Then User click next button
    And User Added item to the cart
    And Text Appears 'Added to Cart' expected to be Text Appears Added to Cart


Scenario: User open today's deals and select items
  Given User open today's deals
  When Select from left side filter two elements
  And User Select discount 10% off or more
  And User go to fourth page and select any item and add it to the cart