package ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class iframe {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");

		WebElement frame1 = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(2000);

		Alert alertonpage = driver.switchTo().alert();
		alertonpage.sendKeys("Moan");
		Thread.sleep(2000);
		alertonpage.accept();

		driver.switchTo().parentFrame();
		System.out.println("Page Title: " + driver.getTitle());
		Thread.sleep(2000);
		driver.close();

	}
}
