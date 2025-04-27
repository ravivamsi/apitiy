package com.api.tests.utils;

import com.intuit.karate.Match;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {
    private static final Logger logger = LoggerFactory.getLogger(Helper.class);

    /**
     * Validates response status code
     * @param response The response object
     * @param expectedStatus Expected status code
     */
    public static void validateStatusCode(Object response, int expectedStatus) {
        Match.that(response).contains("status=" + expectedStatus);
        logger.info("Status code validation successful: {}", expectedStatus);
    }

    /**
     * Validates response headers
     * @param response The response object
     * @param headerName Header name to validate
     * @param expectedValue Expected header value
     */
    public static void validateHeader(Object response, String headerName, String expectedValue) {
        Match.that(response).contains("headers." + headerName + "=" + expectedValue);
        logger.info("Header validation successful for {}: {}", headerName, expectedValue);
    }

    /**
     * Validates JSON response body against a schema
     * @param response The response object
     * @param schemaPath Path to the JSON schema file
     */
    public static void validateJsonSchema(Object response, String schemaPath) {
        try {
            String schema = new String(Files.readAllBytes(Paths.get(schemaPath)));
            Match.that(response).contains(schema);
            logger.info("JSON schema validation successful");
        } catch (Exception e) {
            logger.error("Schema validation failed: {}", e.getMessage());
            throw new RuntimeException("Schema validation failed", e);
        }
    }

    /**
     * Validates XML response body against XSD schema
     * @param response The response object
     * @param xsdPath Path to the XSD schema file
     */
    public static void validateXmlSchema(Object response, String xsdPath) {
        try {
            String xsd = new String(Files.readAllBytes(Paths.get(xsdPath)));
            Match.that(response).contains(xsd);
            logger.info("XML schema validation successful");
        } catch (Exception e) {
            logger.error("XML schema validation failed: {}", e.getMessage());
            throw new RuntimeException("XML schema validation failed", e);
        }
    }

    /**
     * Validates JSON response body against expected values using regex
     * @param response The response object
     * @param jsonPath JSON path to validate
     * @param regex Regular expression pattern
     */
    public static void validateJsonWithRegex(Object response, String jsonPath, String regex) {
        Match.that(response).contains(jsonPath + "#regex " + regex);
        logger.info("JSON regex validation successful for path: {}", jsonPath);
    }

    /**
     * Validates XML response body against expected values using regex
     * @param response The response object
     * @param xpath XPath to validate
     * @param regex Regular expression pattern
     */
    public static void validateXmlWithRegex(Object response, String xpath, String regex) {
        Match.that(response).contains(xpath + "#regex " + regex);
        logger.info("XML regex validation successful for path: {}", xpath);
    }

    /**
     * Reads JSON payload from file
     * @param filePath Path to the JSON file
     * @return JSONObject containing the payload
     */
    public static JSONObject readJsonPayload(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONParser parser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
            return (JSONObject) parser.parse(content);
        } catch (Exception e) {
            logger.error("Failed to read JSON payload: {}", e.getMessage());
            throw new RuntimeException("Failed to read JSON payload", e);
        }
    }

    /**
     * Reads XML payload from file
     * @param filePath Path to the XML file
     * @return String containing the XML payload
     */
    public static String readXmlPayload(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            logger.error("Failed to read XML payload: {}", e.getMessage());
            throw new RuntimeException("Failed to read XML payload", e);
        }
    }
}
