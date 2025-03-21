package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkAll {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.salesforce.com/in/form/demo/starter-overview-demo/?d=jumbo2-btn-demo");
		List<WebElement> allTags = driver.findElements(By.tagName("option"));
		System.out.println("Total tags are" + allTags.size());

		for (int i = 0; i < allTags.size(); i++) {
			System.out.println("Links on Page are " + allTags.get(i).getText());
			//System.out.println("Links on Page are " + allTags.get(i).getText());
		}
		driver.close();
	}
}
