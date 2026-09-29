# Selenium Basics

A small practice project for learning web test automation with Java and Selenium.

The tests use Selenium's public Web Form page:
https://www.selenium.dev/selenium/web/web-form.html

The current exercises focus on basic browser interactions, element locators, waits, and assertions.

## Tech Stack

- Java 21
- Maven
- Selenium WebDriver
- JUnit 5
- Google Chrome

## Project Structure

- `src/test/java` - automated tests
- `src/main/java` - sample application created with the project
- `target` - generated build files and test reports

Test reports are generated in:

`target/surefire-reports`

## Running the Tests

Run all tests from the project root:

```bash
mvn test