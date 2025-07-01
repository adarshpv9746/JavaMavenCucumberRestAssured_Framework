Feature: Delete products using the PUT API

  Scenario Outline: Validate the delete product API status code
    Given I hit URL of the delete products API endpoint
    When I pass the URL of products to be deleted in the API with <ProductNumber>
    And I receive the response body with ID as <ProductNumber>
    Then I receive the response code as 200
    Examples:
      | ProductNumber |
      | 6             |