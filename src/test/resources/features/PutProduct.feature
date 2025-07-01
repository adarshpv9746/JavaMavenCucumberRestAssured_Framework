Feature: Update products using the PUT API

  Scenario Outline: Validate the put product API status code
    Given I hit URL of the put products API endpoint
    When I pass the URL of products in the API with <ProductNumber>
    And I receive the response body with ID as <ProductNumber>
    Then I receive the response code as 200
    Examples:
      | ProductNumber |
      | 6             |