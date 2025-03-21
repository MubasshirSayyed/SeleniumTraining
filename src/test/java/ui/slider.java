package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class slider {
	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		// Open the URL
		driver.get("https://jqueryui.com/slider/#colorpicker");

		// Wait for frame to load and switch to it
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".demo-frame")));
		driver.switchTo().frame(frame);

		// Locate the red slider handle using a robust selector
		WebElement redSlider = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='red']//span")));

		// Perform the slider action (horizontal movement)
		Actions action1 = new Actions(driver);
		action1.clickAndHold(redSlider).moveByOffset(-25, 0).release().perform(); // Adjust the offset as needed

		// Locate the green slider handle using a robust selector
		WebElement greenSlider = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='green']//span")));

		// Perform the slider action (horizontal movement)
		Actions action2 = new Actions(driver);
		action2.clickAndHold(greenSlider).moveByOffset(85, 0).release().perform(); // Adjust the offset as needed

		// Locate the blue slider handle using a robust selector
		WebElement blueSlider = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='blue']//span")));

		// Perform the slider action (horizontal movement)
		Actions action3 = new Actions(driver);
		action3.clickAndHold(blueSlider).moveByOffset(-10, 0).release().perform(); // Adjust the offset as needed

		// Optional: Wait to see the result
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Close the driver
		driver.quit();
	}
}
