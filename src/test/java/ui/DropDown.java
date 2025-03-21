package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
//		WebElement dropdown = driver.findElement(By.name("input_8"));
//		Select select = new Select(dropdown);
//
//		select.selectByValue("level1");
//		Thread.sleep(2000);
//
//		select.selectByVisibleText("51 - 100 employees");
//		Thread.sleep(2000);
//
//		select.selectByIndex(5);
//		Thread.sleep(2000);

		WebElement dropdown = driver.findElement(By.className("inline_grid choices"));
		Select select = new Select(dropdown);
		select.selectByValue("CheckBox-0");
		Thread.sleep(2000);
		select.selectByIndex(4);
		Thread.sleep(2000);
		List<WebElement> allItem = select.getAllSelectedOptions();
		System.out.println(allItem.size());
		Thread.sleep(2000);
		select.deselectAll();
		Thread.sleep(2000);
		select.selectByValue("CheckBox-0");
		Thread.sleep(2000);
		select.selectByIndex(4);
		Thread.sleep(2000);
		select.deselectByIndex(5);
		Thread.sleep(2000);
		List<WebElement> allItems = select.getAllSelectedOptions();
		System.out.println(allItems.size());
		Thread.sleep(2000);
System.out.println();
		// driver.close();
	}
}
