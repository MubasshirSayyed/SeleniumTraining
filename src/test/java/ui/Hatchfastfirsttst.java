package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.Set;

public class Hatchfastfirsttst {
    public static void main(String[] args) throws InterruptedException {

        // Setup Firefox driver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Open the URL
        driver.get("https://hatchfast.dev/");

        // Wait until the navigation element is visible and hover + click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mousehover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav//ul/li/a")));

        Actions action = new Actions(driver);
        action.moveToElement(mousehover).perform(); // Mouse hover
        Thread.sleep(1000); // Optional wait to see hover effect
        mousehover.click(); // Click after hover

        // Handle window switching
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Fill form details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nf-field-1"))).sendKeys("Sayyed");
        driver.findElement(By.id("nf-field-2")).sendKeys("Sayyed1@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("nf-field-5")).sendKeys("91-9325376352");

        // Handle dropdown selection using sendKeys + Enter
        WebElement country = driver.findElement(By.id("nf-field-6"));
        country.sendKeys("India");
        country.sendKeys(Keys.ENTER);

        driver.findElement(By.id("nf-field-3")).sendKeys("Hi I am Mubasshir..");
        driver.findElement(By.id("nf-field-7")).sendKeys("HatchFast");

        // Scroll to submit button properly using JavascriptExecutor
        WebElement submitButton = driver.findElement(By.id("nf-field-4"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(1000); // Short pause after scrolling

        // Wait until the submit button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

        // Optional: Wait to see the result
        Thread.sleep(5000);

        // Close the driver
        driver.quit();
    }
}
