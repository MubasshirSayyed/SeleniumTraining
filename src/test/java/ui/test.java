
package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
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
        driver.get("https://www.nopcommerce.com/en/demo?srsltid=AfmBOoqOJhQ0_0Cfv4PpRk9YGstFmZPDKoCJVCegf3cbhjVKIOPcnBA2");
        driver.findElement(By.xpath("//html/body/div[7]/header/nav/ul/li[3]/span/span")).click();
    }
}

