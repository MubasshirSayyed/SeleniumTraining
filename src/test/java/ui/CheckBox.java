package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		WebElement scrol = driver.findElement(By.id("gform_submit_button_1"));
		Actions actions = new Actions(driver);
		actions.moveToElement(scrol);
		actions.perform();
		driver.findElement(By.name("input_12.1")).click();
		driver.findElement(By.name("input_12.1")).isSelected();
		Thread.sleep(2000);
		driver.findElement(By.name("input_12.1")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
