@jsonplaceholder
Feature: JSONPlaceholder API Tests
  This feature tests the JSONPlaceholder API endpoints

  Background:
    * def Helper = Java.type('com.api.tests.utils.Helper')
    * url 'https://jsonplaceholder.typicode.com'

  Scenario: Test GET post by ID
    Given path '/posts/1'
    When method get
    Then status 200
    * Helper.validateStatusCode(response, 200)
    * Helper.validateHeader(response, 'Content-Type', 'application/json; charset=utf-8')
    * Helper.validateJsonSchema(response, 'src/test/resources/schemas/post-schema.json')
    
    # Validate specific fields
    * match response.userId == 1
    * match response.id == 1
    * match response.title == "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
    * match response.body contains "quia et suscipit"
    
    # Validate response time
    * def responseTime = responseTime()
    * assert responseTime < 1000 