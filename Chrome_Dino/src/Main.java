import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/aalexiev/Google Drive/Programming/Selenium/Chrome_Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.ca");
		Robot r = new Robot();
		driver.manage().window().maximize();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.id("t")).sendKeys(Keys.SPACE);
		while (true) {
			if (r.getPixelColor(800, 425).getRed() < 240){
				driver.findElement(By.id("t")).sendKeys(Keys.SPACE);
			}
			if (r.getPixelColor(1100, 380).getRed() < 100) {
				driver.findElement(By.id("t")).sendKeys(Keys.SPACE);
			}
		}
	}
}
