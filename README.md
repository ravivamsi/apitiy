# APITIY (API Test IT Yourself)
A powerful API testing framework built with Karate DSL, combining the simplicity of Cucumber BDD with the power of JavaScript.

## Overview
APITIY is a comprehensive API testing framework that leverages Karate DSL to provide a powerful, yet simple way to test REST APIs. It combines the best of BDD (Behavior Driven Development) with the flexibility of JavaScript, making it an excellent choice for both developers and testers.

## Key Features
- **BDD Syntax**: Write tests in a human-readable format using Gherkin syntax
- **JSON/XML Support**: Native support for both JSON and XML request/response handling
- **Schema Validation**: Built-in support for JSON Schema and XML Schema validation
- **Response Validation**: Comprehensive response validation including status codes, headers, and body
- **Data-Driven Testing**: Support for data-driven testing using JSON/XML files
- **Parallel Execution**: Run tests in parallel for faster execution
- **Reporting**: Detailed HTML reports with request/response details
- **Logging**: Comprehensive logging for better debugging
- **Reusable Components**: Create reusable functions and scenarios
- **Environment Configuration**: Easy configuration for different environments

## Advantages Over Paid Tools

### 1. Cost-Effective
- **Free and Open Source**: No licensing costs
- **Community Support**: Active community and regular updates
- **No Vendor Lock-in**: Complete control over your test framework

### 2. Technical Advantages
- **JavaScript Integration**: Native JavaScript support for complex validations
- **No Additional Language**: Uses JavaScript instead of proprietary languages
- **Built-in Assertions**: Powerful built-in assertions for response validation
- **Performance**: Faster execution compared to many paid tools
- **CI/CD Integration**: Easy integration with CI/CD pipelines

### 3. Developer-Friendly
- **Code Reusability**: Better code organization and reusability
- **Version Control**: Better integration with version control systems
- **IDE Support**: Works well with popular IDEs
- **Debugging**: Better debugging capabilities with IDE integration

### 4. Testing Capabilities
- **API Testing**: Comprehensive API testing capabilities
- **Performance Testing**: Basic performance testing features
- **Security Testing**: Basic security testing capabilities
- **Mock Services**: Built-in support for mocking services

## Framework Structure
```
src/
├── test/
│   ├── java/
│   │   └── com/
│   │       └── api/
│   │           └── tests/
│   │               ├── utils/
│   │               │   └── Helper.java
│   │               └── JSONTestRunner.java
│   └── resources/
│       ├── features/
│       │   ├── sample.feature
│       │   └── jsonplaceholder.feature
│       ├── payloads/
│       │   ├── sample.json
│       │   └── sample.xml
│       └── schemas/
│           ├── user-schema.json
│           └── product-schema.xsd
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Installation
1. Clone the repository
2. Install dependencies:
```bash
mvn clean install
```

### Running Tests
Run all tests:
```bash
mvn test
```

Run specific feature:
```bash
mvn test -Dtest=JSONTestRunner#testAll
```

Run tests with specific tags:
```bash
mvn test -Dkarate.options="--tags @jsonplaceholder"
```

## Example Test
```gherkin
Feature: JSONPlaceholder API Tests

  Scenario: Test GET post by ID
    Given url 'https://jsonplaceholder.typicode.com'
    And path '/posts/1'
    When method get
    Then status 200
    * match response.userId == 1
    * match response.id == 1
```

## Best Practices
1. **Organize Tests**: Group related tests in feature files
2. **Use Tags**: Tag scenarios for better organization
3. **Reuse Code**: Create reusable functions in Helper class
4. **Validate Responses**: Always validate response schema
5. **Use Environment Config**: Configure different environments
6. **Log Effectively**: Use proper logging for debugging

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
