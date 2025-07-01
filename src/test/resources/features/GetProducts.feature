Feature: Get all products from the API

  Scenario: verify the get API for the products
    Given I hit URL of the get products API endpoint
    When I pass the URL of products in the API
    Then I receive the response code as 200

  Scenario Outline: Verify the rate of the first product is correct
    Given I hit URL of the get products API endpoint
    When I pass the URL of products in the API
    Then I Verify that the rate of the first product is <FirstProductRate>
    Examples:
      |FirstProductRate|
      |3.9             |
