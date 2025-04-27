Feature: Sample API Tests
  This feature demonstrates the usage of API testing utilities

  Background:
    * def Helper = Java.type('com.api.tests.utils.Helper')
    * def jsonPayload = Helper.readJsonPayload('src/test/resources/payloads/sample.json')
    * def xmlPayload = Helper.readXmlPayload('src/test/resources/payloads/sample.xml')
    * url baseUrl

  Scenario: Test JSON API endpoints
    Given path '/users'
    And request jsonPayload
    When method post
    Then status 201
    * Helper.validateStatusCode(response, 201)
    * Helper.validateHeader(response, 'Content-Type', 'application/json')
    * Helper.validateJsonSchema(response, 'src/test/resources/schemas/user-schema.json')
    * Helper.validateJsonWithRegex(response, '$.name', '^[A-Za-z\\s]+$')

  Scenario: Test XML API endpoints
    Given path '/products'
    And request xmlPayload
    When method post
    Then status 201
    * Helper.validateStatusCode(response, 201)
    * Helper.validateHeader(response, 'Content-Type', 'application/xml')
    * Helper.validateXmlSchema(response, 'src/test/resources/schemas/product-schema.xsd')
    * Helper.validateXmlWithRegex(response, '/product/sku', '^[A-Z0-9]{10}$') 