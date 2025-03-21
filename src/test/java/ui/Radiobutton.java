package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Radiobutton {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.singaporeair.com/en_UK/in/home#/book/bookflight");

		WebElement radio2 = driver.findElement(By.id("redeemFlights"));
		WebElement radio1 = driver.findElement(By.id("bookFlights"));

		radio1.click();

		System.out.println(" Radio1 Button selected " + radio1.isSelected());
		System.out.println(" Radio2 Button selected " + radio2.isSelected());

		System.out.println(driver.findElement(By.xpath("//*[@name='book-flight-radio']")).getSize());

		driver.close();
	}
}
