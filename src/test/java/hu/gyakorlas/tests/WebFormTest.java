package hu.gyakorlas.tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebFormTest {

    private  WebDriver driver;

    @BeforeEach
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    /*
    @Test
    void shouldAcceptText() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textInput = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("my-text"))
        );

        String expectedText = "Selenium gyakorlas";
        textInput.clear();
        textInput.sendKeys(expectedText);

        String actualText = textInput.getDomProperty("value");

        assertEquals(expectedText, actualText,
            "The text input should contain exactly the entered text.");
    }
    */

    // Paraméterezett tesztelés
    @ParameterizedTest
    @ValueSource(strings = {
            "Selenium gyakorlas",
            "Árvíztűrő tükörfúrógép",
            " Selenium "
    })
    void shouldAcceptText(String expectedText) {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement textInput = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("my-text"))
        );
        textInput.click();
        textInput.sendKeys(expectedText);

        String actualText = textInput.getDomProperty("value");

        assertEquals(expectedText, actualText, "The text input should contain exactly the entered text");
    }

    @AfterEach
    void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}