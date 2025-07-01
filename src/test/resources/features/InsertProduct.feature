Feature: Insert products using the post API

  Scenario Outline: Validate the post product API status code
    Given I hit URL of the post products API endpoint
    When I pass the URL of products in the API
    And I pass the request body of the product title <ProductTitle>
    Then I receive the response code as 200
    Examples:
      | ProductTitle |
      | Shoes        |

  Scenario Outline: Validate the post product API response body
    Given I hit URL of the post products API endpoint
    When I pass the URL of products in the API
    And I pass the request body of the product title <ProductTitle>
    Then I receive the response body with ID as <ID>
    Examples:
      | ProductTitle | ID |
      | Shoes        | 21 |