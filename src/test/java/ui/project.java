package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class project {

    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to eBay
            driver.get("http://www.ebay.com");
            driver.manage().window().maximize();

            // Find the search input field and enter the search term
            driver.findElement(By.xpath("//*[@id='gh-ac']")).sendKeys("mobile phone");

            // Use WebDriverWait to wait for the search button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='gh-search-button btn btn--primary']")));

            // Click the search button
            searchButton.click();

            // Optionally, you can add a wait here to see the results
            Thread.sleep(5000); // Wait for 5 seconds to see the results (not recommended for production code)

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}