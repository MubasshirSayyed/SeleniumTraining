package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Resize {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Open the URL
        driver.get("https://jqueryui.com/slider/");

        // Switch to frame
        WebElement frame = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(frame);

        // Locate the resize handle (bottom-right corner)
        WebElement resizeHandle = driver.findElement(By.cssSelector(".ui-resizable-se"));

        // Perform the resize action
        Actions action = new Actions(driver);
        action.clickAndHold(resizeHandle).moveByOffset(300, 100).release().perform();

        // Optional: Wait to see the result
        Thread.sleep(3000);

        // Close the driver
        driver.quit();
    }
}
