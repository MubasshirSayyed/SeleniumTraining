package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webelement {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.name("user-name")).sendKeys("Testing");
		driver.findElement(By.name("user-name")).clear();
		System.out.println(driver.findElement(By.name("user-name")).getDomAttribute("class"));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getCssValue("background-color"));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getSize());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getLocation());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).getTagName());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"login-button\"]")).isSelected());
		
		driver.close();
	}
}
