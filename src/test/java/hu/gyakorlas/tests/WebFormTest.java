package hu.gyakorlas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebFormTest {

    private WebDriver driver;

    @BeforeEach
    void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.getBoolean("headless")) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test
    void shouldAcceptText() {
        // Arrange: open the form and wait for the editable text field.
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement textInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.name("my-text")));
        String expectedText = "Selenium gyakorlas";

        // Act: replace the field contents with the test data.
        textInput.clear();
        textInput.sendKeys(expectedText);

        // Assert: read the current input value from the browser.
        assertEquals(expectedText, textInput.getDomProperty("value"),
                "The text field should contain exactly the entered text.");
    }

    @AfterEach
    void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
