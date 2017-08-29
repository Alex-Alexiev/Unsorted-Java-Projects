import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.AWTException;
import java.awt.Robot;

public class Main {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/Users/aalexiev/Google Drive/Programming/Selenium/Chrome_Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.ca");
		Robot r = new Robot();
		while(true){
			driver.findElement(By.id("t")).sendKeys(Keys.SPACE);
			System.out.println(r.getPixelColor(1000, 600));
		}
	}
}
