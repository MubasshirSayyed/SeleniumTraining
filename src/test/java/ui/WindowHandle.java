package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Set;

public class WindowHandle {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get("https://www.salesforce.com/in/");

		driver.findElement(By.xpath("//pbc-button[@data-link-text='Start free trial']/a")).click();
		Thread.sleep(4000);

		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.findElement(By.id("UserFirstName-B4Ak")).sendKeys("Award");
		driver.findElement(By.id("UserLastName-PZWc")).sendKeys("Anshuman");
		WebElement from = driver.findElement(By.name("UserTitle"));
		from.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		from.sendKeys(Keys.ENTER);

		driver.findElement(By.name("UserEmail")).sendKeys("Girgardhanghat11@gmail.com");
		driver.findElement(By.name("CompanyName")).sendKeys("HatchFast");

		WebElement selectEmployees = driver.findElement(By.name("CompanyEmployees"));
		selectEmployees.sendKeys(Keys.ARROW_DOWN);
		selectEmployees.sendKeys(Keys.ARROW_DOWN);
		selectEmployees.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		selectEmployees.sendKeys(Keys.ENTER);

		driver.findElement(By.name("UserPhone")).sendKeys("8765467987");

		Select selectCountry = new Select(driver.findElement(By.name("CompanyCountry")));
		selectCountry.selectByVisibleText("India");
		
		Select selectChoice = new Select(driver.findElement(By.id("formName-3hZM")));
		selectChoice.selectByVisibleText("I'd like to try customer support features");

		driver.findElement(By.xpath("//*[@id=\"SubscriptionAgreement\"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.name("start my free trial")).click();

		driver.quit();

	}
}
