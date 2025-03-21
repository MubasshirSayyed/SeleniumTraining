package ui;

import java.util.List; // Import List interface
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicWebdriverinterface {
	public static WebDriver driver;
	public static String browser = "Chrome";

	public static void main(String[] args) {
		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get("https://hatchfast.dev/");
		driver.manage().window().maximize();

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		String title = driver.getTitle();
		System.out.println(title);

		String pageSource = driver.getPageSource();
		System.out.println(pageSource);

		driver.navigate().to("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();

		List<WebElement> webelement = driver.findElements(By.xpath("//div[@class='inventory_list']/div"));
		System.out.println(webelement);

		driver.navigate().to("https://webflow.com/made-in-webflow/demo");
		String windowhandle = driver.getWindowHandle();
		System.out.println(windowhandle);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[1]/div[1]/a")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);

		//driver.close();
	}
}
