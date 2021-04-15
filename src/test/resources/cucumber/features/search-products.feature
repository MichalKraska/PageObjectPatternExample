Feature: Search Products
  Scenario: Search valid product from landing page
    Given Landing page displayed
    When Search catalog for Mug
    Then At least one product found
    And All found products contain word Mug